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
     @GET
    public List<TarjetaDeCreditoDetailDTO> getTarjetasDeCreditos() {
        LOGGER.info("TarjetaDeCreditoResource getTarjetaDeCreditos: input: void");
        List<TarjetaDeCreditoDetailDTO> listaTarjetaDeCreditos = listaEntityADetailDTO(tarjetaLogic.getTarjetasDeCreditos());
        LOGGER.log(Level.INFO, "TarjetaDeCreditoResource getTarjetaDeCreditos: output: {0}", listaTarjetaDeCreditos.toString());
        return listaTarjetaDeCreditos;
    }
    
    private List<TarjetaDeCreditoDetailDTO> listaEntityADetailDTO(List<TarjetaDeCreditoEntity> entityList) {
        List<TarjetaDeCreditoDetailDTO> list = new ArrayList<>();
        for (TarjetaDeCreditoEntity entity : entityList) {
            list.add(new TarjetaDeCreditoDetailDTO(entity));
        }
        return list;
    }
    
    
    @PUT
    @Path("{librosId: \\d+}")
    public TarjetaDeCreditoDetailDTO updateTarjetaDeCredito(@PathParam("librosId") Long tarjetaId, TarjetaDeCreditoDetailDTO tarjeta) throws WebApplicationException {
        LOGGER.log(Level.INFO, "TarjetaDeCreditoResource updateTarjetaDeCredito: input: id:{0} , tarjeta: {1}", new Object[]{tarjetaId, tarjeta.toString()});
        tarjeta.setId(tarjetaId);
        if (tarjetaLogic.getTarjetaDeCredito(tarjetaId) == null) {
            throw new WebApplicationException("El recurso /libros/" + tarjetaId + " no existe.", 404);
        }
        TarjetaDeCreditoDetailDTO detailDTO = new TarjetaDeCreditoDetailDTO(tarjetaLogic.actualizarTarjetaDeCredito(tarjeta.toEntity()));
        LOGGER.log(Level.INFO, "TarjetaDeCreditoResource updateTarjetaDeCredito: output: {0}", detailDTO.toString());
        return detailDTO;

    }

 
    @DELETE
    @Path("{tarjetaId: \\d+}")
    public void deleteTarjetaDeCredito(@PathParam("tarjetaId") Long tarjetaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "TarjetaDeCreditoResource deleteTarjetaDeCredito: input: {0}", tarjetaId);
        if (tarjetaLogic.getTarjetaDeCredito(tarjetaId) == null) {
            throw new WebApplicationException("El recurso /libros/" + tarjetaId + " no existe.", 404);
        }
        tarjetaLogic.eliminarTarjetaDeCredito(tarjetaId);
        LOGGER.info("TarjetaDeCreditoResource deleteTarjetaDeCredito: output: void");
    }
}
