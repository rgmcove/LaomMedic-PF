/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jsf.controllers;

import com.example.laommedic.jpa.entities.Ciudad;
import com.example.laommedic.jpa.entities.Departamento;
import com.example.laommedic.jpa.entities.Entidad;
import com.example.laommedic.jpa.entities.Ocupacion;
import com.example.laommedic.jpa.entities.Rol;
import com.example.laommedic.jpa.entities.TipoDocumento;
import com.example.laommedic.jpa.entities.Usuario;
import com.example.laommedic.jpa.sessions.UsuarioSession;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Rubén.Gómez
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioSession usuarioSession;
    
    private Usuario currentUsuario;
    private int idCiudad;//Llave foranea
    private int idDepartamento;//Llave foranea
    private String idEntidad;//Llave foranea
    private String idRol;
    private String idOcupacion;
    private String idTipoDocumento;//Llave foranea
    private List<Usuario> itemsUsuario = null;
    
    public UsuarioController() {
    }

    public Usuario getCurrentUsuario() {
        if (currentUsuario == null) {
            currentUsuario = new Usuario();
        }
        return currentUsuario;
    }

    public void setCurrentUsuario(Usuario currentUsuario) {
        this.currentUsuario = currentUsuario;
    }

    public String getCiudad() {
        return idCiudad + "," + idDepartamento;
    }

    public void setCiudad(String ciudad) {
        StringTokenizer tokens = new StringTokenizer(ciudad, ",");
        idCiudad = Integer.parseInt(tokens.nextToken());
        idDepartamento = Integer.parseInt(tokens.nextToken());
    }

    public String getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(String idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(String idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public UsuarioSession getUsuarioSession() {
        return usuarioSession;
    }

    public List<Usuario> getItemsUsuario() {
        if (itemsUsuario == null) {
            try {
                itemsUsuario = getUsuarioSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsUsuario;
    }
    
    public void create() {
        try {
            currentUsuario.setCiudad(new Ciudad(idCiudad, new Departamento(idDepartamento)));
            currentUsuario.setRol((Collection<Rol>) new Rol(idRol));
            currentUsuario.setOcupacion((Collection<Ocupacion>) new Ocupacion(idOcupacion));
            currentUsuario.setEntidad(new Entidad(idEntidad));
            currentUsuario.setTipoDocumento(new TipoDocumento(idTipoDocumento));
            getUsuarioSession().create(currentUsuario);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
