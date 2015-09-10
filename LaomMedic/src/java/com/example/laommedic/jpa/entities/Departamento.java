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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "DEPARTAMENTOS")
public class Departamento implements Serializable {
    
    @Id
    @Column(name = "id_departamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private int idDepartamento;
    
    @Size(max =30)
    @Basic(optional = false)
    private String nombre;
    
    @ManyToOne//Llave foranea-Relacion muchos a uno
    @JoinColumn(name = "id_pais")//Nombre de la llave foranea
    private Pais pais;//Se pone la entidad con la que se relaciono
    
    @OneToMany(mappedBy = "departamento")//Relacion de uno a muchos con la Tabla "CIUDADADES"
    private List<Ciudad> ciudades;

    public Departamento() {//Constructor
    }

    public Departamento(int idDepartamento) {//Constructor
        this.idDepartamento = idDepartamento;
        
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudadades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
    
    
    
}//Fin clase Departamento
