/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.sessions;

import com.example.laommedic.jpa.entities.Sede;
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
public class SedeSession {
    
    @PersistenceContext//Para conectar la Unit Persistence
    private EntityManager entityManager;
    
    public void create(Sede sede) {//Para crear en la BD
        entityManager.persist(sede);
    }
    
    public void edit(Sede sede) {//Para editar en la BD
        entityManager.merge(sede);
    }
    
    public void remove(Sede sede) {//Para eliminar en la BD 
        entityManager.remove(sede);
    }

    public List<Sede> findAll() {//para consultar en la BD
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Sede.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
