package com.jhingan.SpringBootMicroservices.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Specimen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int specimenId;
    private int plantId;
    private String latitude;
    private String longitude;
    private String description;
}
