package com.location.map.service;

import com.location.map.entity.City;
import com.location.map.repository.CityRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CityService {

    public static final String CITIES_CACHE = "cities";
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Cacheable(CITIES_CACHE)
    public List<City> getCitiesByCountryCode(String countryCode) {
        log.info("Fetching cities by country code: {} using DB", countryCode);
        return cityRepository.findByCountryCode(countryCode);
    }

    public City getCapitalCityByCountryCode(String countryCode) {
        log.info("Fetching capital city by country code: {} using DB", countryCode);
        return cityRepository.findCityByCountryCodeAndIsCapitalIsTrue(countryCode).orElse(null);
    }
}
