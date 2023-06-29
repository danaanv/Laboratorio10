package com.example.laboratorio10.Controller;

import com.example.laboratorio10.Entity.Imagen;
import com.example.laboratorio10.Entity.Juego;
import com.example.laboratorio10.Repository.ImagenRepository;
import com.example.laboratorio10.Repository.JuegoRepository;
import com.example.laboratorio10.Repository.OrdenRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    final JuegoRepository juegoRepository;
    final ImagenRepository imagenRepository;
    final OrdenRepository ordenRepository;

    public Controller(JuegoRepository juegoRepository, ImagenRepository imagenRepository, OrdenRepository ordenRepository) {
        this.juegoRepository = juegoRepository;
        this.imagenRepository = imagenRepository;
        this.ordenRepository = ordenRepository;
    }

    @GetMapping("/cambiosDana")
    public String cambiosDana(){
        return "/cambiosDana";
    }

    @GetMapping("/index")
    public String principal(){

        return "/index";
    }
    @GetMapping("/imagen")
    public ResponseEntity<byte[]> mostrarLogo(){
        int id=5;
        Optional<Imagen> opt = imagenRepository.findById(id);
        if(opt.isPresent()){
            Imagen imagen= opt.get();
            byte[] imagenComoBytes = imagen.getImagen();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.parseMediaType(imagen.getContentType()));
            return new ResponseEntity<>(imagenComoBytes, httpHeaders, HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
