package com.location.map.controller;

import com.location.map.entity.City;
import com.location.map.entity.Country;
import com.location.map.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @Operation(summary = "Get all countries", description = "Retrieve a list of all countries available in the database.")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Country[].class)))
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @Operation(summary = "Get country by code", description = "Retrieve a country by its unique code.")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Country.class)))
    @ApiResponse(responseCode = "404", description = "Country not found")
    @GetMapping("/country")
    public Country getCountryByCode(@RequestParam @NotBlank String countryCode) {
        return countryService.getCountryByCode(countryCode);
    }

    @Operation(summary = "Get capital city by country code", description = "Retrieve the capital city of a country using the country's unique code.")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = City.class)))
    @ApiResponse(responseCode = "404", description = "Capital city not found")
    @GetMapping("/country/capital")
    public City getCapitalCity(@RequestParam String countryCode) {
        return countryService.getCapitalCity(countryCode);
    }

    @Operation(summary = "Visit a country", description = "Add a country to the list of visited countries.")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "404", description = "Country not found")
    @GetMapping("/country/visit")
    public String visitCountry(@RequestParam @NotBlank String countryCode) {
        return countryService.visitCountry(countryCode);
    }

    @Operation(summary = "Get visited countries", description = "Retrieve a list of countries that have been visited.")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Country[].class)))
    @GetMapping("/countries/fetch-visited")
    public List<Country> countriesVisited() {
        return countryService.countriesVisited();
    }
}
