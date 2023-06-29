package com.example.laboratorio10;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/cambiosDana")
    public String cambiosDana(){
        return "/cambiosDana";
    }
}
