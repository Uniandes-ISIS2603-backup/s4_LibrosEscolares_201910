/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.persistence;

import co.edu.uniandes.csw.libros.entities.CarroComprasEntity;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andres Ramirez
 */
@Stateless
public class CarroComprasPersistence {

    @PersistenceContext(unitName = "librosPU")
    protected EntityManager em;

    public CarroComprasEntity create(CarroComprasEntity carroComprasEntity) {
        em.persist(carroComprasEntity);
        return carroComprasEntity;
    }

    public CarroComprasEntity find(Long carroComprasId) {

        return em.find(CarroComprasEntity.class, carroComprasId);

    }
    
     public CarroComprasEntity findPorUsuario(Long usuario) {

         
       TypedQuery<CarroComprasEntity> query = em.createQuery("select u from CarroComprasEntity u", CarroComprasEntity.class);        
        List<CarroComprasEntity> lista=query.getResultList();
        Iterator<CarroComprasEntity> iterador=lista.iterator();
       CarroComprasEntity names = iterador.next();
       while(iterador.hasNext()&&names.getDueno().getId()!=usuario)
       {
           names = iterador.next();
       }
       
        return names;

    }

    public List<CarroComprasEntity> findAll() {
        TypedQuery<CarroComprasEntity> query = em.createQuery("select u from CarroComprasEntity u", CarroComprasEntity.class);
        return query.getResultList();
    }

    public void delete(Long carroId) {
        CarroComprasEntity carroCompras = em.find(CarroComprasEntity.class, carroId);
        em.remove(carroCompras);
    }

    public CarroComprasEntity update(CarroComprasEntity entity) {
        return em.merge(entity);
    }
}
