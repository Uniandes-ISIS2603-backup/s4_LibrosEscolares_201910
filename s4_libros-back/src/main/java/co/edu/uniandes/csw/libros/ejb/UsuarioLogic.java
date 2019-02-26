/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.ejb;

import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.UsuarioPersistence;
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
         // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        UsuarioEntity usuarioEntity;
        usuarioEntity = persistencia.find(usuariosId);
        if (usuarioEntity == null) {
            LOGGER.log(Level.SEVERE, "El usuario con el id = {0} no existe", usuariosId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el usuario con id = {0}", usuariosId);
        return usuarioEntity;
    }
}
