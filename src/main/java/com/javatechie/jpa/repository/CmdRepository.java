package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Cmd;
import com.javatechie.jpa.entity.User;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface CmdRepository extends JpaRepository<Cmd,Long> {

  //  void softDelete(Long id);

    @Query(value="SELECT c.* FROM cmd c,cmd_etat ce  WHERE c.user_id is not null  AND ce.id=c.id_cmd and ce.deleted=false",nativeQuery=true)
    List<Cmd> getCmds();

    @Query(value="SELECT c FROM Cmd c,CmdEtat ce  WHERE ce.id=c.id and ce.deleted=false and c.user.id=?1")
    List<Cmd> getCmdsByUserId(Long userId);



    @Query(value="SELECT MAX(id_cmd)+1 FROM cmd ",nativeQuery=true)
    int getnewIdCmd();



}
