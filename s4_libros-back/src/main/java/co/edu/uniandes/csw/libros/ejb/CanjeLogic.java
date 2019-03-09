/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.ejb;

import co.edu.uniandes.csw.libros.entities.CanjeEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.CanjePersistence;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author William Smith
 */

@Stateless
public class CanjeLogic {
    
    private static final Logger LOGGER = Logger.getLogger(CanjeLogic.class.getName());
    
    @Inject
    private CanjePersistence persistence;
    
    public CanjeEntity createCanje(CanjeEntity canje)throws BusinessLogicException{
//        if (canje.getUsuarioQueOfrece().getId()==canje.getUsuarioQueRecibe().getId()){
//            throw new BusinessLogicException("Un usuario no puede ofrecerse un canje a si mismo");
//        }
//        else if(canje.getLibroOfrecido().getId()==canje.getLibroPedido().getId()){
//            throw new BusinessLogicException("No se puede ofrecer un libro en canje a cambio de si mismo");
//        }
        persistence.create(canje);
        return canje;
    }
    
    public CanjeEntity findCanje(Long canjeId){
        CanjeEntity canjeEntity=persistence.find(canjeId);
        if(canjeEntity==null){
            LOGGER.log(Level.SEVERE, "El canje con el id = {0} no existe", canjeId);
        }
        return canjeEntity;
    }
    
    public List<CanjeEntity> findCanjes(){
        List<CanjeEntity> lista=persistence.findAll();
        return lista;
    }
    
    public CanjeEntity updateCanje(Long canjeId, CanjeEntity canjeEntity){
        CanjeEntity newCanjeEntity=persistence.update(canjeEntity);
        return newCanjeEntity;
    }
    
    public void deleteCanje(Long canjeId){
        persistence.delete(canjeId);
    }
    
}
