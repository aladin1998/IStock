package com.javatechie.jpa.controller;

import com.javatechie.jpa.entity.Produit;
import com.javatechie.jpa.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    @Autowired
    private ProduitService service;


    @CrossOrigin
    @PostMapping("/addProduit")
    public Produit addProduit(@RequestBody Produit produit) {
        return service.saveProduit(produit);
    }

    @PostMapping("/addProduits")
    public List<Produit> addProduits(@RequestBody List<Produit> produits) {
        return service.saveProduits(produits);
    }

    @CrossOrigin
    @GetMapping("/Produits")
    public List<Produit> findAllProduits() {
        return service.getProduits();
    }

    @GetMapping("/ProduitById/{id}")
    public Produit findProduitById(@PathVariable long id) {
        return service.getProduitById(id);
    }

    @PutMapping("/updateProduit")
    public Produit updateProduit(@RequestBody Produit Produit) {
        return service.updateProduit(Produit);
    }
    @CrossOrigin
    @DeleteMapping("/deleteProduit/{id}")
    public String deleteProduit(@PathVariable long id) {
        return service.deleteProduit(id);
    }
}
