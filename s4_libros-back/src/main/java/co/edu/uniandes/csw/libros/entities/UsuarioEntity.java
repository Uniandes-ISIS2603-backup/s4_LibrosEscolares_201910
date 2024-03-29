/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author nf.jaramillo
 */
@Entity
public class UsuarioEntity extends BaseEntity implements Serializable {
    
    private String correo;
    private String nombreUsuario;
    private int calificacion; 
   @PodamExclude
    @OneToMany(mappedBy = "dueno")
    private List<TarjetaDeCreditoEntity> tarjetas;
    @PodamExclude
    @OneToMany(mappedBy = "usuario")
    private List<LibroEntity> libros;
    @PodamExclude
    @OneToMany(mappedBy = "usuarioQueOfrece", cascade = CascadeType.ALL)
    private List<CanjeEntity> canjesRecibidos;
    @PodamExclude
    @OneToMany(mappedBy = "usuarioQueRecibe", cascade = CascadeType.ALL)
    private List<CanjeEntity> canjesCreados;
   
    
    
   

    public UsuarioEntity()
    {
        
    }
    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param pCorreo the correo to set
     */
    public void setCorreo(String pCorreo) {
        correo = pCorreo;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param pNombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String pNombreUsuario) {
        nombreUsuario = pNombreUsuario;
    }

    /**
     * @return the calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @param pCalificacion the calificacion to set
     */
    public void setCalificacion(int pCalificacion) {
        calificacion = pCalificacion;
    }

    /**
     * @return the tarjetas
     */
    public List<TarjetaDeCreditoEntity> getTarjetas() {
        return tarjetas;
    }

    
    /**
     * @return the libros
     */
    public List<LibroEntity> getLibros() {
        return libros;
    }

  

    /**
     * @return the canjesRecibidos
     */
    public List<CanjeEntity> getCanjesRecibidos() {
        return canjesRecibidos;
    }

   

    /**
     * @return the canjesCreados
     */
    public List<CanjeEntity> getCanjesCreados() {
        return canjesCreados;
    }

    public void setTarjetas(List<TarjetaDeCreditoEntity> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public void setLibros(List<LibroEntity> libros) {
        this.libros = libros;
    }

    public void setCanjesRecibidos(List<CanjeEntity> canjesRecibidos) {
        this.canjesRecibidos = canjesRecibidos;
    }

    public void setCanjesCreados(List<CanjeEntity> canjesCreados) {
        this.canjesCreados = canjesCreados;
    }

  


}
