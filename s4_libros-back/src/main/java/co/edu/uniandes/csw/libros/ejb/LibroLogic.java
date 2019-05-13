/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.ejb;

import co.edu.uniandes.csw.libros.entities.LibroEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.LibroPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Miguel Muñoz
 */
@Stateless
public class LibroLogic {
    
       private static final Logger LOGGER = Logger.getLogger(LibroLogic.class.getName());

    @Inject
    private LibroPersistence persistence;

    public LibroEntity crearLibro(LibroEntity libro) throws BusinessLogicException {
        try {
            persistence.verificarISBN(libro.getISBN());
        } catch (Exception e) {
            throw new BusinessLogicException("El ISBN ingresado no es valido " + "ISBN: " + libro.getISBN());

        }
        libro = persistence.create(libro);
        return libro;
    }

    public LibroEntity getLibro(Long librosId) {

        LibroEntity libroEntity = persistence.find(librosId);
        if (libroEntity == null) {
        }
        return libroEntity;
    }

    public List<LibroEntity> getLibros() {
        return persistence.findAll();
    }
    
    public List<LibroEntity> getLibrosPorNombre(String titulo) {
        return persistence.findByName(titulo);
    }
    
    public List<LibroEntity> getLibrosPorAutor(String autor) {
        return persistence.findByAutor(autor);
    }

    public LibroEntity actualizarLibro(LibroEntity entity) {
        return persistence.actualizar(entity);
    }

    public void eliminarLibro(Long librosId) {
        persistence.eliminar(librosId);
    }

}
