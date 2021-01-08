package com.javatechie.jpa.controller;

import com.javatechie.jpa.entity.Rayon;
import com.javatechie.jpa.service.RayonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RayonController {

    @Autowired
    private RayonService Rayonservice;

    @PostMapping("/addRayon")
    public Rayon addRayon(@RequestBody Rayon Rayon) {
        return Rayonservice.saveRayon(Rayon);
    }

    @PostMapping("/addRayons")
    public List<Rayon> addRayons(@RequestBody List<Rayon> Rayons) {
        return Rayonservice.saveRayons(Rayons);
    }

    @GetMapping("/Rayons")
    public List<Rayon> findAllRayons() {
        return Rayonservice.getRayons();
    }

    @GetMapping("/RayonById/{id}")
    public Rayon findRayonById(@PathVariable Long id) {
        return Rayonservice.getRayonById(id);
    }

    @PutMapping("/updateRayon")
    public Rayon updateRayon(@RequestBody Rayon Rayon) {
        return Rayonservice.updateRayon(Rayon);
    }

    @DeleteMapping("/deleteRayon/{id}")
    public String deleteRayon(@PathVariable Long id) {
        return Rayonservice.deleteRayon(id);
    }
}
