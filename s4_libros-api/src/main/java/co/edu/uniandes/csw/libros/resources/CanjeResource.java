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
    public CanjeDTO crearCanje(CanjeDTO canje) {
        LOGGER.log(Level.INFO, "Empezó creación de canje. id:" + canje.getId());
        CanjeEntity canjeEntity = canje.toEntity();
        LOGGER.log(Level.INFO, "Se creo la entidad a persistir. id:" + canjeEntity.getId());
        System.out.println("entro");
        try {
            canjeEntity = logica.createCanje(canjeEntity);

        } catch (BusinessLogicException ex) {
            throw new WebApplicationException("el recurso /canjes/no existe." + ex.toString(), 404);
        }
        return new CanjeDTO(canjeEntity);
    }

    @GET
    @Path("(canjesId: \\d+)")
    public CanjeDTO getCanje(@PathParam("canjesId") Long canjesId) {
        CanjeEntity entidad = logica.findCanje(canjesId);
        if (entidad == null) {
            throw new WebApplicationException("el recurso /canjes/" + canjesId + "no existe.", 404);
        }
        return new CanjeDTO(entidad);
    }

    @GET
    @Path("/ofrecidos/{userId}")
    public List<CanjeDTO> getCanjesOfrecidos(@PathParam("userId") Long canjesId) {
        List<CanjeEntity> entidades = logica.findOfrecidos(canjesId);
        List<CanjeDTO> canjes = new ArrayList<CanjeDTO>();
        if (entidades == null) {
            throw new WebApplicationException("el recurso /canjes/" + canjesId + "no existe.", 404);
        }
        for (CanjeEntity canje : entidades) {
            canjes.add(new CanjeDTO(canje));
        }
        return canjes;
    }

    @GET
    @Path("/recibidos/{userId}")
    public List<CanjeDTO> getCanjesRecibidos(@PathParam("userId") Long canjesId) {
        List<CanjeEntity> entidades = logica.findRecibido(canjesId);
        List<CanjeDTO> canjes = new ArrayList<CanjeDTO>();
        if (entidades == null) {
            throw new WebApplicationException("el recurso /canjes/" + canjesId + "no existe.", 404);
        }
        for (CanjeEntity canje : entidades) {
            canjes.add(new CanjeDTO(canje));
        }
        return canjes;
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

    @PUT
    @Path("{canjeId: \\d+}/libroOfrecido/{libroId: \\d+}")
    public CanjeDTO addLibroOfrecido(@PathParam("canjeId") Long id, @PathParam("libroId") Long libroId) throws BusinessLogicException {
        if (logica.findCanje(id) == null) {
            throw new WebApplicationException("El recurso /canjes/" + id + "/libroOfrecido/" + libroId + " no existe.", 404);
        }

        CanjeEntity canje = logica.addLibroOfrecido(id, libroId);
        return new CanjeDTO(canje);
    }

    @PUT
    @Path("{canjeId: \\d+}/libroPedido/{libroId: \\d+}")
    public CanjeDTO addLibroPedido(@PathParam("canjeId") Long id, @PathParam("libroId") Long libroId) throws BusinessLogicException {
        if (logica.findCanje(id) == null) {
            throw new WebApplicationException("El recurso /canjes/" + id + "/libroPedido/" + libroId + " no existe.", 404);
        }

        CanjeEntity canje = logica.addLibroPedido(id, libroId);
        return new CanjeDTO(canje);
    }

    @PUT
    @Path("{canjeId: \\d+}/respuesta/{respuestaId: \\d+}")
    public CanjeDTO addRespuesta(@PathParam("canjeId") Long id, @PathParam("respuestaId") Long respuestaId) {
        if (logica.findCanje(id) == null) {
            throw new WebApplicationException("El recurso /canjes/" + id + "/respuesta/" + respuestaId + " no existe.", 404);
        }
        CanjeEntity canje = logica.addRespuesta(id, respuestaId);
        return new CanjeDTO(canje);
    }
    
    

}
