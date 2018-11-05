package com.example.bootapp.bootapp.controllers;

import com.example.bootapp.bootapp.models.City;
import com.example.bootapp.bootapp.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mvcCity")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/city")
    public ModelAndView getCity(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cityPage");
        List<City> all = cityRepository.findAll();
        modelAndView.addObject("cities", all);

        return modelAndView;
    }

}
