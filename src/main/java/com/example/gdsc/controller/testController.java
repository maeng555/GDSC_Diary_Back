package com.example.gdsc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testController {
    @GetMapping(path="/hello")
    public String hello(){
        var html = "<html><body><h1>hellospring</h1></body></html>";
        return html;
    }

}
