/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.entities;

import java.io.Serializable;

/**
 *
 * @author Rubén.Gómez
 */
public class CiudadPK implements Serializable {//Para las llaves primarias incluidas en la Tabla "CIUDAD"
    
    private int idCiudad;
    private int departamento;

    public CiudadPK() {//Constructor
    }

    public CiudadPK(int idCiudad, int departamento) {//Constructor
        this.idCiudad = idCiudad;
        this.departamento = departamento;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idCiudad;
        hash = 97 * hash + this.departamento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CiudadPK other = (CiudadPK) obj;
        if (this.idCiudad != other.idCiudad) {
            return false;
        }
        if (this.departamento != other.departamento) {
            return false;
        }
        return true;
    }
    
    
    
}
