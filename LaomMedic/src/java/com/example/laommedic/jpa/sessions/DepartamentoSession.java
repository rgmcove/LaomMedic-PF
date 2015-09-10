/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.sessions;

import com.example.laommedic.jpa.entities.Departamento;
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
public class DepartamentoSession {

    @PersistenceContext//Para conectar la Unit Persistence
    private EntityManager entityManager;

    public void create(Departamento departamento) {//Para crear en la BD
        entityManager.persist(departamento);
    }

    public void edit(Departamento departamento) {//Para editar en la BD
        entityManager.merge(departamento);
    }

    public void remove(Departamento departamento) {//Para eliminar en la BD 
        entityManager.remove(departamento);
    }

    public List<Departamento> findAll() {//para consultar en la BD
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Departamento.class));
        return entityManager.createQuery(cq).getResultList();
    }

}
