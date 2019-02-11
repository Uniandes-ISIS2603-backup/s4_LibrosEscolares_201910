/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.persistence;

import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author nf.jaramillo
 */
@Stateless
public class UsuarioPersistence {

    @PersistenceContext(unitName = "librosPU")
    protected EntityManager em;

    public UsuarioEntity create(UsuarioEntity ue) {
        em.persist(ue);
        return ue;
    }

    public UsuarioEntity find(Long id) {
        return em.find(UsuarioEntity.class, id);
    }
    
    public List<UsuarioEntity> findAll()
    {
        TypedQuery<UsuarioEntity> query = em.createQuery("select u from UsuarioEntity u", UsuarioEntity.class);
        return query.getResultList();
    }
}
