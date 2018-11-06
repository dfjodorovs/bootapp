package com.example.bootapp.bootapp.controllers;

import com.example.bootapp.bootapp.models.City;
import com.example.bootapp.bootapp.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private CityRepository cityRepository;

    @Secured("ADMIN")
    @RolesAllowed("")
    @GetMapping("/cities/{id}")
    public Optional<City> getCityById(@PathVariable(value = "id") Long cityId) {
        return cityRepository.findById(cityId);
    }

    @PostMapping("/cities")
    public City createCity(@Valid @RequestBody City city) {
        System.out.println("CITY INPUT:" +city);
        return cityRepository.save(city);
    }

    @GetMapping("/cities")
    public List<City> getCities(){
        return  cityRepository.findAll();
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long cityId) {
        City note = cityRepository.findById(cityId).get();

        cityRepository.delete(note);

        return ResponseEntity.ok().build();
    }

}
