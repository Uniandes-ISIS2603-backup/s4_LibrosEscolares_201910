/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.persistence;

import co.edu.uniandes.csw.libros.entities.LibroEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Miguel Muñoz
 */
@Stateless
public class LibroPersistence {
    @PersistenceContext(unitName="librosPU")
    protected EntityManager em;
    
    public LibroEntity create (LibroEntity libroEntity){
        
        em.persist(libroEntity);
        return libroEntity;
    }
    public LibroEntity find (Long libroId){
  
        return em.find(LibroEntity.class, libroId);
    }
    public List<LibroEntity> findAll()
    {
       TypedQuery query= em.createQuery("select u from LibroEntity", LibroEntity.class);
       return query.getResultList();
    }
}
