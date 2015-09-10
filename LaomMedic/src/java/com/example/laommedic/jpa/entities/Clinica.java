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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Rubén.Gómez
 */
@Entity
@Table(name = "CLINICAS")
public class Clinica implements Serializable {
    
    @Id
    @Column(name = "nit_clinica")
    @Basic(optional = false)
    private long nitClinica;
    
    @Column(name = "nombre_clinica")
    @Size(max =40)
    @Basic(optional = false)
    private String nombreClinica;
    
    @Size(max =25)
    @Basic(optional = false)
    private String direccion;
    
    @Size(max =30)
    @Basic(optional = false)
    private String email;
    
    @Size(max =15)
    @Basic(optional = false)
    private String telefono;
    
    @ManyToOne
    @JoinColumn(name = "id_regimen")
    private Regimen regimen;
    
    @OneToMany(mappedBy = "clinica")//relacion uno a muchos con la Tabla "SEDES"
    private List<Sede> sedes;

    public Clinica() {//Constructor
    }

    public Clinica(long nitClinica, Regimen regimen) {
        this.nitClinica = nitClinica;
        this.regimen = regimen;
    }

    public long getNitClinica() {
        return nitClinica;
    }

    public void setNitClinica(long nitClinica) {
        this.nitClinica = nitClinica;
    }

    public String getNombreClinica() {
        return nombreClinica;
    }

    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    public List<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(List<Sede> sedes) {
        this.sedes = sedes;
    }


   
    
    
}//Fin clase Clinica
