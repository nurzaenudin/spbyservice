/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.spbyservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nurzaenudin
 */

@Entity
@JsonSerialize
public class Agenda {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String penerima;
    
  
    private String penguji;
    
    
    @Temporal(TemporalType.DATE)
    private Date tglagenda;
    
    @Temporal(TemporalType.DATE)
    private Date tglbayar;
    
    
    private Long nodrpp;
    
    
    //@OneToMany (mappedBy = "agenda")
    //@JoinColumn(name = "agenda_id", nullable = false)
    //@JsonIgnore
    //private Set <Spbysakti> spbysakti;
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getPenerima() {
        return penerima;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }

    public Date getTglagenda() {
        return tglagenda;
    }

    public void setTglagenda(Date tglagenda) {
        this.tglagenda = tglagenda;
    }

    public Long getNodrpp() {
        return nodrpp;
    }

    public void setNodrpp(Long nodrpp) {
        this.nodrpp = nodrpp;
    }
    
    

//    public Set<Spbysakti> getSpbysakti() {
//        return spbysakti;
//    }
//
//    public void setSpbysakti(Set<Spbysakti> spbysakti) {
//        this.spbysakti = spbysakti;
//    }

    @Override
    public String toString() {
        return "Agenda{" + "id=" + id + ", penerima=" + penerima + ", tglagenda=" + tglagenda + ", nodrpp=" + nodrpp + '}';
    }

       
    

}
