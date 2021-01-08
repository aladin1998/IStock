package com.javatechie.jpa.controller;

import com.javatechie.jpa.entity.Fournisseur;
import com.javatechie.jpa.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FournisseurController {

    @Autowired
    private FournisseurService service;



    @PostMapping("/addFournisseur")
    public Fournisseur addFournisseur(@RequestBody Fournisseur Fournisseur) {
        return service.saveFournisseur(Fournisseur);
    }

    @PostMapping("/addFournisseurs")
    public List<Fournisseur> addFournisseurs(@RequestBody List<Fournisseur> Fournisseurs) {
        return service.saveFournisseurs(Fournisseurs);
    }

    @CrossOrigin
    @GetMapping("/Fournisseurs")
    public List<Fournisseur> findAllFournisseurs() {
        return service.geFournisseurs();
    }

    @GetMapping("/FournisseurById/{id}")
    public Fournisseur findFournisseurById(@PathVariable long id) {
        return service.getFournisseurById(id);
    }

    @PutMapping("/updateFournisseur")
    public Fournisseur updateFournisseur(@RequestBody Fournisseur Fournisseur) {
        return service.updateFournisseur(Fournisseur);
    }

    @DeleteMapping("/deleteFournisseur/{id}")
    public String deleteFournisseur(@PathVariable long id) {
        return service.deleteFournisseur(id);
    }
}
