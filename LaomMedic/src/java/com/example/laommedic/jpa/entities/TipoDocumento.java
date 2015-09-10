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
@Table(name = "TIPO_DOCUMENTO")
public class TipoDocumento implements Serializable {
    
    @Id
    @Basic(optional = false)
    @Size(max =3)
    @Column(name = "id_tipo_documento")
    private String idTipoDocumento;
    
    @Basic(optional = false)
    @Size(max =35)
    private String nombre;
    
    @OneToMany(mappedBy= "tipoDocumento")//Relacion de uno a muchos con la Tabla "USUARIOS"
    private List<Usuario> usuarios;

    public TipoDocumento() {//Constructor
    }

    public TipoDocumento(String idTipoDocumento) {//Constructor
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}//Fin Class
