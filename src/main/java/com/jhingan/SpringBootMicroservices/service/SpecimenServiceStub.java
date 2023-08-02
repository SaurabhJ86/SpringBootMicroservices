package com.jhingan.SpringBootMicroservices.service;

import com.jhingan.SpringBootMicroservices.dao.ISpecimenDAO;
import com.jhingan.SpringBootMicroservices.dto.Specimen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecimenServiceStub implements ISpecimenService{

    @Autowired
    private ISpecimenDAO specimenDAO;

    public SpecimenServiceStub() {

    }

    public SpecimenServiceStub(ISpecimenDAO specimenDAO) {

        this.specimenDAO = specimenDAO;
    }
    @Override
    public Specimen fetchById(int i) {
        Specimen specimen = new Specimen();
        specimen.setDescription("Eastern RedBud");
        specimen.setSpecimenId("83");
        return specimen;
    }

    @Override
    public Specimen save(Specimen specimen) {
        return specimenDAO.save(specimen);
    }

    @Override
    public List<Specimen> fetchAll() {
        return specimenDAO.fetchAll();
    }
}
