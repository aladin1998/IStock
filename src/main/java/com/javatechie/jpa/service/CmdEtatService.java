package com.javatechie.jpa.service;


import com.javatechie.jpa.entity.CmdEtat;
import com.javatechie.jpa.entity.CmdEtat;
import com.javatechie.jpa.repository.CmdEtatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmdEtatService {
    @Autowired
    private CmdEtatRepository repository;

    public CmdEtat saveCmdEtat(CmdEtat cmdEtat) {
        return repository.save(cmdEtat);
    }

    public List<CmdEtat> saveCmdEtats(List<CmdEtat> cmdEtats) {
        return repository.saveAll(cmdEtats);
    }

    public List<CmdEtat> getCmdEtats() {
        return repository.findAll();
    }

    public CmdEtat getCmdEtatById(long id) {
        return repository.findById(id).orElse(null);
    }



    public String updateCmdEtat(CmdEtat cmdEtat) {
        CmdEtat existingCmdEtat = repository.findById(cmdEtat.getId()).orElse(null);
        existingCmdEtat.setDeleted(cmdEtat.getDeleted());
         repository.save(existingCmdEtat);
        return "Cmd removed !!";

    }

}
