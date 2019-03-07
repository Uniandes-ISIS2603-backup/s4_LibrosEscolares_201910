/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.ejb;

import co.edu.uniandes.csw.libros.entities.RespuestaEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.RespuestaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author diegogomez
 */
@Stateless
public class RespuestaLogic {
    
    @Inject
    private RespuestaPersistence persistence;
    
    public RespuestaEntity crearRespuesta(RespuestaEntity respuesta)throws BusinessLogicException{
        if(persistence.find(respuesta.getId())!=null){
        throw new BusinessLogicException("Ya existe una respuesta con este id: "+respuesta.getId());
        }
        if(!respuesta.getRazon().equals("") && (respuesta.getFechaEnvio()!=null || respuesta.getCalificacion()!=null)){
        throw new BusinessLogicException("Si la razon es distinto de vacío , fecha de envio y calificacion deperían ser null.");
        }
        
        respuesta= persistence.create(respuesta);
        return respuesta;
    }
     
    
}
