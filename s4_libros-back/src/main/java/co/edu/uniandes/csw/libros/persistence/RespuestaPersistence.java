/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.persistence;

import co.edu.uniandes.csw.libros.entities.RespuestaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author diegogomez
 */
@Stateless
public class RespuestaPersistence {

    @PersistenceContext(unitName = "librosPU")
    protected EntityManager em;

    public RespuestaEntity create(RespuestaEntity respuesta) {
        em.persist(respuesta);
        return respuesta;
    }

    public RespuestaEntity find(Long respuestaId) {
        return em.find(RespuestaEntity.class, respuestaId);
    }

    public List<RespuestaEntity> findAll() {
        TypedQuery<RespuestaEntity> query = em.createQuery("select u from RespuestaEntity u", RespuestaEntity.class);
        return query.getResultList();
    }

    public void delete(Long respuestaId) {
        RespuestaEntity entity = em.find(RespuestaEntity.class, respuestaId);

        em.remove(entity);
    }

    public RespuestaEntity update(RespuestaEntity entity) {
        return em.merge(entity);
    }

}
