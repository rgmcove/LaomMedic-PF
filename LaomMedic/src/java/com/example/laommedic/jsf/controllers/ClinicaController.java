/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jsf.controllers;

import com.example.laommedic.jpa.entities.Clinica;
import com.example.laommedic.jpa.sessions.ClinicaSession;
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
public class ClinicaController implements Serializable {

    @EJB//Enterprise Java Beans
    private ClinicaSession clinicaSession;
    
    private Clinica currentClinica;
    private String idRegimen;//Llave foranea
    private List<Clinica> itemsClinica = null;
    
    public ClinicaController() {
    }

    public Clinica getCurrentClinica() {
        if (currentClinica == null) {
            currentClinica = new Clinica();
        }
        return currentClinica;
    }

    public void setCurrentClinica(Clinica currentClinica) {
        this.currentClinica = currentClinica;
    }

    public String getIdRegimen() {
        return idRegimen;
    }

    public void setIdRegimen(String idRegimen) {
        this.idRegimen = idRegimen;
    }

    public ClinicaSession getClinicaSession() {
        return clinicaSession;
    }

    public List<Clinica> getItemsClinica() {
        if (itemsClinica == null) {
            try {
                itemsClinica = getClinicaSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsClinica;
    }
    
    public void create() {
        try {
            getClinicaSession().create(currentClinica);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
