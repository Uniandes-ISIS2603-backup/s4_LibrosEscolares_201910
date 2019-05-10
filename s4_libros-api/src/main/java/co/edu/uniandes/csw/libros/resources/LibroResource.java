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
 * @author Miguel Muñoz
 */

@Path("libros")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class LibroResource {
    
    private static final Logger LOGGER = Logger.getLogger(LibroResource.class.getName());
    
    @Inject
    LibroLogic libroLogic;
    
    
    @POST
    public LibroDTO crearLibro(LibroDTO libro) throws BusinessLogicException
    {
        LOGGER.info("LibroResource crearLibro: input: "+ libro.toString());
        LibroEntity libroEntity = libro.toEntity();
        LOGGER.info("LibroResource crearLibro:  "+ libroEntity.toString());
        LibroEntity nuevoLibroEntity = libroLogic.crearLibro(libroEntity);
        LibroDTO nuevoLibroDTO = new LibroDTO(nuevoLibroEntity);
        LOGGER.info("LibroResource crearLibro: output: "+ nuevoLibroDTO.toString());
        return nuevoLibroDTO;
    }
    
      @GET
    @Path("{librosId: \\d+}")
    public LibroDetailDTO getLibro(@PathParam("librosId") Long librosId) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "LibroResource getLibro: input: {0}", librosId);
        LibroEntity entidad = libroLogic.getLibro(librosId);
        if(entidad == null)
        {
            throw new WebApplicationException("El recurso /libros/"+librosId+ " no existe.",404);
        }
        LibroDetailDTO detailDTO = new LibroDetailDTO(entidad);
        LOGGER.log(Level.INFO, "LibroResource getLibro: output: {0}", detailDTO.toString());
        
        return detailDTO;
    }
    
     @GET
    public List<LibroDetailDTO> getLibros() {
        LOGGER.info("LibroResource getLibros: input: void");
        List<LibroDetailDTO> listaLibros = listaEntityADetailDTO(libroLogic.getLibros());
        LOGGER.log(Level.INFO, "LibroResource getLibros: output: {0}", listaLibros.toString());
        return listaLibros;
    }
    
   
    
    private List<LibroDetailDTO> listaEntityADetailDTO(List<LibroEntity> entityList) {
        List<LibroDetailDTO> list = new ArrayList<>();
        for (LibroEntity entity : entityList) {
            list.add(new LibroDetailDTO(entity));
        }
        return list;
    }
    
    
    @PUT
    @Path("{librosId: \\d+}")
    public LibroDetailDTO updateLibro(@PathParam("librosId") Long librosId, LibroDetailDTO libro) throws WebApplicationException {
        LOGGER.log(Level.INFO, "LibroResource updateLibro: input: id:{0} , libro: {1}", new Object[]{librosId, libro.toString()});
        libro.setId(librosId);
        if (libroLogic.getLibro(librosId) == null) {
            throw new WebApplicationException("El recurso /libros/" + librosId + " no existe.", 404);
        }
        LibroDetailDTO detailDTO = new LibroDetailDTO(libroLogic.actualizarLibro(libro.toEntity()));
        libroLogic.eliminarLibro(libro.getId());
        LOGGER.log(Level.INFO, "LibroResource updateLibro: output: {0}", detailDTO.toString());
        return detailDTO;

    }

 
    @DELETE
    @Path("{librosId: \\d+}")
    public LibroDetailDTO deleteLibro(@PathParam("librosId") Long librosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "LibroResource deleteLibro: input: {0}", librosId);
       LibroEntity libro= libroLogic.getLibro(librosId);
        if (libro == null) {
            throw new WebApplicationException("El recurso /libros/" + librosId + " no existe.", 404);
        }
          LibroDetailDTO detailDTO = new LibroDetailDTO(libro);
        libroLogic.eliminarLibro(librosId);
        LOGGER.info("LibroResource deleteLibro: output: void");
         return detailDTO;
    }
    
          @GET
    @Path("/nombre/{nombre}")
    public List<LibroDetailDTO> getLibrosPorNombre(@PathParam("nombre") String nombre) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Libro getLibrosPorNombre: ", nombre);
        List<LibroDetailDTO> listaLibros = listaEntityADetailDTO(libroLogic.getLibrosPorNombre(nombre));
       
        if(listaLibros.isEmpty())
        {
            throw new WebApplicationException("No existen libros con el nombre: "+nombre,404);
        }
        return listaLibros;
    }
}