package com.example.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloHumanApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloHumanApplication.class, args);}
        @RequestMapping("/")
    public String index(@RequestParam(value="name") String searchQuery,@RequestParam(value="lastname") String searchQuery1) {
        return "Hello " + searchQuery +" "+ searchQuery1;
    }


    }
