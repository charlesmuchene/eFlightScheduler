package edu.mum.cs.cs425.eFlightScheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/eflight", "/eflight/home"})
    public String home() {
        return "public/index";
    }

    @GetMapping("/eflight/secured/home")
    public String securedHome() {
        return "secured/index";
    }

}
