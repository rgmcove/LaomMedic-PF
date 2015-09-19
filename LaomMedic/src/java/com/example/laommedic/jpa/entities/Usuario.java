
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.entities;

import com.example.laommedic.jsf.controllers.util.JsfUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Rubén.Gómez
 */
@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {
    
    @Id
    @Column(name = "id_identificacion")
    @NotNull
    private long idIdentificacion;
    
    @Size(max =25)
    @Column(name = "primer_nombre")
    @NotNull
    private String primerNombre;
    
    @Size(max =25)
    @Column(name= "segundo_nombre")
    private String segundoNombre;
    
    @Column(name = "primer_apellido")
    @Size(max =25)
    @NotNull
    private String primerApellido;
    
    @Column(name = "segundo_apellido")
    @Size(max =25)
    private String segundoApellido;
    
    @Column(name = "fecha_nacimiento")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    @Column(name = "grupo_sanguineo")
    @NotNull
    private char grupoSanguineo;
    
    @Size(max =5)
    @NotNull
    private String rh;
    
    @Size(max =30)
    @NotNull
    private String email;
    
    @Size(min =8, max =200)
    @NotNull
    private String password;
    
    @Size(max =30)
    @NotNull
    private String direccion;
    
    @Size(max =15)
    @NotNull
    private String telefono;
    
    @Size(max =15)
    @NotNull
    private String sexo;
    
    @Column(name = "fecha_ingreso")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    @ManyToOne
    @JoinColumns(
            {
                @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
                @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
            })
    private Ciudad ciudad; 
    
    @ManyToOne
    @JoinColumn(name = "id_entidad")
    private Entidad entidad;
    
    @ManyToMany
    @JoinTable(name = "ROLES_DE_USUARIOS",
            joinColumns = @JoinColumn(name = "id_identificacion",
                    referencedColumnName = "id_identificacion"),
            inverseJoinColumns = @JoinColumn(name = "id_roles",
                    referencedColumnName = "id_roles"))
    private List<Rol> rol;//RELACION MUCHOS A MUCHOS USUARIOS-ROLES
    
    @ManyToMany
    @JoinTable(name = "OCUPACIONES_has_USUARIOS",
            joinColumns = @JoinColumn(name = "id_identificacion",
                    referencedColumnName = "id_identificacion"),
            inverseJoinColumns = @JoinColumn(name = "id_ocupacion",
                    referencedColumnName = "id_ocupacion"))
    private List<Ocupacion> ocupacion;//RELACION MUCHOS A MUCHOS USUARIOS-OCUPACION
    
    @OneToOne
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento tipoDocumento;

    public Usuario() {//Constructor
    }

    public Usuario(long idIdentificacion, Ciudad ciudad, Entidad entidad) {//Constructor
        this.idIdentificacion = idIdentificacion;
        this.ciudad = ciudad;
        this.entidad = entidad;
    }

    public Usuario(TipoDocumento tipoDocumento) {//Constructor
        this.tipoDocumento = tipoDocumento;
    }

    public long getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(long idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(char grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
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
        try {
            this.password = JsfUtil.generateDigest(password);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public List<Rol> getRol() {
        return rol;
    }

    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }

    public List<Ocupacion> getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(List<Ocupacion> ocupacion) {
        this.ocupacion = ocupacion;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    

    
    
}//Fin clase Usuario

