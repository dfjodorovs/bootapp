package com.example.bootapp.bootapp.controllers;

import com.example.bootapp.bootapp.models.City;
import com.example.bootapp.bootapp.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities/{id}")
    public Optional<City> getCityById(@PathVariable(value = "id") Long cityId) {
        return cityRepository.findById(cityId);
    }

    @PostMapping("/cities")
    public City createCity(@Valid @RequestBody City city) {
        System.out.println("CITY INPUT:" +city);
        return cityRepository.save(city);
    }


}