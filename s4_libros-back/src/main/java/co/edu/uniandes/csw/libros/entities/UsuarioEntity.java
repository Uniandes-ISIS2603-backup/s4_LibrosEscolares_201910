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
    @OneToMany(mappedBy = "usuarioQueOfrece",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CanjeEntity> canjesCreados=new ArrayList<CanjeEntity>();
    
    @PodamExclude
    @OneToMany(mappedBy = "usuarioQueRecibe",cascade = CascadeType.PERSIST)
    private List<CanjeEntity> canjesRecibidos=new ArrayList<CanjeEntity>();
    

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
    public void setCalificacion(int calificacion) {
        calificacion = calificacion;
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
}
