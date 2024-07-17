package com.location.map.repository;

import com.location.map.entity.City;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    public Optional<City> findCityByCountryCodeAndIsCapitalIsTrue(String countryCode);

    public List<City> findByCountryCode(String countryCode);
}
