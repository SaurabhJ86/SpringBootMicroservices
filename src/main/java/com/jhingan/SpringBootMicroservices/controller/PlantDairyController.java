package com.jhingan.SpringBootMicroservices.controller;

import com.jhingan.SpringBootMicroservices.dto.Specimen;
import com.jhingan.SpringBootMicroservices.service.ISpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The controller for Plant Diary REST Endpoints
 * <p>
 *     This class handles the CRUD Operations for the Plant Diary Specimens via HTTP Actions
 * </p>
 * @author Saurabh Jhingan
 * @version 1.0.0-SNAPSHOT
 */

@RestController
public class PlantDairyController {

    @Autowired
    ISpecimenService specimenService;

    @RequestMapping("/")
    public String index()
    {
        return "start";
    }

    @RequestMapping("/lookup/{id}")
    public ResponseEntity index(@PathVariable("id") String id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_PLAIN);
        ResponseEntity responseEntity = new ResponseEntity("Your number: " + id, httpHeaders, HttpStatus.FORBIDDEN);
        return responseEntity;
    }

    @GetMapping("/specimen")
    @ResponseBody
    public List<Specimen> fetchAllSpecimen()
    {
        List<Specimen> specimens = specimenService.fetchAll();
        return specimens;
    }

    /**
     * Retyrns a list of specimen object, given the id provided
     *
     * Returns one of the following codes:
     * 200: Successfully returned a given specimen
     * 404: Unable to find the specimen since it is not found
     * @param id
     * @return Existing Specimen object
     */

    @GetMapping("/specimen/id/")
    public ResponseEntity fetchSpecimenById(@PathVariable("id") String id)
    {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Create a new specimen object, given the data provided.
     *
     * Returns one of the following codes:
     * 201: Successfully created a new specimen.
     * 409: Unable to create specimen, because it already exists.
     *
     * @param specimen a JSON representation of a specimen object.
     * @return Newly created Specimen Object.
     */
    @PostMapping(value = "/specimen", consumes = "application/json", produces = "application/json")
    public Specimen createSpecimen(@RequestBody Specimen specimen)
    {
        Specimen newSpecimen = specimenService.save(specimen);
        return newSpecimen;
    }

    @DeleteMapping("/specimen/id")
    public ResponseEntity deleteSpecimen(@PathVariable("id") String id)
    {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
