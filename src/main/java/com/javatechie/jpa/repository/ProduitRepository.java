package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
