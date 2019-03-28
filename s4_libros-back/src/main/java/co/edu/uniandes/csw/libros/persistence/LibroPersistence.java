/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.persistence;

import co.edu.uniandes.csw.libros.entities.LibroEntity;
import java.util.List;
import java.util.logging.Logger;
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
    
     private static final Logger LOGGER = Logger.getLogger(LibroPersistence.class.getName());

    @PersistenceContext(unitName = "librosPU")
    protected EntityManager em;

    public LibroEntity create(LibroEntity libroEntity) {

        em.persist(libroEntity);
        return libroEntity;
    }

    public LibroEntity find(Long libroId) {

        return em.find(LibroEntity.class, libroId);
    }

    public List<LibroEntity> findAll() {
        TypedQuery<LibroEntity> query = em.createQuery("select u from LibroEntity u", LibroEntity.class);
        return query.getResultList();
    }

    public LibroEntity findByName(String titulo) {
        TypedQuery query = em.createQuery("select u from LibroEntity where u.titulo = :title", LibroEntity.class);
        query = query.setParameter("title", titulo);
        List<LibroEntity> names = query.getResultList();
        LibroEntity resultado = null;
        if (names != null && !names.isEmpty()) {
            resultado = names.get(0);
        }
        return resultado;
    }

    public void verificarISBN(String ISBN) throws Exception {

        String t = ISBN.replaceAll("-", "");
        int s = 0;
        for (int i = 0; i < 12; i++) {
            s += Character.getNumericValue(t.charAt(i));
        }
        int u = Character.getNumericValue(t.charAt(12));
        if (t.length() != 13 || s % u != 0) {
            throw new Exception();
        }

    }

    public LibroEntity actualizar(LibroEntity libroEntity) {

        return em.merge(libroEntity);
    }

    public void eliminar(long id) {
        em.remove(id);
    }
}
