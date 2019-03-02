/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.resources;

import co.edu.uniandes.csw.libros.dtos.TarjetaDeCreditoDTO;
import co.edu.uniandes.csw.libros.dtos.TarjetaDeCreditoDetailDTO;
import co.edu.uniandes.csw.libros.ejb.TarjetaDeCreditoLogic;
import co.edu.uniandes.csw.libros.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
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
 * @author Miguel Muñoz
 */

@Path("tarjetasDeCredito")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class TarjetaDeCreditoResource {
    
    private static final Logger LOGGER = Logger.getLogger(TarjetaDeCreditoResource.class.getName()
    );
    
    @Inject
    TarjetaDeCreditoLogic tarjetaLogic;
    
    
    @POST
    public TarjetaDeCreditoDTO crearTarjetaDeCredito(TarjetaDeCreditoDTO tarjeta) throws BusinessLogicException
    {
        LOGGER.info("TarjetaDeCreditoResource crearTarjetaDeCredito: input: "+ tarjeta.toString());
        TarjetaDeCreditoEntity tarjetaEntity = tarjeta.toEntity();
        TarjetaDeCreditoEntity nuevoTarjetaDeCreditoEntity = tarjetaLogic.crearTarjetaDeCredito(tarjetaEntity);
        TarjetaDeCreditoDTO nuevoTarjetaDeCreditoDTO = new TarjetaDeCreditoDTO(nuevoTarjetaDeCreditoEntity);
        LOGGER.info("TarjetaDeCreditoResource crearTarjetaDeCredito: output: "+ nuevoTarjetaDeCreditoDTO.toString());
        return tarjeta;
    }
    
     @GET
    @Path("{tarjetasId: \\d+}")
    public TarjetaDeCreditoDetailDTO getTarjetaDeCredito(@PathParam("tarjetasId") Long tarjetasId) throws WebApplicationException
    {
        TarjetaDeCreditoEntity tarjetaEntity = tarjetaLogic.getTarjetaDeCredito(tarjetasId);
        if(tarjetaEntity == null)
        {
            throw new WebApplicationException("El recurso /tarjetas/"+tarjetasId+ " no existe.",404);
        }
        TarjetaDeCreditoDetailDTO detailDTO = new TarjetaDeCreditoDetailDTO(tarjetaEntity);
        
        return detailDTO;
    }
    
}
