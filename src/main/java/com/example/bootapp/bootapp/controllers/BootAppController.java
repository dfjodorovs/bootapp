package com.example.bootapp.bootapp.controllers;

import com.example.bootapp.bootapp.models.BootAppUser;
import com.example.bootapp.bootapp.models.City;
import com.example.bootapp.bootapp.repositories.BootAppUserRepository;
import com.example.bootapp.bootapp.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BootAppController {

    @Autowired
    private BootAppUserRepository bootAppUserRepository;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/")
    public String getHome() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("username: " + auth.getName());
        return "/index";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "/about";
    }

    @GetMapping("/loginError")
    public String getLginError(@RequestParam(value = "message") String search, Model model) {
        model.addAttribute("errorMsg", search);
        return "error";
    }


    @GetMapping("/city")
    public String getCity(Model model) {

        model.addAttribute("cities",cityRepository.findAll());
        model.addAttribute("newCity", new City());

        return "city";
    }

    @RequestMapping(value = { "/addCity" }, method = RequestMethod.POST)
    public String saveCity(Model model, @ModelAttribute("newCity") City newCity) {
        String name = newCity.getName();
        if (name != null) {
            cityRepository.save(newCity);
            return "redirect:/city";
        }
        return "redirect:/city";
    }

    @GetMapping("/country")
    public String getCountry() {
        return "/country";
    }

    @GetMapping("/signup")
    public String getSingUp(Model model) {
        model.addAttribute("newUser", new BootAppUser());
        return "signup";
    }


    @RequestMapping(value = { "/createUser" }, method = RequestMethod.POST)
    public String createNewUser(Model model, @ModelAttribute("newUser") BootAppUser user) {

        bootAppUserRepository.save(user);

        return "index";
    }

}
