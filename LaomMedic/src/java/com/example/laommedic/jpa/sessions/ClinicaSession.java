/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.sessions;

import com.example.laommedic.jpa.entities.Clinica;
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
public class ClinicaSession {

    @PersistenceContext//Para conectar la Unit Persistence
    private EntityManager entityManager;
    
    public void create(Clinica clinica) {//Para crear en la BD
        entityManager.persist(clinica);
    }
    
    public void edit(Clinica clinica) {//Para editar en la BD
        entityManager.merge(clinica);
    }
    
    public void remove(Clinica clinica) {//Para eliminar en la BD 
        entityManager.remove(clinica);
    }

    public List<Clinica> findAll() {//para consultar en la BD
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Clinica.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
