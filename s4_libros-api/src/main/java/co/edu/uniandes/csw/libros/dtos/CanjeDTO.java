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
 * @author estudiante
 */
public class CanjeDTO implements Serializable {
    
    private Integer id;
    
    private Date fechaDeCreacion;
    
    private String estado;
    
    private RespuestaDTO respuesta;
    
    private LibroDTO libroOfrecido;
    
    private LibroDTO libroPedido;
    
    private UsuarioDTO usuarioQueOfrece;
    
    private UsuarioDTO usuarioQueRecibe;
    
    
    
    public void CanjeDTO(){}

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
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
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

    /**
     * @return the libroOfrecido
     */
    public LibroDTO getLibroOfrecido() {
        return libroOfrecido;
    }

    /**
     * @param libroOfrecido the libroOfrecido to set
     */
    public void setLibroOfrecido(LibroDTO libroOfrecido) {
        this.libroOfrecido = libroOfrecido;
    }

    /**
     * @return the libroPedido
     */
    public LibroDTO getLibroPedido() {
        return libroPedido;
    }

    /**
     * @param libroPedido the libroPedido to set
     */
    public void setLibroPedido(LibroDTO libroPedido) {
        this.libroPedido = libroPedido;
    }

    /**
     * @return the usuarioQueOfrece
     */
    public UsuarioDTO getUsuarioQueOfrece() {
        return usuarioQueOfrece;
    }

    /**
     * @param usuarioQueOfrece the usuarioQueOfrece to set
     */
    public void setUsuarioQueOfrece(UsuarioDTO usuarioQueOfrece) {
        this.usuarioQueOfrece = usuarioQueOfrece;
    }

    /**
     * @return the usuarioQueRecibe
     */
    public UsuarioDTO getUsuarioQueRecibe() {
        return usuarioQueRecibe;
    }

    /**
     * @param usuarioQueRecibe the usuarioQueRecibe to set
     */
    public void setUsuarioQueRecibe(UsuarioDTO usuarioQueRecibe) {
        this.usuarioQueRecibe = usuarioQueRecibe;
    }
    
    
}
