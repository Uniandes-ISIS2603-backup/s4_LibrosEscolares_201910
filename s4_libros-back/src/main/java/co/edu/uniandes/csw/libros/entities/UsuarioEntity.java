/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author nf.jaramillo
 */
@Entity
public class UsuarioEntity extends BaseEntity implements Serializable {
    
    private String correo;
    private String nombreUsuario;
    private int calificacion; 
    private List<TarjetaDeCreditoEntity> tarjetas;
    private List<LibroEntity> libros;
    private List<CanjeEntity> canjesRecibidos;
    private List<CanjeEntity> canjesCreados;
   //private List<OrdenEntity> ordenesCreadas;
   // private List<OrdenEntity> ordenesRecibidas;

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
     * @param tarjetas the tarjetas to set
     */
    public void setTarjetas(List<TarjetaDeCreditoEntity> tarjetas) {
        this.tarjetas = tarjetas;
    }

    /**
     * @return the libros
     */
    public List<LibroEntity> getLibros() {
        return libros;
    }

    /**
     * @param libros the libros to set
     */
    public void setLibros(List<LibroEntity> libros) {
        this.libros = libros;
    }

    /**
     * @return the canjesRecibidos
     */
    public List<CanjeEntity> getCanjesRecibidos() {
        return canjesRecibidos;
    }

    /**
     * @param canjesRecibidos the canjesRecibidos to set
     */
    public void setCanjesRecibidos(List<CanjeEntity> canjesRecibidos) {
        this.canjesRecibidos = canjesRecibidos;
    }

    /**
     * @return the canjesCreados
     */
    public List<CanjeEntity> getCanjesCreados() {
        return canjesCreados;
    }

    /**
     * @param canjesCreados the canjesCreados to set
     */
    public void setCanjesCreados(List<CanjeEntity> canjesCreados) {
        this.canjesCreados = canjesCreados;
    }

    


}
