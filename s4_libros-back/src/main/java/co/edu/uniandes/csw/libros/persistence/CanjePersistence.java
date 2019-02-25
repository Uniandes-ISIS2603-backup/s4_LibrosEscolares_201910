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
import co.edu.uniandes.csw.libros.entities.LibroEntity;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 *
 * @author William Smith
 */
@Stateless
public class CanjePersistence {
    
    @PersistenceContext(unitName = "librosPU")
    protected EntityManager em;
    
    public CanjeEntity create(CanjeEntity canje) {
        em.persist(canje);
        return canje;
    }

    public CanjeEntity find(Long canjeId) {
        return em.find(CanjeEntity.class, canjeId);
    }

    public List<CanjeEntity> findAll() {
        TypedQuery<CanjeEntity> query = em.createQuery("select u from CanjeEntity u", CanjeEntity.class);
        return query.getResultList();
    }
    
    public  CanjeEntity findByOfferedBook(LibroEntity libro)
    {
         TypedQuery<CanjeEntity> query= em.createQuery("select u from CanjeEntity where u.libroOfrecido = :book", CanjeEntity.class);
         query= query.setParameter("book", libro);
         List<CanjeEntity> libros=query.getResultList();
         CanjeEntity resultado=null;
         if(libros!=null && !libros.isEmpty())
         {
             resultado=libros.get(0);
         }
         return resultado;
    }
}
