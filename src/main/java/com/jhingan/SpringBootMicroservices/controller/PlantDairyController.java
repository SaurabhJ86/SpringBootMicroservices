package com.jhingan.SpringBootMicroservices.controller;

import com.jhingan.SpringBootMicroservices.dto.Plant;
import com.jhingan.SpringBootMicroservices.dto.Specimen;
import com.jhingan.SpringBootMicroservices.service.ISpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The controller for Plant Diary REST Endpoints
 * <p>
 *     This class handles the CRUD Operations for the Plant Diary Specimens via HTTP Actions
 * </p>
 * @author Saurabh Jhingan
 * @version 1.0.0-SNAPSHOT
 */

@Controller
public class PlantDairyController {

    @Autowired
    ISpecimenService specimenService;

    /**
     * Handle the root("/") page
     * @param None
     * @return
     */
    @RequestMapping("/")
    public String index(Model model)
    {
        Specimen specimen = new Specimen();
        specimen.setDescription("Fuji Apple");
        specimen.setLatitude("39.74");
        specimen.setLongitude("-84.71");
        specimen.setSpecimenId("1004");
        specimen.setPlantId(88);
        model.addAttribute("specimen",specimen);
        return "start";
    }

    /**
     * Handles the /sustainability page
     * @param model
     * @return
     */
    @RequestMapping("/sustainability")
    public String sustainability(Model model)
    {
        return "sustainability";
    }

    @RequestMapping("/saveSpecimen")
    public String saveSpecimen(Specimen specimen)
    {
        try {
            specimenService.save(specimen);
        } catch (Exception e) {
            e.printStackTrace();
            return "start";
        }
        return "start";
    }

    @RequestMapping("/lookup/{id}")
    @ResponseBody
    public ResponseEntity index(@PathVariable("id") String id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_PLAIN);
        ResponseEntity responseEntity = new ResponseEntity("Your number: " + id, httpHeaders, HttpStatus.FORBIDDEN);
        return responseEntity;
    }

    /**
     * Returns a list of all specimen objects
     *
     * Returns one of the following codes:
     * 200: Ok
     * 404:
     * @return List of specimen objects.
     */
    @GetMapping("/specimen")
    @ResponseBody
    public List<Specimen> fetchAllSpecimen()
    {
        List<Specimen> specimens = specimenService.fetchAll();
        return specimens;
    }

    /**
     * Returns a specimen object, given the id provided
     *
     * Returns one of the following codes:
     * 200: Successfully returned a given specimen
     * 404: Unable to find the specimen since it is not found
     * @param id
     * @return Existing Specimen object
     */

    @GetMapping("/specimen/{id}/")
    @ResponseBody
    public ResponseEntity fetchSpecimenById(@PathVariable("id") String id)
    {
        Specimen foundSpecimen = specimenService.fetchById(Integer.parseInt(id));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundSpecimen, httpHeaders, HttpStatus.OK);
    }

    /**
     * Creates a new specimen object, given the data provided.
     *
     * Returns one of the following codes:
     * 201: Successfully created a new specimen.
     * 409: Unable to create specimen, because it already exists.
     *
     * @param specimen a JSON representation of a specimen object.
     * @return Newly created Specimen Object.
     */
    @PostMapping(value = "/specimen", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Specimen createSpecimen(@RequestBody Specimen specimen)
    {
        Specimen savedSpecimen = null;
        try {
            savedSpecimen = specimenService.save(specimen);
        } catch (Exception e) {
//            TODO Add Logging Later
        }
        return savedSpecimen;
    }

    /**
     * Deletes an existing specimen object
     *
     * Returns one of the following codes:
     * 200: Ok
     * 500: Internal Server Error
     * @param id
     * @return
     */
    @DeleteMapping("/specimen/{id}/")
    public ResponseEntity deleteSpecimen(@PathVariable("id") String id)
    {
        Integer idToDelete = Integer.parseInt(id);
        try {
            specimenService.deleteById(idToDelete);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
//            TODO add logging
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/plants", consumes = "application/json", produces = "application/json")
    public ResponseEntity searchPlants(@RequestParam Map<String, String> requestParams) throws IOException {
        String searchValue = requestParams.get("searchTerm");
        List<Plant> allPlants = specimenService.fetchPlants(searchValue);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(allPlants,httpHeaders,HttpStatus.OK);
    }

    @GetMapping("/plants")
    public String searchPlantsForm(@RequestParam(value = "searchTerm", required = false, defaultValue = "None") String searchTerm, Model model)
    {
        try {
            List<Plant> allPlants = specimenService.fetchPlants(searchTerm);
            model.addAttribute("plants", allPlants);
            return "plants";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
