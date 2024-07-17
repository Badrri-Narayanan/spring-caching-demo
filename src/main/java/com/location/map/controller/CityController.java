package com.location.map.controller;

import com.location.map.entity.City;
import com.location.map.service.CityService;
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
public class CityController {
    private CityService cityService;

    @Operation(summary = "Get all cities", description = "Retrieve a list of all cities available in the database.")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = City[].class)))
    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }


    @Operation(summary = "Get cities by country code", description = "Retrieve cities by their country code.")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = City[].class)))
    @GetMapping("/cities/country")
    public List<City> getCitiesByCountryCode(@RequestParam @NotBlank String countryCode) {
        return cityService.getCitiesByCountryCode(countryCode);
    }
}
