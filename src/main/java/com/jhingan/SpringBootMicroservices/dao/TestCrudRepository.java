package com.jhingan.SpringBootMicroservices.dao;

import com.jhingan.SpringBootMicroservices.dto.Specimen;
import org.springframework.data.repository.CrudRepository;

public interface TestCrudRepository extends CrudRepository<Specimen, String> {
}
