package com.jhingan.SpringBootMicroservices.service;

import com.jhingan.SpringBootMicroservices.dto.Specimen;

public interface ISpecimenService {
    /**
     * Fetch a specimen for the given id
     * @param id a unique identifier for the specimen
     * @return specimen object if found, else NotFoundException
     */

    Specimen fetchById(int id);

    Specimen save(Specimen specimen) throws Exception;
}
