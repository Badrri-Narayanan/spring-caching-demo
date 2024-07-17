package com.location.map.service;

import static com.location.map.utils.CachingUtils.longOperation;

import com.location.map.entity.City;
import com.location.map.entity.Country;
import com.location.map.exception.CountryNotFoundException;
import com.location.map.repository.CountryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CountryService {
    private CountryRepository countryRepository;
    private CityService cityService;
    private List<Country> countriesVisited = new ArrayList<>();

    @Cacheable("all-countries")
    public List<Country> getAllCountries() {
        log.info("Fetching all countries using DB");
        longOperation();
        return countryRepository.findAll();
    }

    @Cacheable(value = "country", unless = "#result.code == 'US'")
    public Country getCountryByCode(String countryCode) {
        log.info("Fetching country by code: {} using DB", countryCode);

        Optional<Country> country = countryRepository.findById(countryCode);
        validateCountry(countryCode, country);

        return country.orElse(null);
    }

    @Cacheable(value="addresses", condition="#countryCode=='IN'")
    public City getCapitalCity(String countryCode) {
        return cityService.getCapitalCityByCountryCode(countryCode);
    }

    @CachePut(value="countries-visited")
    public String visitCountry(String countryCode) {
        Optional<Country> country = countryRepository.findById(countryCode);

        validateCountry(countryCode, country);

        countriesVisited.add(country.orElse(null));
        return "Visited " + country.get().getName() + " successfully";
    }

    @Cacheable("countries-visited")
    public List<Country> countriesVisited() {
        longOperation();
        return countriesVisited;
    }

    private static void validateCountry(final String countryCode, final Optional<Country> country) {
        if(country.isEmpty())
            throw new CountryNotFoundException("Country with code " + countryCode + " not found");
    }
}
