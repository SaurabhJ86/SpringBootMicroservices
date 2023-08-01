package com.jhingan.SpringBootMicroservices.service;

import com.jhingan.SpringBootMicroservices.dto.Specimen;

public interface ISpecimenService {
    /**
     * Fetch a specimen with a given ID.
     * @param id a unique identifier for a specimen.
     * @return the matching specimen, or null if no matches found.
     */
    Specimen fetchById(int id);
}