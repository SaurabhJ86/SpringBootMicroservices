package com.jhingan.SpringBootMicroservices.dao;

import com.jhingan.SpringBootMicroservices.dto.Specimen;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpecimenDAOStub implements ISpecimenDAO{

    List<Specimen> allSpecimens = new ArrayList<Specimen>();
    @Override
    public Specimen save(Specimen specimen) {
        allSpecimens.add(specimen);
        return specimen;
    }

    @Override
    public List<Specimen> fetchAll() {
        return allSpecimens;
    }
}
