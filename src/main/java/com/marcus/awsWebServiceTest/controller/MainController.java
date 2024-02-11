package com.marcus.awsWebServiceTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("")
    public String sayHelloWorld() {
        return "This is the final message!";
    }
}
