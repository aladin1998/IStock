package com.javatechie.jpa.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="fournisseur")
@Data

public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_FOURNISSEUR")
    private Long id;

    @Column(name="NOM_FOURNISSEUR")

    private String name;

    @Column(name="TEL_FOURNISSEUR")

    private String tel;
    @Column(name="ADRESSE_FOURNISSEUR")

    private String adresse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
