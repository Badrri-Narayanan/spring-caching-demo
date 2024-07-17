package com.location.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    private String code;
    private String name;
    private String countryCode;
    private boolean isCapital;
}
