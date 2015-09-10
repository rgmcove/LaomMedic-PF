/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jsf.controllers;

import com.example.laommedic.jpa.entities.TipoDocumento;
import com.example.laommedic.jpa.sessions.TipoDocumentoSession;
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
public class TipoDocumentoController implements Serializable {

    @EJB
    private TipoDocumentoSession tipoDocumentoSession;
    
    private TipoDocumento currentTipoDocumento;
    private List<TipoDocumento> itemsTipoDocumento = null;
    
    public TipoDocumentoController() {
    }

    public TipoDocumento getCurrentTipoDocumento() {
        if (currentTipoDocumento == null) {
            currentTipoDocumento = new TipoDocumento();
        }
        return currentTipoDocumento;
    }

    public void setCurrentTipoDocumento(TipoDocumento currentTipoDocumento) {
        this.currentTipoDocumento = currentTipoDocumento;
    }

    public TipoDocumentoSession getTipoDocumentoSession() {
        return tipoDocumentoSession;
    }

    public List<TipoDocumento> getItemsTipoDocumento() {
        if (itemsTipoDocumento == null) {
            try {
                itemsTipoDocumento = getTipoDocumentoSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsTipoDocumento;
    }
    
    public void create() {
        try {
            getTipoDocumentoSession().create(currentTipoDocumento);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
}//Fin Controller
