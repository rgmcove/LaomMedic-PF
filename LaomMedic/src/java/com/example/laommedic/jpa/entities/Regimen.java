/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author rubén.Gómez
 */
@Entity
@Table(name = "REGIMENES")
public class Regimen implements Serializable {
    
    @Id
    @Column(name = "id_regimen")
    @Size(max =15)
    @Basic(optional = false)
    private String idRegimen;
    
    @Column(name = "nombre_regimen")
    @Size(max =15)
    @Basic(optional = false)
    private String nombreRegimen;
    
    @OneToMany(mappedBy = "regimen")//Relacion de uno a muchos con la Tabla "CLINICAS"
    private List<Clinica> clinicas;

    public Regimen() {//Constructor
    }

    public Regimen(String idRegimen) {//Constructor
        this.idRegimen = idRegimen;
    }

    public String getIdRegimen() {
        return idRegimen;
    }

    public void setIdRegimen(String idRegimen) {
        this.idRegimen = idRegimen;
    }

    public String getNombreRegimen() {
        return nombreRegimen;
    }

    public void setNombreRegimen(String nombreRegimen) {
        this.nombreRegimen = nombreRegimen;
    }

    public List<Clinica> getClinicas() {
        return clinicas;
    }

    public void setClinicas(List<Clinica> clinicas) {
        this.clinicas = clinicas;
    }
    
    
    
}//Fin clase Regimen
