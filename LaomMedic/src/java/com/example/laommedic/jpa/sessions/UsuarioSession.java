/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.laommedic.jpa.sessions;

import com.example.laommedic.jpa.entities.Usuario;
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
public class UsuarioSession {

    @PersistenceContext//Para conectar la Unit Persistence
    private EntityManager entityManager;
    
    public void create(Usuario usuario) {//Para crear en la BD
        entityManager.persist(usuario);
    }
    
    public void edit(Usuario usuario) {//Para editar en la BD
        entityManager.merge(usuario);
    }
    
    public void remove(Usuario usuario) {//Para eliminar en la BD 
        entityManager.remove(usuario);
    }

    public List<Usuario> findAll() {//para consultar en la BD
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Usuario.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
