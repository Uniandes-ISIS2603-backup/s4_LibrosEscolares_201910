/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.resources;

import co.edu.uniandes.csw.libros.dtos.CarroComprasDTO;
import co.edu.uniandes.csw.libros.dtos.CarroComprasDetailDTO;
import co.edu.uniandes.csw.libros.ejb.CarroComprasLogic;
import co.edu.uniandes.csw.libros.entities.CarroComprasEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
 * @author Andres Ramirez
 */
@Path("carrosCompras")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CarroCompraResource {

    private static final Logger LOGGER = Logger.getLogger(CarroCompraResource.class.getName());

    @Inject
    private CarroComprasLogic logica;

    @POST
    public CarroComprasDetailDTO createCarroCompras(CarroComprasDetailDTO carro) throws BusinessLogicException {
        CarroComprasEntity entity = carro.toEntity();
        entity = logica.crearCarroCompras(entity);
        return new CarroComprasDetailDTO(entity);
    }

    @GET
    public List<CarroComprasDetailDTO> getAll() {
        List<CarroComprasEntity> entidades = logica.getCarrosCompras();
        if (entidades == null) {
            throw new WebApplicationException("El recurso /respuestas" + " no existe.", 404);
        }

        List<CarroComprasDetailDTO> dtos = new ArrayList<CarroComprasDetailDTO>();
        for (CarroComprasEntity e : entidades) {
            dtos.add(new CarroComprasDetailDTO(e));
        }

        return dtos;
    }

    @GET
    @Path("{carroId: \\d+}")
    public CarroComprasDetailDTO get(@PathParam("carroId") Long id) throws BusinessLogicException {
        CarroComprasEntity entidad = logica.getCarroCompras(id);
        if (entidad == null) {
            throw new WebApplicationException("El recurso /carrosCompras/" + id + " no existe.", 404);
        }
        CarroComprasDetailDTO dto = new CarroComprasDetailDTO(entidad);
        return dto;

    }
    
    @GET
    @Path("/usuario/{usuario}")
    public CarroComprasDetailDTO getCarroUsuario(@PathParam("usuario") Long usuario) throws WebApplicationException
    {
        CarroComprasEntity carro =null;
        try
        {
         carro = logica.getCarroComprasUsuario(usuario);
        }
        catch(BusinessLogicException e)
        {
        }
        if (carro == null) {
            throw new WebApplicationException("El recurso /carrosCompras/" + usuario + " no existe.", 404);
        }
        CarroComprasDetailDTO dto = new CarroComprasDetailDTO(carro);
        return dto;
    }
    @PUT
    @Path("{carroId: \\d+}")
    public CarroComprasDetailDTO updateCarroCompras(@PathParam("carroId") Long id, CarroComprasDetailDTO carro) throws WebApplicationException, BusinessLogicException {
        carro.setId(id);
        if (logica.getCarroCompras(id) == null) {
            throw new WebApplicationException("El recurso /carrosCompras/" + id + " no existe.", 404);
        }
        CarroComprasDetailDTO detailDTO = new CarroComprasDetailDTO(logica.updateCarroCompras(carro.toEntity()));
        return detailDTO;

    }
    
    
    @DELETE
    @Path("{carroId: \\d+}")
    public void deleteCarroCompras(@PathParam("carroId") Long id) throws BusinessLogicException {
        if (logica.getCarroCompras(id) == null) {
            throw new WebApplicationException("El recurso /carrosCompras/" + id + " no existe.", 404);
        }
        logica.deleteCarroCompras(id);

    }

}
