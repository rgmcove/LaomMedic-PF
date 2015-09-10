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
 * @author Rubén.Gómez
 */
@Entity
@Table(name="PAISES")//Nombre de la tabla en la BD
public class Pais implements Serializable {
    
    @Id//Llave Primaria
    @Column(name ="id_pais")//Nombre de la columna en la BD
    @Size(max =5)
    @Basic(optional = false)
    private String idPais;
    
    @Size(max =45)
    @Basic(optional = false)
    private String nombre;
    
    @OneToMany(mappedBy = "pais")//Relacion de uno a muchos con la tabla "DEPARTAMENTOS"
    private List<Departamento> departamentos;

    public Pais() {//Constructor
    }

    public Pais(String idPais) {//Constructor idPais
        this.idPais = idPais;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    
    
}//Fin clase Pais
