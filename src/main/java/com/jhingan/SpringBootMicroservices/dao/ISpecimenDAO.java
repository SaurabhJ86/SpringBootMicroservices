package com.jhingan.SpringBootMicroservices.dao;

import com.jhingan.SpringBootMicroservices.dto.Specimen;

public interface ISpecimenDAO {
    Specimen save(Specimen specimen) throws Exception;
}
