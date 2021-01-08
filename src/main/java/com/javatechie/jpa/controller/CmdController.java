package com.javatechie.jpa.controller;

import com.javatechie.jpa.entity.Cmd;
import com.javatechie.jpa.entity.CmdEtat;
import com.javatechie.jpa.entity.User;
import com.javatechie.jpa.service.CmdEtatService;
import com.javatechie.jpa.service.CmdService;
import com.javatechie.jpa.service.LcmdService;
import com.javatechie.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class CmdController {
    @Autowired
    private CmdService cmdservice;
    @Autowired
    private LcmdService lcmdservice;
    @Autowired
    private CmdEtatService cmdEtatService;

    @Autowired
    private UserService userService;



    @CrossOrigin
    @PostMapping("/addCmd")
    public Cmd addCmd(@RequestBody Cmd cmd) {
        return cmdservice.saveCmd(cmd);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addCmd/{userId}")
    public Cmd addCmd(@PathVariable Long userId) {
        Cmd cmd=new Cmd();
        Date today = new Date();
        today.setHours(0);
        cmd.setDate(today);
        cmd.setEtat("en cours");
     User user=this.userService.getUserById(userId);
    cmd.setUser(user);

        return cmdservice.saveCmd(cmd);
    }

    @CrossOrigin
    @PostMapping("/addCmds")
    public List<Cmd> addCmds(@RequestBody List<Cmd> Cmds) {
        return cmdservice.saveCmds(Cmds);
    }

    @CrossOrigin
    @GetMapping("/Cmds")
    public List<Cmd> findAllCmds() {
        return cmdservice.getCmds();
    }

    @CrossOrigin
    @GetMapping("/TCmds")
    public List<Cmd> findAllTCmds() {
        return cmdservice.getTCmds();
    }
    
    @CrossOrigin
    @GetMapping("/newIdCmd")
    public int getNewId() {
        return cmdservice.getNewIdCmd();
    }

    @CrossOrigin
    @GetMapping("/CmdById/{id}")
    public Cmd findCmdById(@PathVariable Long id) {
        return cmdservice.getCmdById(id);
    }

    @CrossOrigin
    @GetMapping("/CmdsByUserId/{id}")
    public List<Cmd> findCmdByUserId(@PathVariable Long id) {
        return cmdservice.getCmdsByUserId(id);
    }

    @CrossOrigin
    @PutMapping("/activerCmd/{id}")
    public Cmd activerCmd(@PathVariable Long id) {
            Cmd c=new Cmd() ;
            Cmd c1=cmdservice.getCmdById(id)   ;
            c.setId(id);
           c.setEtat("Validée");
           c.setDate(cmdservice.getCmdById(id).getDate());
        c.setDate_livraison(cmdservice.getCmdById(id).getDate_livraison());
           return this.updateCmd(c);
    }

    @CrossOrigin
    @PutMapping("/rejeterCmd/{id}")
    public Cmd rejeterCmd(@PathVariable Long id) {
        Cmd c=new Cmd() ;
        Cmd c1=cmdservice.getCmdById(id)   ;
        c.setId(id);
        c.setEtat("Rejeté");
        c.setDate(cmdservice.getCmdById(id).getDate());
        c.setDate_livraison(cmdservice.getCmdById(id).getDate_livraison());
        return this.updateCmd(c);
    }

    @CrossOrigin
    @PutMapping("/supCmd/{id}")
    public String  supCmd(@PathVariable Long id) {
        CmdEtat c=new CmdEtat() ;
        c.setId(id);
        c.setDeleted(true);
        return this.cmdEtatService.updateCmdEtat(c);
    }

    @CrossOrigin
    @PutMapping("/softDeleteCmd/{id}")
    public Cmd softDelete(@PathVariable Long id) {
        Cmd c=new Cmd() ;
        Cmd c1=cmdservice.getCmdById(id)   ;
        c.setId(id);
        c.setDate(cmdservice.getCmdById(id).getDate());
        c.setDate_livraison(cmdservice.getCmdById(id).getDate_livraison());
        return this.updateCmd(c);
    }


    @CrossOrigin
    @PutMapping("/updateCmd")
    public Cmd updateCmd(@RequestBody Cmd cmd) {

        return cmdservice.updateCmd(cmd);
    }
/*
    @CrossOrigin
    @DeleteMapping("/deleteCmd/{id}")
    public String deleteCmd(@PathVariable Long id) {
      List<Lcmd> lignes= new ArrayList<Lcmd>();
        List<Long> Ids=new ArrayList<>();
        Iterator<Lcmd> iterator = lignes.iterator();

        while (iterator.hasNext()) {

            lcmdservice.deleteLcmd(iterator.next().getId());
        }

        return cmdservice.deleteCmd(id);
    }

       */



}
