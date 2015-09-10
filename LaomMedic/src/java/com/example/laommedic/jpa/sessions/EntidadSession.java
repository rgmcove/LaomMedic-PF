
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.sessions;

import com.example.laommedic.jpa.entities.Entidad;
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
public class EntidadSession {

    @PersistenceContext//Para conectar la Unit Persistence
    private EntityManager entityManager;
    
    public void create(Entidad entidad) {//Para crear en la BD
        entityManager.persist(entidad);
    }
    
    public void edit(Entidad entidad) {//Para editar en la BD
        entityManager.merge(entidad);
    }
    
    public void remove(Entidad entidad) {//Para eliminar en la BD 
        entityManager.remove(entidad);
    }

    public List<Entidad> findAll() {//para consultar en la BD
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Entidad.class));
        return entityManager.createQuery(cq).getResultList();
    }
    
}

