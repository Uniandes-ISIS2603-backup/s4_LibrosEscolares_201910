/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import java.io.Serializable;

/**
 *
 * @author nf.jaramillo
 */
public class UsuarioDTO implements Serializable {

    private Long id;
    private String correo;
    private String nombreUsuario;
    private Integer calificacion;

    public UsuarioDTO()
    {
        
    }
    public UsuarioDTO(UsuarioEntity entity)
    {
        if(entity!=null)
        {
             nombreUsuario= entity.getNombreUsuario();
             correo = entity.getCorreo();
             calificacion = entity.getCalificacion();
             id = entity.getId();
        }
      
    }
    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    
    
    public UsuarioEntity toEntity() {
    UsuarioEntity entity = new UsuarioEntity();
    entity.setNombreUsuario(nombreUsuario);
    entity.setCorreo(correo);
    entity.setCalificacion(calificacion);
    entity.setId(id);
    return entity;
}

}
