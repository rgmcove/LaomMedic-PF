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
@Table(name = "ENTIDADES")
public class Entidad implements Serializable {
    
    @Id
    @Column(name = "id_entidad")
    @Basic(optional = false)
    @Size(max =5)
    private String idEntidad;
    
    @Column(name = "nombre_entidad")
    @Size(max= 45)
    @Basic(optional = false)
    private String nombreEntidad;
    
    @OneToMany(mappedBy = "entidad")//Relacion de uno a muchos con la Tabla "USUARIOS"
    private List<Usuario> usuarios;

    public Entidad() {//Constructor
    }

    public Entidad(String idEntidad) {//Constructor
        this.idEntidad = idEntidad;
    }

    public String getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(String idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
