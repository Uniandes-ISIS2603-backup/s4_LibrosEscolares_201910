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
    
    public CanjeEntity createCanje(CanjeEntity canje){
        canje=persistence.create(canje);
        return canje;
    }
    
}
