/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.resources;

import co.edu.uniandes.csw.libros.dtos.PedidoDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
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
public class PedidoResource {
    
        private static final Logger LOGGER = Logger.getLogger(RespuestaResource.class.getName());
        
        @POST
        public PedidoDTO crearPedido(PedidoDTO pedido){
        return pedido;
        }
    
    
}
