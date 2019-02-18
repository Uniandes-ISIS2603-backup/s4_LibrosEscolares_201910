/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Diego Gómez
 */
public class PedidoDTO implements Serializable{
    
    private Integer id;
    
    private Date fechaDeCreacion;
    
    private EstadoDelPedidoDTO estado;
    
    private RespuestaDTO respuesta;
    
    
    public void PedidoDTO(){}

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the fechaDeCreacion
     */
    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    /**
     * @param fechaDeCreacion the fechaDeCreacion to set
     */
    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    /**
     * @return the estado
     */
    public EstadoDelPedidoDTO getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoDelPedidoDTO estado) {
        this.estado = estado;
    }

    /**
     * @return the respuesta
     */
    public RespuestaDTO getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(RespuestaDTO respuesta) {
        this.respuesta = respuesta;
    }
    
    
    
    
}
