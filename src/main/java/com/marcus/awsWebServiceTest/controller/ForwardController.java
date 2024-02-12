package com.marcus.awsWebServiceTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwardController {                      // Class that connects (forwards) requests to the react frontend. Very simple, easy and lightunderstood, huh?

    @GetMapping("/")
    public String index() {
        return "forward:/frontend/index.html";
    }
}
