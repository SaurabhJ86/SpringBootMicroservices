package com.jhingan.SpringBootMicroservices.service;

import com.jhingan.SpringBootMicroservices.dto.Specimen;
import org.springframework.stereotype.Component;

@Component
public class SpecimenServiceStub implements ISpecimenService{
    @Override
    public Specimen fetchById(int i) {
        Specimen specimen = new Specimen();
        specimen.setDescription("Eastern RedBud");
        specimen.setSpecimenId("83");
        return specimen;
    }
}
