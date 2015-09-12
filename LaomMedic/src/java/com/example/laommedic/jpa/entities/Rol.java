
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
@Table(name = "ROLES")
public class Rol implements Serializable {
    
    @Id
    @Column(name = "id_roles")
    @Size(max =15)
    @Basic(optional = false)
    private String idRoles;
    
    @Column(name = "nombre_rol")
    @Size(max =20)
    @Basic(optional = false)
    private String nombreRol;
    
    @ManyToMany(mappedBy= "rol")//Relacion de muchos a muchos con la Tabla "Usuarios"
    private List<Usuario> usuarios;
    

    public Rol() {//Constructor
    }

    public Rol(String idRoles) {//Constructor
        this.idRoles = idRoles;
    }

    public String getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(String idRoles) {
        this.idRoles = idRoles;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    
    
}//Fin clase Rol

