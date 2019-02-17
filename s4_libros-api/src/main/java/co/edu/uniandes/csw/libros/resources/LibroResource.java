/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.resources;

import co.edu.uniandes.csw.libros.dtos.LibroDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
    
    
    @POST
    public LibroDTO crearLibro(LibroDTO libro)
    {
        return libro;
    }
    
    @GET
    public LibroDTO consultarLibro(LibroDTO libro)
    {
        return libro;
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
