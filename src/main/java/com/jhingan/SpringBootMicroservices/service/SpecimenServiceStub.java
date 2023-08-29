package com.jhingan.SpringBootMicroservices.service;

import com.jhingan.SpringBootMicroservices.dao.IPlantDAO;
import com.jhingan.SpringBootMicroservices.dao.ISpecimenDAO;
import com.jhingan.SpringBootMicroservices.dto.Plant;
import com.jhingan.SpringBootMicroservices.dto.Specimen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SpecimenServiceStub implements ISpecimenService{

    @Autowired
    private ISpecimenDAO specimenDAO;
    @Autowired
    private IPlantDAO plantDAO;

    public SpecimenServiceStub(){};

    public SpecimenServiceStub(ISpecimenDAO specimenDAO)
    {

        this.specimenDAO = specimenDAO;
    }
    @Override
    public Specimen fetchById(int id) {
        Specimen specimen = specimenDAO.fetch(id);
        return specimen;
    }

    @Override
    public void deleteById(int id) throws Exception {
        specimenDAO.deleteById(id);
    }

    @Override
    public Specimen save(Specimen specimen) throws Exception {
        return this.specimenDAO.save(specimen);
    }

    @Override
    public List<Specimen> fetchAll() {
        return this.specimenDAO.fetchAll();
    }

    @Override
    public List<Plant> fetchPlants(String combinedName) throws IOException {
        return plantDAO.fetchPlants(combinedName);
    }
}
