package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Cmd;
import com.javatechie.jpa.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {

}
