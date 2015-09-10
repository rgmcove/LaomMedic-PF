/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.sessions;

import com.example.laommedic.jpa.entities.Rol;
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
public class RolSession {

    @PersistenceContext//Para conectar la Unit Persistence
    private EntityManager entityManager;
    
    public void create(Rol rol) {//Para crear en la BD
        entityManager.persist(rol);
    }
    
    public void edit(Rol rol) {//Para editar en la BD
        entityManager.merge(rol);
    }
    
    public void remove(Rol rol) {//Para eliminar en la BD 
        entityManager.remove(rol);
    }

    public List<Rol> findAll() {//para consultar en la BD
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Rol.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
