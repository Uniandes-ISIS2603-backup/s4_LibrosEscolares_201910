/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.resources;

import co.edu.uniandes.csw.libros.dtos.LibroDTO;
import co.edu.uniandes.csw.libros.dtos.LibroDetailDTO;
import co.edu.uniandes.csw.libros.ejb.LibroLogic;
import co.edu.uniandes.csw.libros.entities.LibroEntity;
import co.edu.uniandes.csw.libros.entities.LibroEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
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
 * @author Miguel Muñoz
 */

@Path("libros")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class LibroResource {
    
    private static final Logger LOGGER = Logger.getLogger(LibroResource.class.getName()
    );
    
    @Inject
    LibroLogic libroLogic;
    
    
    @POST
    public LibroDTO crearLibro(LibroDTO libro) throws BusinessLogicException
    {
        LOGGER.info("LibroResource crearLibro: input: "+ libro.toString());
        LibroEntity libroEntity = libro.toEntity();
        LibroEntity nuevoLibroEntity = libroLogic.crearLibro(libroEntity);
        LibroDTO nuevoLibroDTO = new LibroDTO(nuevoLibroEntity);
        LOGGER.info("LibroResource crearLibro: output: "+ nuevoLibroDTO.toString());
        return libro;
    }
    
     @GET
    @Path("{librosId: \\d+}")
    public LibroDetailDTO getLibro(@PathParam("librosId") Long librosId) throws WebApplicationException
    {
        LibroEntity libroEntity = libroLogic.getLibro(librosId);
        if(libroEntity == null)
        {
            throw new WebApplicationException("El recurso /libros/"+librosId+ " no existe.",404);
        }
        LibroDetailDTO detailDTO = new LibroDetailDTO(libroEntity);
        
        return detailDTO;
    }
    
    
    
    
   
    
    @PUT
    public LibroDTO actualizarLibro(LibroDTO libro)
    {
        return libro;
    }
    
    @DELETE
    public LibroDTO eliminarLibro(int id )
    {
        return null;
    }
}
