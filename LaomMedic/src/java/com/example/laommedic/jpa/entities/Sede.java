
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Rubén.Gómez
 */
@Entity
@Table(name = "SEDES")
public class Sede implements Serializable {
    
    @Id
    @Column(name = "id_sedes")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private int idSedes;
    
    @ManyToOne
    @JoinColumns(
            {
                @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
                @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
            })
    private Ciudad ciudad;
    
    @ManyToOne
    @JoinColumn(name = "nit_clinica")
    private Clinica clinica;
    
    @Column(name = "nombre_sede")
    @Size(max =40)
    @Basic(optional = false)
    private String nombreSede;
    
    @Column(name = "sede_ppal")
    @Size(max =40)
    @Basic(optional = false)
    private String sedePpal;
    
    @Size(max =35)
    @Basic(optional = false)
    private String direccion;
    
    @Size(max =15)
    @Basic(optional = false)
    private String telefono;

    public Sede() {//Constructor
    }

    public Sede(int idSedes, Ciudad ciudad, Clinica clinica) {//Constructor
        this.idSedes = idSedes;
        this.ciudad = ciudad;
        this.clinica = clinica;
    }

    public int getIdSedes() {
        return idSedes;
    }

    public void setIdSedes(int idSedes) {
        this.idSedes = idSedes;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getSedePpal() {
        return sedePpal;
    }

    public void setSedePpal(String sedePpal) {
        this.sedePpal = sedePpal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}//Fin clase sede

