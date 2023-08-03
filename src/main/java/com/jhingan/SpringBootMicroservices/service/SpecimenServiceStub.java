package com.jhingan.SpringBootMicroservices.service;

import com.jhingan.SpringBootMicroservices.dto.Specimen;
import org.springframework.stereotype.Service;

@Service
public class SpecimenServiceStub implements ISpecimenService{
    @Override
    public Specimen fetchById(int id) {
        Specimen specimen = new Specimen();
        specimen.setDescription("Eastern Redbud");
        specimen.setSpecimenId("83");
        return specimen;
    }
}
