/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jsf.controllers;

import com.example.laommedic.jpa.entities.Sede;
import com.example.laommedic.jpa.sessions.SedeSession;
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
public class SedeController implements Serializable {

    @EJB
    private SedeSession sedeSession;
    
    private Sede currentSede;
    private int idCiudad;//Llave foranea
    private long nitClinica;//llave foranea
    private List<Sede> itemsSede = null;
    
    public SedeController() {
    }

    public Sede getCurrentSede() {
        if (currentSede == null) {
            currentSede = new Sede();
        }
        return currentSede;
    }

    public void setCurrentSede(Sede currentSede) {
        this.currentSede = currentSede;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public long getNitClinica() {
        return nitClinica;
    }

    public void setNitClinica(long nitClinica) {
        this.nitClinica = nitClinica;
    }

    public SedeSession getSedeSession() {
        return sedeSession;
    }

    public List<Sede> getItemsSede() {
        if (itemsSede == null) {
            try {
                itemsSede = getSedeSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsSede;
    }
    
    public void create() {
        try {
            getSedeSession().create(currentSede);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
