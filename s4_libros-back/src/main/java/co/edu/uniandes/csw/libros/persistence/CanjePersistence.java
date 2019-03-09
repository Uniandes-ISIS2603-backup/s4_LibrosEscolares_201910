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
 * @author estudiante
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

    
    //public  CanjeEntity findByOfferedBook(LibroEntity libro)
    //{
      //  System.out.println("findbyofferedbook");
        //TypedQuery query = em.createQuery("Select c From CanjeEntity c where c.libroOfrecido= :book", CanjeEntity.class);
        //query = query.setParameter("book", libro);
        //List<CanjeEntity> sameBook = query.getResultList();
        
        //CanjeEntity result;
        //if (sameBook == null) {
        //    result = null;
        //} else if (sameBook.isEmpty()) {
        //    result = null;
        //} else {
        //    result = sameBook.get(0);
        //}
        //return result;
    //}
    
    public CanjeEntity update(CanjeEntity canjeEntity){
        return em.merge(canjeEntity);
    }
    
    public void delete(Long canjeId){
        CanjeEntity canjeEntity=em.find(CanjeEntity.class,canjeId);
        em.remove(canjeEntity);
    }
}
