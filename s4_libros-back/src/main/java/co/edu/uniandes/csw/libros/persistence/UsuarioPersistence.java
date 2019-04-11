/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.persistence;

import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import java.util.logging.Logger;
import java.util.List;
import java.util.logging.Level;
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
        
    private static final Logger LOGGER = Logger.getLogger(UsuarioPersistence.class.getName());

    @PersistenceContext(unitName = "librosPU")
    protected EntityManager em;

    public UsuarioEntity create(UsuarioEntity ue) {
        //ue.crearCarro();
         LOGGER.log(Level.INFO, "BBBBBBBBBBBBB:  "+ue.getCarro());
        em.persist(ue);
        
        
        return ue;
    }

    public UsuarioEntity find(Long id) {
         
         UsuarioEntity c = em.find(UsuarioEntity.class, id);
         LOGGER.log(Level.INFO, "CCCCCCCCCCCCCCC:  "+c.getCarro());
        return c;
    }
    
    public List<UsuarioEntity> findAll()
    {
        TypedQuery<UsuarioEntity> query = em.createQuery("select u from UsuarioEntity u", UsuarioEntity.class);
        return query.getResultList();
    }
    
    public UsuarioEntity findByName(String mail)
    {
        TypedQuery<UsuarioEntity> query = em.createQuery("select e From UsuarioEntity e where e.correo = :correo", UsuarioEntity.class);
       
        query = query.setParameter("correo", mail);
        
        List<UsuarioEntity> sameMail = query.getResultList();
        UsuarioEntity result;
        if(sameMail == null)
        {
            result = null;
        }
        else if(sameMail.isEmpty())
        {
            result = null;
        }
        else
        {
            result = sameMail.get(0);
        }
        return result;
    }
    
     /**
     * Actualiza un usuario.
     *
     * @param usuarioEntity: el usuario que viene con los nuevos cambios.
     * Por ejemplo el nombre pudo cambiar. En ese caso, se haria uso del método
     * update.
     * @return un usuario con los cambios aplicados.
     */
    public UsuarioEntity update(UsuarioEntity usuarioEntity) {
        LOGGER.log(Level.INFO, "Actualizando usuario con id = {0}", usuarioEntity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la editorial con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        LOGGER.log(Level.INFO, "Saliendo de actualizar el usuario con id = {0}", usuarioEntity.getId());
        return em.merge(usuarioEntity);
    }
	
    /**
     *
     * Borra un usuario de la base de datos recibiendo como argumento el id
     * del usuario
     *
     * @param usuariosId: id correspondiente a la editorial a borrar.
     */
    public void delete(Long usuariosId) {
        LOGGER.log(Level.INFO, "Borrando usuario con id = {0}", usuariosId);
        // Se hace uso de mismo método que esta explicado en public EditorialEntity find(Long id) para obtener la editorial a borrar.
        UsuarioEntity entity = em.find(UsuarioEntity.class, usuariosId);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from EditorialEntity where id=id;" - "DELETE FROM table_name WHERE condition;" en SQL.*/
        em.remove(entity);
        LOGGER.log(Level.INFO, "Saliendo de borrar el usuario con id = {0}", usuariosId);
    }
    
    /**
     * Busca si hay algun usuario con el correo que se envía de argumento
     *
     * @param correo: correo del usuario que se está buscando
     * @return null si no existe ningun usuario con el correo del argumento.
     * Si existe alguna devuelve la primera.
     */
    public UsuarioEntity findByMail(String correo) {
        LOGGER.log(Level.INFO, "Consultando ususario por correo ", correo);
        // Se crea un query para buscar editoriales con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From UsuarioEntity e where e.correo = :correo", UsuarioEntity.class);
        // Se remplaza el placeholder ":correo" con el valor del argumento 
        query = query.setParameter("correo", correo);
        // Se invoca el query se obtiene la lista resultado
        List<UsuarioEntity> sameMail = query.getResultList();
        UsuarioEntity result;
        if (sameMail == null) {
            result = null;
        } else if (sameMail.isEmpty()) {
            result = null;
        } else {
            result = sameMail.get(0);
        }
        LOGGER.log(Level.INFO, "Saliendo de consultar usuario por correo ", correo);
        return result;
    }
  
}
