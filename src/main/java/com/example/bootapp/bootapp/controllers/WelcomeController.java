package com.example.bootapp.bootapp.controllers;

import com.example.bootapp.bootapp.models.City;
import com.example.bootapp.bootapp.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {
    private String message = "Hello World";

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("welcome")
    public ModelAndView createUserView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("welcome");
        mav.addObject("message", message);
        mav.addObject("city", new City());
        return mav;
    }

    @RequestMapping(value = "/processCityForm", method= RequestMethod.POST)
    public String processForm(@ModelAttribute(value="city") City city) {
        System.out.println("CITY FROM FORM:" + city);
        cityRepository.save(city);
        return "welcome";
    }

    @RequestMapping(value = { "/cityList" }, method = RequestMethod.GET)
    public String personList(Model model) {
        List<City> all = cityRepository.findAll();
        model.addAttribute("cities", all);
        return "cityList";
    }

    @RequestMapping(value = { "/addCity" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
        City city = new City();
        model.addAttribute("city", city);
        return "addCity";
    }

    @RequestMapping(value = { "/addCity" }, method = RequestMethod.POST)
    public String saveCity(Model model, @ModelAttribute("city") City city) {
        String name = city.getName();
        if (name != null) {
            cityRepository.save(city);
            return "redirect:/cityList";
        }
        return "addCity";
    }
}
