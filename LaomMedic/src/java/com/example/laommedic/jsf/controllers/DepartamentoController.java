/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jsf.controllers;

import com.example.laommedic.jpa.entities.Departamento;
import com.example.laommedic.jpa.sessions.DepartamentoSession;
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
public class DepartamentoController implements Serializable {

    @EJB
    private DepartamentoSession departamentoSession;
    
    private Departamento currentDepartamento;
    private String idPais;//Llave foranea
    private List<Departamento> itemsDepartamento = null;
    
    public DepartamentoController() {
    }

    public Departamento getCurrentDepartamento() {
        if (currentDepartamento == null) {
            currentDepartamento = new Departamento();
        }
        return currentDepartamento;
    }

    public void setCurrentDepartamento(Departamento currentDepartamento) {
        this.currentDepartamento = currentDepartamento;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public DepartamentoSession getDepartamentoSession() {
        return departamentoSession;
    }

    public List<Departamento> getItemsDepartamento() {
        if (itemsDepartamento == null) {
            try {
                itemsDepartamento = getDepartamentoSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsDepartamento;
    }
    
     public void create() {
        try {
            getDepartamentoSession().create(currentDepartamento);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
