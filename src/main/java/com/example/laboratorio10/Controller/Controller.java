package com.example.laboratorio10.Controller;

import com.example.laboratorio10.Repository.JuegoRepository;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    final JuegoRepository juegoRepository;

    public Controller(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @GetMapping("/cambiosDana")
    public String cambiosDana(){
        return "/cambiosDana";
    }
}
