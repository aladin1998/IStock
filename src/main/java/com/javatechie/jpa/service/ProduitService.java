package com.javatechie.jpa.service;

import com.javatechie.jpa.entity.Produit;
import com.javatechie.jpa.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitService {
    @Autowired
    private ProduitRepository repository;

    public Produit saveProduit(Produit produit) {
        return repository.save(produit);
    }

    public List<Produit> saveProduits(List<Produit> produits) {
        return repository.saveAll(produits);
    }

    public List<Produit> getProduits() {
        return repository.findAll();
    }

    public Produit getProduitById(long id) {
        return repository.findById(id).orElse(null);
    }



    public String deleteProduit(long id) {
        repository.deleteById(id);
        return "Produit removed !! " + id;
    }


    public Produit updateProduit(Produit produit) {
        Produit existingProduit = repository.findById(produit.getId()).orElse(null);
        existingProduit.setName(produit.getName());
        existingProduit.setPrice(produit.getPrice());
        existingProduit.setQuantity(produit.getQuantity());
        return repository.save(existingProduit);
    }
}
