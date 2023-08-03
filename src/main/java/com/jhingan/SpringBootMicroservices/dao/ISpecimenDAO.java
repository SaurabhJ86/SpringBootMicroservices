package com.jhingan.SpringBootMicroservices.dao;

import com.jhingan.SpringBootMicroservices.dto.Specimen;

import java.util.List;

public interface ISpecimenDAO {
    Specimen save(Specimen specimen);

    List<Specimen> fetchAll();

    Specimen fetch(int id);

    void delete(int id);
}
