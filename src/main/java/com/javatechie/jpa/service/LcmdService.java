package com.javatechie.jpa.service;

import com.javatechie.jpa.entity.Lcmd;
import com.javatechie.jpa.repository.LcmdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LcmdService {

    @Autowired
    private LcmdRepository repository;

    public Lcmd saveLcmd(Lcmd lcmd) {
        return repository.save(lcmd);
    }

    public List<Lcmd> saveLcmds(List<Lcmd> lcmds) {
        return repository.saveAll(lcmds);
    }

    public List<Lcmd> getLcmds() {
        return repository.findAll();
    }


    public List<Lcmd> countLcmd(Long id) {
        return repository.countLcmd(id);
    }


    public Lcmd getLcmdById(long id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteLcmd(long id) {
        repository.deleteById(id);
        return "Lcmd removed !! " + id;
    }

    public Lcmd updateLcmd(Lcmd lcmd) {
        Lcmd existingLcmd = repository.findById(lcmd.getId()).orElse(null);
        existingLcmd.setQt(lcmd.getQt());
        return repository.save(existingLcmd);
    }

    public List<Lcmd> show() {
        return repository.findAll();
    }

}
