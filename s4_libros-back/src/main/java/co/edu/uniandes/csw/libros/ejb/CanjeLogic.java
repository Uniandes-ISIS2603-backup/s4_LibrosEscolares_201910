/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.ejb;

import co.edu.uniandes.csw.libros.entities.CanjeEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.CanjePersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author William Smith
 */

@Stateless
public class CanjeLogic {
    
    @Inject
    private CanjePersistence persistence;
    
    public CanjeEntity createCanje(CanjeEntity canje)throws BusinessLogicException{
        CanjeEntity c=persistence.findByOfferedBook(canje.getLibroOfrecido());
        if(c!=null){
            throw new BusinessLogicException("Ya existe un canje ofreciendo este libro");
        }
        else if (canje.getUsuarioQueOfrece().equals(canje.getUsuarioQueRecibe())){
            throw new BusinessLogicException("Un usuario no puede ofrecerse un canje a si mismo");
        }
        else if(canje.getLibroOfrecido().equals(canje.getLibroPedido())){
            throw new BusinessLogicException("No se puede ofrecer un libro en canje a cambio de si mismo");
        }
        canje=persistence.create(canje);
        return canje;
    }
    
}
