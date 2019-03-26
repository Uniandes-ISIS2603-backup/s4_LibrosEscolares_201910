/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.resources;

import co.edu.uniandes.csw.libros.dtos.RespuestaDTO;
import co.edu.uniandes.csw.libros.ejb.RespuestaLogic;
import co.edu.uniandes.csw.libros.entities.RespuestaEntity;
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
 * @author Diego Gómez
 */
@Path("respuestas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class RespuestaResource {

    private static final Logger LOGGER = Logger.getLogger(RespuestaResource.class.getName());

    @Inject
    private RespuestaLogic logica;

    @POST
    public RespuestaDTO crearRespuesta(RespuestaDTO respuesta) throws BusinessLogicException {

        RespuestaEntity entity = respuesta.toEntity();
        entity = logica.crearRespuesta(entity);
        return new RespuestaDTO(entity);

    }
    @GET
    public List<RespuestaDTO> getRespuestas() throws WebApplicationException, BusinessLogicException {
        List<RespuestaEntity> entidades = logica.getRespuestas();
        if (entidades == null) {
            throw new WebApplicationException("El recurso /respuestas"  + " no existe.", 404);
        }
        List<RespuestaDTO> respuesta = new ArrayList<RespuestaDTO>();
        for(RespuestaEntity e: entidades){
        respuesta.add(new RespuestaDTO(e));
        }

        return respuesta;
    }

    @GET
    @Path("{respuestaId: \\d+}")
    public RespuestaDTO getRespuesta(@PathParam("respuestaId") Long id) throws WebApplicationException, BusinessLogicException {
        RespuestaEntity entidad = logica.getRespuesta(id);
        if (entidad == null) {
            throw new WebApplicationException("El recurso /respuestas/" + id + " no existe.", 404);
        }
        RespuestaDTO detailDTO = new RespuestaDTO(entidad);

        return detailDTO;
    }

    @PUT
    @Path("{respuestaId: \\d+}")
    public RespuestaDTO updateRespuesta(@PathParam("respuestaId") Long id, RespuestaDTO respuesta) throws WebApplicationException, BusinessLogicException {
        respuesta.setId(id);
        if (logica.getRespuesta(id) == null) {
            throw new WebApplicationException("El recurso /respuestas/" + id + " no existe.", 404);
        }
        RespuestaDTO detailDTO = new RespuestaDTO(logica.updateRespuesta(respuesta.toEntity()));
        return detailDTO;

    }

    @DELETE
    @Path("{RespuestaId: \\d+}")
    public void deleteRespuesta(@PathParam("RespuestaId") Long id) throws BusinessLogicException {
        if (logica.getRespuesta(id) == null) {
            throw new WebApplicationException("El recurso /respuestas/" + id + " no existe.", 404);
        }
        logica.deleteRespuesta(id);

    }

}
