package com.example.JEEWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AppRest {
    @GetMapping (value="/")
    public String hello() {
        return "hello";
    }
}