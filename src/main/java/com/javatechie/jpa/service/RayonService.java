package com.javatechie.jpa.service;

import com.javatechie.jpa.entity.Rayon;
import com.javatechie.jpa.repository.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RayonService {
    @Autowired
    private RayonRepository repository;

    public Rayon saveRayon(Rayon rayon) {
        return repository.save(rayon);
    }

    public List<Rayon> saveRayons(List<Rayon> rayons) {
        return repository.saveAll(rayons);
    }

    public List<Rayon> getRayons() {
        return repository.findAll();
    }

    public Rayon getRayonById(Long id) {
        return repository.findById(id).orElse(null);
    }



    public String deleteRayon(Long id) {
        repository.deleteById(id);
        return "Rayon removed !! " + id;
    }

    public Rayon updateRayon(Rayon rayon) {
        Rayon existingRayon = repository.findById(rayon.getId()).orElse(null);
        existingRayon.setCapacite(rayon.getCapacite());
        existingRayon.setNomRayon(rayon.getNomRayon());
        return repository.save(existingRayon);
    }

}