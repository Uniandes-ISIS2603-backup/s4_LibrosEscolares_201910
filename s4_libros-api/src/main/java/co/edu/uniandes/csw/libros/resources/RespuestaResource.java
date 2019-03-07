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
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
    public RespuestaDTO crearRespuesta(RespuestaDTO respuesta) throws BusinessLogicException{
        
        RespuestaEntity entity = respuesta.toEntity();
        entity = logica.crearRespuesta(entity);
        return new RespuestaDTO(entity);

    }
    
    
}
