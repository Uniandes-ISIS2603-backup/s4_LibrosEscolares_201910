/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import co.edu.uniandes.csw.libros.entities.CanjeEntity;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 *
 * @author estudiante
 */
@Stateless
public class CanjePersistence {
    
    @PersistenceContext(unitName = "librosPU")
    protected EntityManager em;
    
    public CanjeEntity create(CanjeEntity pedido) {
        em.persist(pedido);
        return pedido;
    }

    public CanjeEntity find(Long pedidoId) {
        return em.find(CanjeEntity.class, pedidoId);
    }

    public List<CanjeEntity> findAll() {
        TypedQuery<CanjeEntity> query = em.createQuery("select u from PedidoEntity u", CanjeEntity.class);
        return query.getResultList();
    }
}
