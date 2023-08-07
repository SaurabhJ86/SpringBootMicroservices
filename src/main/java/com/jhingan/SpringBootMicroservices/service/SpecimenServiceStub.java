package com.jhingan.SpringBootMicroservices.service;

import com.jhingan.SpringBootMicroservices.dao.ISpecimenDAO;
import com.jhingan.SpringBootMicroservices.dto.Specimen;
import org.springframework.stereotype.Service;

@Service
public class SpecimenServiceStub implements ISpecimenService{

    private ISpecimenDAO specimenDAO;

    public SpecimenServiceStub(){};

    public SpecimenServiceStub(ISpecimenDAO specimenDAO)
    {

        this.specimenDAO = specimenDAO;
    }
    @Override
    public Specimen fetchById(int id) {
        Specimen specimen = new Specimen();
        specimen.setDescription("Eastern Redbud");
        specimen.setSpecimenId("83");
        return specimen;
    }

    @Override
    public Specimen save(Specimen specimen) throws Exception {
        return this.specimenDAO.save(specimen);
    }
}
