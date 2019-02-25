/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.resources;

import co.edu.uniandes.csw.libros.dtos.UsuarioDTO;
import co.edu.uniandes.csw.libros.dtos.UsuarioDetailDTO;
import co.edu.uniandes.csw.libros.ejb.UsuarioLogic;
import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author nf.jaramillo
 */

@Path("usuarios")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class UsuarioResource {
    private static final Logger LOGGER = Logger.getLogger(UsuarioResource.class.getName());
    
    @Inject 
    private UsuarioLogic logica;
    
    @POST
    public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws BusinessLogicException
    {
        UsuarioEntity ue = usuario.toEntity();
        ue = logica.createUsuario(ue);
        return new UsuarioDTO(ue);
    }

    /**
     *
     * @param usuariosId
     * @return
     */
    @GET
    @Path("{usuariosId: \\d+}")
    public UsuarioDetailDTO getUsuario(@PathParam("usuariosId") Long usuariosId) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "UsuarioResource getUsuario: input: {0}", usuariosId);
        UsuarioEntity entidad = logica.getUsuario(usuariosId);
        if(entidad == null)
        {
            throw new WebApplicationException("El recurso /usuarios/"+usuariosId+ " no existe.",404);
        }
        UsuarioDetailDTO detailDTO = new UsuarioDetailDTO(entidad);
        LOGGER.log(Level.INFO, "UsuarioResource getUsuario: output: {0}", detailDTO.toString());
        
        return detailDTO;
    }
}

