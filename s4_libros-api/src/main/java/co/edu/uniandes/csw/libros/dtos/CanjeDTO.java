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

    public CanjeDTO() {
    }

    public CanjeDTO(CanjeEntity entidad) {
        if (entidad != null) {
            setId(entidad.getId());
            setFechaDeCreacion(entidad.getFechaDeCreacion());
            setEstado(entidad.getEstado());
            if (entidad.getRespuesta() != null) {
                setRespuesta(new RespuestaDTO(entidad.getRespuesta()));
            }
            if(entidad.getLibroPedido()!=null){
            setLibroPedido(new LibroDTO(entidad.getLibroPedido()));
                    }
            if (entidad.getLibroOfrecido() != null) {
                setLibroOfrecido(new LibroDTO(entidad.getLibroOfrecido()));
            }
            if (entidad.getUsuarioQueRecibe() != null) {
                setLibroPedido(new LibroDTO(entidad.getLibroPedido()));
            }
            if (entidad.getUsuarioQueOfrece() != null) {
                setUsuarioQueOfrece(new UsuarioDTO(entidad.getUsuarioQueOfrece()));
            }
            if (entidad.getUsuarioQueRecibe() != null) {
                setUsuarioQueRecibe(new UsuarioDTO(entidad.getUsuarioQueRecibe()));
            }
        }
    }

    public CanjeEntity toEntity() {
        CanjeEntity entidad = new CanjeEntity();
        entidad.setId(this.getId());
        entidad.setFechaDeCreacion(this.getFechaDeCreacion());
        entidad.setEstado(this.getEstado());
        if (this.getRespuesta() != null) {
            entidad.setRespuesta(this.getRespuesta().toEntity());
        }
        if (this.getLibroOfrecido() != null) {
            entidad.setLibroOfrecido(this.getLibroOfrecido().toEntity());
        }
        if (this.getLibroPedido() != null) {
            entidad.setLibroPedido(this.getLibroPedido().toEntity());
        }
        if (this.getUsuarioQueOfrece() != null) {
            entidad.setUsuarioQueOfrece(this.getUsuarioQueOfrece().toEntity());
        }
        if (this.getUsuarioQueRecibe() != null) {
            entidad.setUsuarioQueRecibe(this.getUsuarioQueRecibe().toEntity());
        }
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

  
    public RespuestaDTO getRespuesta() {
        return respuesta;
    }


    public void setRespuesta(RespuestaDTO respuesta) {
        if (respuesta != null) {
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
