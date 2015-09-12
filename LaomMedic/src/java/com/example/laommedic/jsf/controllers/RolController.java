/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jsf.controllers;

import com.example.laommedic.jpa.entities.Rol;
import com.example.laommedic.jpa.sessions.RolSession;
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
public class RolController implements Serializable {
    
    @EJB
    private RolSession rolSession;
    
    private Rol currentRol;
    private List<Rol> itemsRol = null;
   
    public RolController() {
    }

    public Rol getCurrentRol() {
        if (currentRol == null) {
            currentRol = new Rol();
        }
        return currentRol;
    }

    public void setCurrentRol(Rol currentRol) {
        this.currentRol = currentRol;
    }

    public RolSession getRolSession() {
        return rolSession;
    }

    public List<Rol> getItemsRol() {
         if (itemsRol == null) {
            try {
                itemsRol = getRolSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsRol;
    }
    
    public void create() {
        try {
            getRolSession().create(currentRol);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
