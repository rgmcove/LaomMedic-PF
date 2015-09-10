/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.sessions;

import com.example.laommedic.jpa.entities.Regimen;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Liceth.Albornoz
 */
@Stateless
public class RegimenSession {

    @PersistenceContext//Para conectar la Unit Persistence
    private EntityManager entityManager;
    
    public void create(Regimen regimen) {//Para crear en la BD
        entityManager.persist(regimen);
    }
    
    public void edit(Regimen regimen) {//Para editar en la BD
        entityManager.merge(regimen);
    }
    
    public void remove(Regimen regimen) {//Para eliminar en la BD 
        entityManager.remove(regimen);
    }

    public List<Regimen> findAll() {//para consultar en la BD
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Regimen.class));
        return entityManager.createQuery(cq).getResultList();
    }

}
