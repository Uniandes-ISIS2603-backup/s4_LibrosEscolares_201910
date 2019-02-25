/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.ejb;

import co.edu.uniandes.csw.libros.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.TarjetaDeCreditoPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Miguel Muñoz
 */
@Stateless
public class TarjetaDeCreditoLogic 
{
    @Inject
    private TarjetaDeCreditoPersistence persistence;
    
    public TarjetaDeCreditoEntity crearTarjetaDeCredito(TarjetaDeCreditoEntity tarjeta) throws BusinessLogicException
    {
       try
       { 
        persistence.verificarNumero(tarjeta) ;
       }
       catch (Exception e)
       {
           throw new BusinessLogicException("El numero de la tajeta ingresado no es valido "+"Numero: "+tarjeta.getNumero());
           
       } 
        tarjeta= persistence.create(tarjeta);
        return tarjeta;
    }
}
