/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.sessions;

import com.example.laommedic.jpa.entities.Ciudad;
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
public class CiudadSession {
   
    @PersistenceContext//Para conectar la Unit Persistence
    private EntityManager entityManager;
    
    public void create(Ciudad ciudad) {//Para crear en la BD
        entityManager.persist(ciudad);
    }
    
    public void edit(Ciudad ciudad) {//Para editar en la BD
        entityManager.merge(ciudad);
    }
    
    public void remove(Ciudad ciudad) {//Para eliminar en la BD 
        entityManager.remove(ciudad);
    }

    public List<Ciudad> findAll() {//para consultar en la BD
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Ciudad.class));
        return entityManager.createQuery(cq).getResultList();
    } 
}
