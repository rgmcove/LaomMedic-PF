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
import javax.persistence.IdClass;
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
@Table(name = "CIUDADES")
@IdClass(value = CiudadPK.class)
public class Ciudad implements Serializable {
    
    @Id
    @Column(name = "id_ciudad")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCiudad;
    
    @Size(max =30)
    @Basic(optional = false)
    private String nombre;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
    
    @OneToMany(mappedBy = "ciudad")//Relacion de uno a muchos con la Tabla "SEDES"
    private List<Sede> sedes;
    
    @OneToMany(mappedBy = "ciudad")//Relacion de uno a muchos con la Tabla "USUARIOS"
    private List<Usuario> usuarios;

    public Ciudad() {//Constructor
    }

    public Ciudad(int idCiudad, Departamento idDepartamento) {//Constructor
        this.idCiudad = idCiudad;
        this.departamento = idDepartamento;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(List<Sede> sedes) {
        this.sedes = sedes;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}//Fin clase Ciudad
