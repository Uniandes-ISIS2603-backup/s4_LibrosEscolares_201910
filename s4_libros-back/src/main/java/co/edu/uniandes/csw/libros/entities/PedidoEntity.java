/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diegogomez
 */
@Entity
public class PedidoEntity extends BaseEntity implements Serializable {


    @Temporal(TemporalType.DATE)
    private Date fechaDeCreacion;

    public PedidoEntity() {
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

}
