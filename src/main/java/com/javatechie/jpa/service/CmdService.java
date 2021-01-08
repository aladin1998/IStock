package com.javatechie.jpa.service;

import com.javatechie.jpa.entity.Cmd;
import com.javatechie.jpa.entity.CmdEtat;
import com.javatechie.jpa.repository.CmdEtatRepository;
import com.javatechie.jpa.repository.CmdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmdService {

    @Autowired
    private CmdRepository repository;

    @Autowired
    private CmdEtatRepository etatRepository;

    public Cmd saveCmd(Cmd cmd) {
        CmdEtat cmdEtat=new CmdEtat();
        cmdEtat.setDeleted(false);
        cmdEtat.setId((long) this.getNewIdCmd());
    this.etatRepository.save(cmdEtat);
        return repository.save(cmd);
    }

    public List<Cmd> saveCmds(List<Cmd> cmds) {
        return repository.saveAll(cmds);
    }

    public List<Cmd> getCmds() {
        return repository.findAll();
    }
    public List<Cmd> getCmdsByUserId(Long id) {
        return repository.getCmdsByUserId(id);
    }

    public List<Cmd> getTCmds() {
        return repository.getCmds();
    }

    public Cmd getCmdById(long id) {
        return repository.findById(id).orElse(null);
    }
    public int getNewIdCmd() {
        return repository.getnewIdCmd();
    }



    public Cmd updateCmd(Cmd cmd) {
        Cmd existingCmd = repository.findById(cmd.getId()).orElse(null);
        existingCmd.setDate(cmd.getDate());
        existingCmd.setDate_livraison(cmd.getDate_livraison());
        existingCmd.setEtat(cmd.getEtat());
        return repository.save(existingCmd);

    }

}
