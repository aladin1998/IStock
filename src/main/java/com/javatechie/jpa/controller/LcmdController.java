package com.javatechie.jpa.controller;

import com.javatechie.jpa.entity.Cmd;
import com.javatechie.jpa.entity.Fournisseur;
import com.javatechie.jpa.entity.Lcmd;
import com.javatechie.jpa.entity.Produit;
import com.javatechie.jpa.service.CmdService;
import com.javatechie.jpa.service.FournisseurService;
import com.javatechie.jpa.service.LcmdService;
import com.javatechie.jpa.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class LcmdController {
    @Autowired
    private LcmdService Lcmdservice;
    @Autowired
    private CmdService cmdservice;
    @Autowired
    private ProduitService produitService;

    @Autowired
    private FournisseurService fournisseurService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addLcmd/{cmdId}/{produitId}/{fournisseurId}/{qte}")
    public Lcmd addLcmd(@PathVariable Long cmdId,@PathVariable Long produitId,@PathVariable Long fournisseurId,@PathVariable int qte) {
            Lcmd lcmd=new Lcmd();
             Cmd cmd=this.cmdservice.getCmdById(cmdId);
             Produit produit=this.produitService.getProduitById(produitId);
        Fournisseur fournisseur=this.fournisseurService.getFournisseurById(fournisseurId);
       lcmd.setCmd(cmd);
       lcmd.setFournisseur(fournisseur);
       lcmd.setProduit(produit);
       lcmd.setQt(qte);
        return Lcmdservice.saveLcmd(lcmd);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addLcmd1/{produitId}/{fournisseurId}/{qt}")
    public Lcmd addLcmd(@RequestBody int cmdId,@PathVariable int qt,@PathVariable Long produitId,@PathVariable Long fournisseurId) {
        Lcmd lcmd=new Lcmd();
        Cmd cmd=this.cmdservice.getCmdById(cmdId);
        Produit produit=this.produitService.getProduitById(produitId);
        Fournisseur fournisseur=this.fournisseurService.getFournisseurById(fournisseurId);
        lcmd.setCmd(cmd);
        lcmd.setFournisseur(fournisseur);
        lcmd.setProduit(produit);
        lcmd.setQt(qt);
        return Lcmdservice.saveLcmd(lcmd);
    }
    @PostMapping("/addLcmd/")
    public Lcmd addLcmd(@RequestBody Lcmd lcmd) {

        return Lcmdservice.saveLcmd(lcmd);
    }

    @PostMapping("/addLcmds")
    public List<Lcmd> addLcmds(@RequestBody List<Lcmd> Lcmds) {
        return Lcmdservice.saveLcmds(Lcmds);
    }

    @GetMapping("/Lcmds")
    public List<Lcmd> findAllLcmds() {
        return Lcmdservice.getLcmds();
    }

    @GetMapping("/LcmdsByCmd/{id}")
    public List<Lcmd> count(@PathVariable Long id) {
        return Lcmdservice.countLcmd(id);
    }

    @GetMapping("/LcmdById/{id}")
    public Lcmd findLcmdById(@PathVariable Long id) {
        return Lcmdservice.getLcmdById(id);
    }

    @PutMapping("/updateLcmd")
    public Lcmd updateLcmd(@RequestBody Lcmd Lcmd) {
        return Lcmdservice.updateLcmd(Lcmd);
    }

    @DeleteMapping("/deleteLcmd/{id}")
    public String deleteLcmd(@PathVariable Long id) {
        return Lcmdservice.deleteLcmd(id);
    }
}