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
    private String email;
    private String password;
    
    public LoginController() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
            getRequest().login(email, password);

            limpiar();

            //Redirigir a la página de portada
            return "/Paciente.xhtml";
        } catch (ServletException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Identificación o Contraseña Invalida", null));
            return "/login.xhtml";
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
            return "/login.xhtml";
        } catch (ServletException e) {
            log.log(Level.SEVERE, "Failed to logout user!", e);
            return "/login.xhtml";
        }
    }

    private void limpiar() {
        email = "";
        password = "";
    }
    
}
