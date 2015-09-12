/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jsf.controllers;

import com.example.laommedic.jpa.entities.Ciudad;
import com.example.laommedic.jpa.entities.Departamento;
import com.example.laommedic.jpa.sessions.CiudadSession;
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
public class CiudadController implements Serializable {
    
    @EJB//Enterprise Java Beans
    private CiudadSession ciudadSession;
    
    private Ciudad currentCiudad;
    private int idDepartamento;//Llave foranea
    private List<Ciudad> itemsCiudad = null;

    
    public CiudadController() {
    }

    public Ciudad getCurrentCiudad() {
        if (currentCiudad == null) {
            currentCiudad = new Ciudad();
        }
        return currentCiudad;
    }
    
     public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public void setCurrentCiudad(Ciudad currentCiudad) {
        this.currentCiudad = currentCiudad;
    }

    public CiudadSession getCiudadSession() {
        return ciudadSession;
    }

    public List<Ciudad> getItemsCiudad() {
        if (itemsCiudad == null) {
            try {
                itemsCiudad = getCiudadSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsCiudad;
    }
    
    public void create() {
        try {
            currentCiudad.setDepartamento(new Departamento(idDepartamento));
            getCiudadSession().create(currentCiudad);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void remove(){
        try {
            getCiudadSession().remove(currentCiudad);
            itemsCiudad = null;
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }
}
