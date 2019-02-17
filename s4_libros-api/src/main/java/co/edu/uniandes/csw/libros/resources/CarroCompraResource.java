/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.resources;

import co.edu.uniandes.csw.libros.dtos.CarroComprasDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Andres Ramirez
 */
@Path("carrosCompras")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CarroCompraResource {
    
    private static final Logger LOGGER = Logger.getLogger(CarroCompraResource.class.getName());
    
    
    @POST
    public CarroComprasDTO createCarroCompras(CarroComprasDTO carro) {
        return carro;
    }
    
     
    
    
}
