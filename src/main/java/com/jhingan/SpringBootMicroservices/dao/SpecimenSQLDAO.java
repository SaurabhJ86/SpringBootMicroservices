package com.jhingan.SpringBootMicroservices.dao;

import com.jhingan.SpringBootMicroservices.dto.Specimen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("specimenDAO")
public class SpecimenSQLDAO implements  ISpecimenDAO{

    @Autowired
    SpecimenRepository specimenRepository;
//    TestCrudRepository testCrudRepository;

    @Override
    public Specimen save(Specimen specimen) throws Exception {
        Specimen savedSpecimen = specimenRepository.save(specimen);
        return savedSpecimen;
    }

    @Override
    public List<Specimen> fetchAll() {
        return null;
    }

    @Override
    public Specimen fetch(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
