/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jsf.controllers;

import com.example.laommedic.jpa.entities.Ocupacion;
import com.example.laommedic.jpa.sessions.OcupacionSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Rubén.Gómez
 */
@ManagedBean
@ViewScoped
public class OcupacionController implements Serializable {

    @EJB
    private OcupacionSession ocupacionSession;
    
    private Ocupacion currentOcupacion;
    private List<Ocupacion> itemsOcupacion = null;
    
    public OcupacionController() {
    }

    public Ocupacion getCurrentOcupacion() {
        if (currentOcupacion == null) {
            currentOcupacion = new Ocupacion();
        }
        return currentOcupacion;
    }

    public void setCurrentOcupacion(Ocupacion currentOcupacion) {
        this.currentOcupacion = currentOcupacion;
    }

    public OcupacionSession getOcupacionSession() {
        return ocupacionSession;
    }

    public List<Ocupacion> getItemsOcupacion() {
        if (itemsOcupacion == null) {
            try {
                itemsOcupacion = getOcupacionSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsOcupacion;
    }
    
    public void create() {
        try {
            getOcupacionSession().create(currentOcupacion);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
