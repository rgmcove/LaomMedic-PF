/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.sessions;

import com.example.laommedic.jpa.entities.Pais;
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
public class PaisSession {
    
    @PersistenceContext//Para conectar la Unit Persistence
    private EntityManager entityManager;
    
    public void create(Pais pais) {//Para crear en la BD
        entityManager.persist(pais);
    }
    
    public void edit(Pais pais) {//Para editar en la BD
        entityManager.merge(pais);
    }
    
    public void remove(Pais pais) {//Para eliminar en la BD 
        entityManager.remove(pais);
    }

    public List<Pais> findAll() {//para consultar en la BD
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Pais.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
