/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jsf.controllers;

import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rubén.Gómez
 */
@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

    private static final Logger log = Logger.getLogger(LoginController.class.getName());
    private String identificacion;
    private String password;
    
    public LoginController() {
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public boolean isAuthenticated() {
        return getRequest().getUserPrincipal() != null;
    }

    public Principal getPrincipal() {
        return getRequest().getUserPrincipal();
    }

    private HttpServletRequest getRequest() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Object request = externalContext.getRequest();
        return request instanceof HttpServletRequest ? (HttpServletRequest) request : null;
    }

    private String getLogueado() {
        return getPrincipal().getName();
    }

    public String login() {
        try {
            //Login via the Servlet Context
            getRequest().login(identificacion, password);

            limpiar();

            //Redirigir a la página de portada
            return "/login";
        } catch (ServletException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Identificación o Contraseña Invalida", null));
            return "/index";
        }
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            request.logout();
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.invalidate();
            limpiar();
            return "/login";
        } catch (ServletException e) {
            log.log(Level.SEVERE, "Failed to logout user!", e);
            return "/login";
        }
    }

    private void limpiar() {
        identificacion = "";
        password = "";
    }
    
}
