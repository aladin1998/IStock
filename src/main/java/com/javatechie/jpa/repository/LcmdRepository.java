package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Lcmd;
import com.javatechie.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface LcmdRepository extends JpaRepository<Lcmd,Long> {

    @Query("SELECT l FROM Lcmd l WHERE l.cmd.id=?1")
    List<Lcmd> countLcmd(Long id);


}
