/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jsf.controllers;

import com.example.laommedic.jpa.entities.Regimen;
import com.example.laommedic.jpa.sessions.RegimenSession;
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
public class RegimenController implements Serializable {

    @EJB
    private RegimenSession regimenSession;
    
    private Regimen currentRegimen;
    private List<Regimen> itemsRegimen = null;
    
    public RegimenController() {
    }

    public Regimen getCurrentRegimen() {
        if (currentRegimen == null) {
            currentRegimen = new Regimen();
        }
        return currentRegimen;
    }

    public void setCurrentRegimen(Regimen currentRegimen) {
        this.currentRegimen = currentRegimen;
    }

    public RegimenSession getRegimenSession() {
        return regimenSession;
    }

    public List<Regimen> getItemsRegimen() {
        if (itemsRegimen == null) {
            try {
                itemsRegimen = getRegimenSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsRegimen;
    }
    
    public void create() {
        try {
            getRegimenSession().create(currentRegimen);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
