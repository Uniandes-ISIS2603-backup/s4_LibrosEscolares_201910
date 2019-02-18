/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.persistence;

import co.edu.uniandes.csw.libros.entities.PedidoEntity;
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
public class PedidoPersistence {

    @PersistenceContext(unitName = "librosPU")
    protected EntityManager em;

    public PedidoEntity create(PedidoEntity pedido) {
        em.persist(pedido);
        return pedido;
    }

    public PedidoEntity find(Long pedidoId) {
        return em.find(PedidoEntity.class, pedidoId);
    }

    public List<PedidoEntity> findAll() {
        TypedQuery<PedidoEntity> query = em.createQuery("select u from PedidoEntity u", PedidoEntity.class);
        return query.getResultList();
    }

}
