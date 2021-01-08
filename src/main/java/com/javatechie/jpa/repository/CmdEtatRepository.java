package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Cmd;
import com.javatechie.jpa.entity.CmdEtat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface CmdEtatRepository extends JpaRepository<CmdEtat,Long> {


}
