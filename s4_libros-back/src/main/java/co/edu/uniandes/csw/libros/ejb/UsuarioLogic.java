/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.ejb;

import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.UsuarioPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author nf.jaramillo
 */

@Stateless
public class UsuarioLogic {
    
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
}
