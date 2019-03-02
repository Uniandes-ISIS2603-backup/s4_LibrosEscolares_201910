/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.ejb;

import co.edu.uniandes.csw.libros.entities.LibroEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.LibroPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Miguel Muñoz
 */
@Stateless
public class LibroLogic 
{
    @Inject
    private LibroPersistence persistence;
    
    public LibroEntity crearLibro(LibroEntity libro) throws BusinessLogicException
    {
       try
       { 
        persistence.verificarISBN(libro.getISBN()) ;
       }
       catch (Exception e)
       {
           throw new BusinessLogicException("El ISBN ingresado no es valido "+"ISBN: "+libro.getISBN());
           
       } 
        libro= persistence.create(libro);
        return libro;
    }

    public LibroEntity getLibro(Long librosId) {
       
         LibroEntity libroEntity = persistence.find(librosId);
        if (libroEntity == null) {
        }
        return libroEntity;    }
    
}
