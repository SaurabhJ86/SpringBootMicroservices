package com.jhingan.SpringBootMicroservices.dao;

import com.jhingan.SpringBootMicroservices.dto.Plant;

import java.io.IOException;
import java.util.List;

public interface IPlantDAO {
    List<Plant> fetchPlants(String combinedName) throws IOException;
}
