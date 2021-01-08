package com.javatechie.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="rayon")
@Data
public class Rayon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_RAYON")
    private Long id;
/*
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "rayon")
    @JoinColumn(name="rayon")
    private Set<User> users;*/


    @Column(name="CAPACITE")
    private String capacite;

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    @Column(name="NOM_RAYON")
    private String NomRayon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomRayon() {
        return NomRayon;
    }

    public void setNomRayon(String nomRayon) {
        NomRayon = nomRayon;
    }
}
