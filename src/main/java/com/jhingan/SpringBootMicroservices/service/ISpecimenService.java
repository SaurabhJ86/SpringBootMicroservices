package com.jhingan.SpringBootMicroservices.service;

import com.jhingan.SpringBootMicroservices.dto.Plant;
import com.jhingan.SpringBootMicroservices.dto.Specimen;

import java.io.IOException;
import java.util.List;

public interface ISpecimenService {
    /**
     * Fetch a specimen for the given id
     * @param id a unique identifier for the specimen
     * @return specimen object if found, else NotFoundException
     */

    Specimen fetchById(int id);

    void deleteById(int id) throws Exception;

    Specimen save(Specimen specimen) throws Exception;

    List<Specimen> fetchAll();

    List<Plant> fetchPlants(String combinedName) throws IOException;
}
