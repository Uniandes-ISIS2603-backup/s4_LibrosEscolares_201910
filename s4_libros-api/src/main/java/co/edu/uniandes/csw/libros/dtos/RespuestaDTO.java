/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import co.edu.uniandes.csw.libros.entities.RespuestaEntity;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Diego Gómez
 */
public class RespuestaDTO implements Serializable {

    private Long id;

    private String razon;

    private Integer calificacion;

    private String comentario;

    private Date fechaEnvio;

    public RespuestaDTO(RespuestaEntity entity) {
        if(entity!=null){
        razon = entity.getRazon();
        comentario = entity.getComentario();
        calificacion = entity.getCalificacion();
        fechaEnvio = entity.getFechaEnvio();
        id = entity.getId();
        }
    }

    public RespuestaDTO() {
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the razon
     */
    public String getRazon() {
        return razon;
    }

    /**
     * @param razon the razon to set
     */
    public void setRazon(String razon) {
        this.razon = razon;
    }

    /**
     * @return the calificacion
     */
    public Integer getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the fechaEnvio
     */
    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    /**
     * @param fechaEnvio the fechaEnvio to set
     */
    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public RespuestaEntity toEntity() {

        RespuestaEntity respuesta = new RespuestaEntity();
        respuesta.setId(this.id);
        respuesta.setRazon(this.razon);
        respuesta.setCalificacion(this.calificacion);
        respuesta.setComentario(this.comentario);
        respuesta.setFechaEnvio(this.fechaEnvio);
        return respuesta;
    }

}
