package com.jhingan.SpringBootMicroservices.dao;

import com.jhingan.SpringBootMicroservices.dto.Specimen;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SpecimenDAOStub implements ISpecimenDAO{

    Map<Integer, Specimen> allSpecimens = new HashMap<>();
    @Override
    public Specimen save(Specimen specimen) {
        allSpecimens.put(Integer.parseInt(specimen.getSpecimenId()), specimen);
        return specimen;
    }

    @Override
    public List<Specimen> fetchAll() {
        List<Specimen> fetchAllSpecimens = new ArrayList<>(allSpecimens.values());
        return fetchAllSpecimens;
    }

    @Override
    public Specimen fetch(int id) {
        return allSpecimens.get(id);
    }

    @Override
    public void delete(int id) {
        allSpecimens.remove(id);
    }
}
