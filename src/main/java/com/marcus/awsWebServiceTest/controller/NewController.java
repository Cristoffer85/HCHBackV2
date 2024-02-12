package com.marcus.awsWebServiceTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class NewController {

    @GetMapping("")
    public String welcome() {
        return "Startsida";
    }

    @GetMapping("/about")
    public String about() {
        return "About!";
    }
}
