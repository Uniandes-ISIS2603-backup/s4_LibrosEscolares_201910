/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.jpa.config.Cascade;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author estudiante
 */
@Entity
public class CanjeEntity extends BaseEntity implements Serializable {
    
    
    @Temporal(TemporalType.DATE)
    private Date fechaDeCreacion;
    
    private String estado;
    
    @PodamExclude
    @OneToOne
    private LibroEntity libroOfrecido;
    
    
    @PodamExclude
    @OneToOne
    private LibroEntity libroPedido;
    
    @PodamExclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UsuarioEntity usuarioQueOfrece;
    
    @PodamExclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UsuarioEntity usuarioQueRecibe;
    
    @PodamExclude
    @OneToOne(cascade= CascadeType.PERSIST)
    private RespuestaEntity respuesta;

    public CanjeEntity(){
        
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
     * @return the libroOfrecido
     */
    public LibroEntity getLibroOfrecido() {
        return libroOfrecido;
    }

    /**
     * @param libroOfrecido the libroOfrecido to set
     */
    public void setLibroOfrecido(LibroEntity libroOfrecido) {
        this.libroOfrecido = libroOfrecido;
    }

    /**
     * @return the libroPedido
     */
    public LibroEntity getLibroPedido() {
        return libroPedido;
    }

    /**
     * @param libroPedido the libroPedido to set
     */
    public void setLibroPedido(LibroEntity libroPedido) {
        this.libroPedido = libroPedido;
    }

    /**
     * @return the usuarioQueOfrece
     */
    public UsuarioEntity getUsuarioQueOfrece() {
        return usuarioQueOfrece;
    }

    /**
     * @param usuarioQueOfrece the usuarioQueOfrece to set
     */
    public void setUsuarioQueOfrece(UsuarioEntity usuarioQueOfrece) {
        this.usuarioQueOfrece = usuarioQueOfrece;
    }

    /**
     * @return the usuarioQueRecibe
     */
    public UsuarioEntity getUsuarioQueRecibe() {
        return usuarioQueRecibe;
    }

    /**
     * @param usuarioQueRecibe the usuarioQueRecibe to set
     */
    public void setUsuarioQueRecibe(UsuarioEntity usuarioQueRecibe) {
        this.usuarioQueRecibe = usuarioQueRecibe;
    }

    /**
     * @return the respuesta
     */
    public RespuestaEntity getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(RespuestaEntity respuesta) {
        this.respuesta = respuesta;
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
     
}
