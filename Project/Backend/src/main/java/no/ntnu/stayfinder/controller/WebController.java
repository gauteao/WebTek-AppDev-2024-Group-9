package no.ntnu.stayfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/hotels")
    public String hotels() {
        return "hotels.html";
    }
}
