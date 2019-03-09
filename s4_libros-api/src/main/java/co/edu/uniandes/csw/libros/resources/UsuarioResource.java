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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
    
     @GET
    public List<UsuarioDetailDTO> getEditorials() {
        LOGGER.info("UsuarioResource getUsuarios: input: void");
        List<UsuarioDetailDTO> listaUsuarios = listEntity2DetailDTO(logica.getUsuarios());
        LOGGER.log(Level.INFO, "UsuarioResource getUsuarios: output: {0}", listaUsuarios.toString());
        return listaUsuarios;
    }
    
    private List<UsuarioDetailDTO> listEntity2DetailDTO(List<UsuarioEntity> entityList) {
        List<UsuarioDetailDTO> list = new ArrayList<>();
        for (UsuarioEntity entity : entityList) {
            list.add(new UsuarioDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Actualiza el usuario con el id recibido en la URL con la informacion
     * que se recibe en el cuerpo de la petición.
     *
     * @param usuariosId Identificador del usuario que se desea
     * actualizar. Este debe ser una cadena de dígitos.
     * @param usuario {@link UsuarioDetailDTO}El usuario que se desea
     * guardar.
     * @return JSON {@link UsuarioDetailDTO} - La editorial guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la editorial a
     * actualizar.
     */
    @PUT
    @Path("{usuariosId: \\d+}")
    public UsuarioDetailDTO updateEditorial(@PathParam("usuariosId") Long usuariosId, UsuarioDetailDTO usuario) throws WebApplicationException {
        LOGGER.log(Level.INFO, "UsuarioResource updateUsuario: input: id:{0} , usuario: {1}", new Object[]{usuariosId, usuario.toString()});
        usuario.setId(usuariosId);
        if (logica.getUsuario(usuariosId) == null) {
            throw new WebApplicationException("El recurso /usuarios/" + usuariosId + " no existe.", 404);
        }
        UsuarioDetailDTO detailDTO = new UsuarioDetailDTO(logica.updateUsuario(usuariosId, usuario.toEntity()));
        LOGGER.log(Level.INFO, "UsuarioResource updateUsuario: output: {0}", detailDTO.toString());
        return detailDTO;

    }

    /**
     * Borra el usuario con el id asociado recibido en la URL.
     *
     * @param usuariosId Identificador del usuario que se desea borrar.
     * Este debe ser una cadena de dígitos.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede eliminar la editorial.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la editorial.
     */
    @DELETE
    @Path("{usuariosId: \\d+}")
    public void deleteEditorial(@PathParam("usuariosId") Long usuariosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "UsuarioResource deleteUsuario: input: {0}", usuariosId);
        if (logica.getUsuario(usuariosId) == null) {
            throw new WebApplicationException("El recurso /usuarios/" + usuariosId + " no existe.", 404);
        }
        logica.deleteUsuario(usuariosId);
        LOGGER.info("UsuarioResource deleteUsuario: output: void");
    }
}

