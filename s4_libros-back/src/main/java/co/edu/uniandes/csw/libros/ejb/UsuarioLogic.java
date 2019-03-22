/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.ejb;

import co.edu.uniandes.csw.libros.entities.LibroEntity;
import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.UsuarioPersistence;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 *      
 * @author nf.jaramillo
 */

@Stateless
public class UsuarioLogic {
    
    private static final Logger LOGGER = Logger.getLogger(UsuarioLogic.class.getName());

    
    @Inject
    private UsuarioPersistence persistencia;
    
    public UsuarioEntity createUsuario(UsuarioEntity usuario) throws BusinessLogicException{
        
        if(persistencia.findByName(usuario.getCorreo()) != null)
        {
            throw new BusinessLogicException("Ya existe un usuario con ese correo");
        }
        
        usuario = persistencia.create(usuario);
        return usuario;
    }
    
    public UsuarioEntity getUsuario(Long usuariosId){
        LOGGER.log(Level.INFO, "Inicia el proceso de consultar el usuario con id = {0}", usuariosId);
         // Note que,  por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        UsuarioEntity usuarioEntity;
        usuarioEntity = persistencia.find(usuariosId);
        if (usuarioEntity == null) {
            LOGGER.log(Level.SEVERE, "El usuario con el id = {0} no existe", usuariosId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el usuario con id = {0}", usuariosId);
        return usuarioEntity;
    }
    
    /**
     *
     * Obtener todas las editoriales existentes en la base de datos.
     *
     * @return una lista de editoriales.
     */
    public List<UsuarioEntity> getUsuarios() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los usuarios");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<UsuarioEntity> usuarios = persistencia.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los usuarios");
        return usuarios;
    }
    
    /**
     *
     * Actualizar un usuario.
     *
     * @param usuarioId: id del usuario para buscarla en la base de
     * datos.
     * @param UsuarioEntity: usuario con los cambios para ser actualizada,
     * por ejemplo el nombre.
     * @return el usuario con los cambios actualizados en la base de datos.
     */
    public UsuarioEntity updateUsuario(Long usuarioId, UsuarioEntity usuarioEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el usuario con id = {0}", usuarioId);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        UsuarioEntity newEntity = persistencia.update(usuarioEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el usuario con id = {0}", usuarioEntity.getId());
        return newEntity;
    }

    /**
     * Borrar un usuario
     *
     * @param usuariosId: id del usuario a borrar
     * @throws BusinessLogicException Si la editorial a eliminar tiene libros.
     */
    public void deleteUsuario(Long usuariosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el usuario con id = {0}", usuariosId);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        List<LibroEntity> libros = getUsuario(usuariosId).getLibros();
        if (libros != null && !libros.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar la editorial con id = " + usuariosId + " porque tiene libros asociados");
        }
        persistencia.delete(usuariosId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el usuario con id = {0}", usuariosId);
    }
}
