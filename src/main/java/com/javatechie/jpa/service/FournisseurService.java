package com.javatechie.jpa.service;

import com.javatechie.jpa.entity.Fournisseur;
import com.javatechie.jpa.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository repository;

    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return repository.save(fournisseur);
    }

    public List<Fournisseur> saveFournisseurs(List<Fournisseur> fournisseurs) {
        return repository.saveAll(fournisseurs);
    }

    public List<Fournisseur> geFournisseurs() {
        return repository.findAll();
    }


    public Fournisseur getFournisseurById(long id) {
        return repository.findById(id).orElse(null);
    }

    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        Fournisseur existingFournisseur = repository.findById(fournisseur.getId()).orElse(null);
        existingFournisseur.setAdresse(fournisseur.getAdresse());
        existingFournisseur.setName(fournisseur.getName());
        existingFournisseur.setTel(fournisseur.getTel());
        return repository.save(existingFournisseur);

    }
    public String deleteFournisseur(Long id) {
        repository.deleteById(id);
        return "Rayon removed !! " + id;
    }

}
