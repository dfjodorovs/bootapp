package com.example.bootapp.bootapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BootAppController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/")
    public String getHome() {
        return "/index";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "/about";
    }

    @GetMapping("/city")
    public String getCity() {
        return "/city";
    }

    @GetMapping("/country")
    public String getCountry() {
        return "/country";
    }

}
