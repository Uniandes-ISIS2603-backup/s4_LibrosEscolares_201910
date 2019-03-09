/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.persistence;

import co.edu.uniandes.csw.libros.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
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
public class TarjetaDeCreditoPersistence {

    @PersistenceContext(unitName = "librosPU")
    protected EntityManager em;

    public TarjetaDeCreditoEntity create(TarjetaDeCreditoEntity tarjetaEntity) {

        em.persist(tarjetaEntity);
        return tarjetaEntity;
    }

    public TarjetaDeCreditoEntity find(Long libroId) {

        return em.find(TarjetaDeCreditoEntity.class, libroId);
    }

    public List<TarjetaDeCreditoEntity> findAll() {
        TypedQuery query = em.createQuery("select t from TarjetaDeCreditoEntity t", TarjetaDeCreditoEntity.class);
        return query.getResultList();
    }

    public void verificarNumero(TarjetaDeCreditoEntity tarjeta) throws BusinessLogicException {
        String c = tarjeta.getNumero();
        if (c.length() != 12) {
            throw new BusinessLogicException("Numero no valido");
        }
    }

    public TarjetaDeCreditoEntity actualizar(TarjetaDeCreditoEntity entity) {
        return em.merge(entity);
    }

    public void eliminar(Long tarjetaId) {
        em.remove(tarjetaId);
    }

}
