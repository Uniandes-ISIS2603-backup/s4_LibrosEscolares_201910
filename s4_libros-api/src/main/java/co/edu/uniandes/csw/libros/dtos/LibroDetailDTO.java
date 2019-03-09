/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import co.edu.uniandes.csw.libros.entities.LibroEntity;
import java.io.Serializable;

/**
 *
 * @author Miguel Muñoz
 */
public class LibroDetailDTO extends LibroDTO implements Serializable{

    /**
     *
     */
    public LibroDetailDTO() {
        
    }

    public LibroDetailDTO(LibroEntity libroEntity) {
        super();
    }
    
    @Override
    public LibroEntity toEntity()
    {
        LibroEntity entity = super.toEntity();
        return entity;
    }
    
}
