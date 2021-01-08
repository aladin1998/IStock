package com.javatechie.jpa.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.intellij.lang.annotations.Pattern;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="cmdEtat")
@Data

public class CmdEtat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


    private Boolean deleted;




    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }





}
