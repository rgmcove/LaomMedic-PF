/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jsf.controllers;

import com.example.laommedic.jpa.entities.Entidad;
import com.example.laommedic.jpa.sessions.EntidadSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Rubén.Gómez
 */
@Named
@ViewScoped
public class EntidadController implements Serializable {

    @EJB
    private EntidadSession entidadSession;
    
    private Entidad currentEntidad;
    private List<Entidad> itemsEntidad = null;
    
    public EntidadController() {
    }

    public Entidad getCurrentEntidad() {
        if (currentEntidad == null) {
            currentEntidad = new Entidad();
        }
        return currentEntidad;
    }

    public void setCurrentEntidad(Entidad currentEntidad) {
        this.currentEntidad = currentEntidad;
    }

    public EntidadSession getEntidadSession() {
        return entidadSession;
    }

    public List<Entidad> getIttemsEntidad() {
        if (itemsEntidad == null) {
            try {
                itemsEntidad = getEntidadSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsEntidad;
    }
    
     public void create() {
        try {
            getEntidadSession().create(currentEntidad);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
