/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import co.edu.uniandes.csw.libros.entities.CarroComprasEntity;
import co.edu.uniandes.csw.libros.entities.LibroEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Ramirez
 */
public class CarroComprasDetailDTO extends CarroComprasDTO implements Serializable {

    private List<LibroDTO> libros = new ArrayList<LibroDTO>();
    private UsuarioDTO dueno;

    public CarroComprasDetailDTO() {
    }

    public CarroComprasDetailDTO(CarroComprasEntity entity) {

        super(entity);

        if (entity.getLibros() != null) {
            for (LibroEntity libro : entity.getLibros()) {
                libros.add(new LibroDTO(libro));

            }
        }
        dueno=new UsuarioDTO(entity.getDueno());
    }

    /**
     * @return the libros
     */
    public List<LibroDTO> getLibros() {
        return libros;
    }

    /**
     * @param libros the libros to set
     */
    public void setLibros(List<LibroDTO> libros) {
        this.libros = libros;
    }

    public CarroComprasEntity toEntity() {
        CarroComprasEntity entity = super.toEntity();
        ArrayList<LibroEntity> entidadesLibros = new ArrayList<LibroEntity>();
        if (!libros.isEmpty()) {
            for (LibroDTO libro : libros) {
                entidadesLibros.add(libro.toEntity());
            }
            entity.setLibros(entidadesLibros);
        }
       
            entity.setDueno(dueno.toEntity());
        
        return entity;
    }

    public UsuarioDTO getDueno() {
        return dueno;
    }

    public void setDueno(UsuarioDTO dueno) {
        this.dueno = dueno;
    }
}
