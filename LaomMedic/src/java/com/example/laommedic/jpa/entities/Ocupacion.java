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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Rubén.Gómez
 */
@Entity
@Table(name = "OCUPACIONES")

public class Ocupacion implements Serializable {
    
    @Id
    @Basic(optional = false)
    @Size(max =5)
    @Column(name = "id_ocupacion")
    private String idOcupacion;
    
    @Basic(optional = false)
    @Size(max =50)
    @Column(name = "nombre_ocupacion")
    private String nombreOcupacion;
    
    @ManyToMany(mappedBy= "ocupacion")//Relacion de muchos a muchos con la Tabla "Usuarios"
    private List<Usuario> usuarios;

    public Ocupacion() {//CONSTRUCTOR
    }

    public Ocupacion(String idOcupacion) {//CONSTRUCTOR
        this.idOcupacion = idOcupacion;
    }

    public String getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(String idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    public String getNombreOcupacion() {
        return nombreOcupacion;
    }

    public void setNombreOcupacion(String nombreOcupacion) {
        this.nombreOcupacion = nombreOcupacion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}//FIN CLASE OCUPACION
