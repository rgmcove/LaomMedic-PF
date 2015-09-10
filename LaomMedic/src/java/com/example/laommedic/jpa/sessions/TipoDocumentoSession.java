/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.sessions;

import com.example.laommedic.jpa.entities.TipoDocumento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Rubén.Gómez
 */
@Stateless
public class TipoDocumentoSession {

    @PersistenceContext//Para conectar la Unit Persistence
    private EntityManager entityManager;
    
    public void create(TipoDocumento tipoDocumento) {//Para crear en la BD
        entityManager.persist(tipoDocumento);
    }
    
    public void edit(TipoDocumento tipoDocumento) {//Para editar en la BD
        entityManager.merge(tipoDocumento);
    }
    
    public void remove(TipoDocumento tipoDocumento) {//Para eliminar en la BD 
        entityManager.remove(tipoDocumento);
    }

    public List<TipoDocumento> findAll() {//para consultar en la BD
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TipoDocumento.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
