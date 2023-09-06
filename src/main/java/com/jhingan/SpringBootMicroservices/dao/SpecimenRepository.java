package com.jhingan.SpringBootMicroservices.dao;

import com.jhingan.SpringBootMicroservices.dto.Specimen;
import org.springframework.data.repository.CrudRepository;

public interface SpecimenRepository extends CrudRepository<Specimen, Integer> {
}
