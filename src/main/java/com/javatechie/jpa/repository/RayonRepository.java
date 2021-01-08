package com.javatechie.jpa.repository;


import com.javatechie.jpa.entity.Rayon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface RayonRepository extends JpaRepository<Rayon,Long> {

}
