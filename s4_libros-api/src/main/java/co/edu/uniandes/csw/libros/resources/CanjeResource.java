/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.resources;

import co.edu.uniandes.csw.libros.dtos.CanjeDTO;
import co.edu.uniandes.csw.libros.ejb.CanjeLogic;
import co.edu.uniandes.csw.libros.entities.CanjeEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import java.io.Serializable;
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
 * @author estudiante
 */
@Path("canjes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CanjeResource {
    
    @Inject
    private CanjeLogic logica;
    
    private static final Logger LOGGER = Logger.getLogger(CanjeResource.class.getName());
        
        @POST
        public CanjeDTO crearCanje(CanjeDTO canje)throws BusinessLogicException{
            CanjeEntity canjeEntity=canje.toEntity();
            canjeEntity=logica.createCanje(canjeEntity);
            return new CanjeDTO(canjeEntity);
        }
        
        @GET
        @Path("(canjesId: \\d+)")
        public CanjeDTO getCanje(@PathParam("canjesId") Long canjesId){
            CanjeEntity entidad=logica.findCanje(canjesId);
            if(entidad==null){
                throw new WebApplicationException("el recurso /canjes/"+canjesId+"no existe.",404);
            }
            return new CanjeDTO(entidad);
        }
        
        @GET
    public List<CanjeDTO> getEditorials() {
        List<CanjeDTO> listaEditoriales = listEntity2DetailDTO(logica.findCanjes());
        return listaEditoriales;
    }
    
    private List<CanjeDTO> listEntity2DetailDTO(List<CanjeEntity> entityList) {
        List<CanjeDTO> list = new ArrayList<>();
        for (CanjeEntity entity : entityList) {
            list.add(new CanjeDTO(entity));
        }
        return list;
    }
    
    @PUT
    @Path("{canjesId: \\d+}")
    public CanjeDTO updateEditorial(@PathParam("canjesId") Long canjesId, CanjeDTO canje) throws WebApplicationException {
        canje.setId(canjesId);
        if (logica.findCanje(canjesId) == null) {
            throw new WebApplicationException("El recurso /canjes/" + canjesId + " no existe.", 404);
        }
        CanjeDTO detailDTO = new CanjeDTO(logica.updateCanje(canjesId, canje.toEntity()));
        return detailDTO;

    }
    
    @DELETE
    @Path("{canjesId: \\d+}")
    public void deleteEditorial(@PathParam("canjesId") Long canjesId) throws BusinessLogicException {
        if (logica.findCanje(canjesId) == null) {
            throw new WebApplicationException("El recurso /canjes/" + canjesId + " no existe.", 404);
        }
        logica.deleteCanje(canjesId);
    }
    
}
