package com.jhingan.SpringBootMicroservices.dao;

import com.jhingan.SpringBootMicroservices.dto.Specimen;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SpecimenDAOStub implements ISpecimenDAO{

    Map<Integer, Specimen> specimens = new HashMap<>();
    @Override
    public Specimen save(Specimen specimen) throws Exception {
        Integer specimenId = Integer.parseInt(specimen.getSpecimenId());
        specimens.put(specimenId,specimen);
        return specimen;
    }

    @Override
    public List<Specimen> fetchAll() {
        return new ArrayList<>(specimens.values());
    }

    @Override
    public Specimen fetch(int id) {

        return specimens.get(id);
    }

    @Override
    public void deleteById(int id) {
        specimens.remove(id);
    }
}
