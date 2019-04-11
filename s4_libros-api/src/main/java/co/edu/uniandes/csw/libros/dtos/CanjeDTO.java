/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import co.edu.uniandes.csw.libros.entities.CanjeEntity;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author estudiante
 */
public class CanjeDTO implements Serializable {
    
    private Long id;
    
    private Date fechaDeCreacion;
    
    private String estado;
    
    private RespuestaDTO respuesta;
    
    private LibroDTO libroOfrecido;
    
    private LibroDTO libroPedido;
    
    private UsuarioDTO usuarioQueOfrece;
    
    private UsuarioDTO usuarioQueRecibe;
    
    
    
    public void CanjeDTO(){}
    
    public CanjeDTO(CanjeEntity entidad){
        setId(entidad.getId());
        setFechaDeCreacion(entidad.getFechaDeCreacion());
     setEstado(entidad.getEstado());
       // setRespuesta(new RespuestaDTO(entidad.getRespuesta()));
        setLibroOfrecido(new LibroDTO(entidad.getLibroOfrecido()));
        setLibroPedido(new LibroDTO(entidad.getLibroPedido()));
        setUsuarioQueOfrece(new UsuarioDTO(entidad.getUsuarioQueOfrece()));
        setUsuarioQueRecibe(new UsuarioDTO(entidad.getUsuarioQueRecibe()));
    }
    
    public CanjeEntity toEntity(){
        CanjeEntity entidad=new CanjeEntity();
        entidad.setId(this.getId());
        entidad.setFechaDeCreacion(this.getFechaDeCreacion());
        entidad.setEstado(this.getEstado());
        entidad.setRespuesta(this.getRespuesta().toEntity());
        entidad.setLibroOfrecido(this.getLibroOfrecido().toEntity());
        entidad.setLibroPedido(this.getLibroPedido().toEntity());
        entidad.setUsuarioQueOfrece(this.getUsuarioQueOfrece().toEntity());
        entidad.setUsuarioQueRecibe(this.getUsuarioQueRecibe().toEntity());
        return entidad;
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
        if(respuesta!=null){
        this.respuesta = respuesta;
        }
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
