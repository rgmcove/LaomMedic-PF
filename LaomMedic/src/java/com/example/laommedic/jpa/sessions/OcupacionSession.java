/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.sessions;

import com.example.laommedic.jpa.entities.Ocupacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author adsi
 */
@Stateless
public class OcupacionSession {

    @PersistenceContext//Para conectar la Unit Persistence
    private EntityManager entityManager;
    
    public void create(Ocupacion ocupacion) {//Para crear en la BD
        entityManager.persist(ocupacion);
    }
    
    public void edit(Ocupacion ocupacion) {//Para editar en la BD
        entityManager.merge(ocupacion);
    }
    
    public void remove(Ocupacion ocupacion) {//Para eliminar en la BD 
        entityManager.remove(ocupacion);
    }

    public List<Ocupacion> findAll() {//para consultar en la BD
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Ocupacion.class));
        return entityManager.createQuery(cq).getResultList();
    } 
    
}
