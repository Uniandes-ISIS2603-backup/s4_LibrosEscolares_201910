/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Miguel Muñoz
 */
@Entity
public class TarjetaDeCreditoEntity extends BaseEntity implements Serializable
{
    private String numero;
    private String fechadevencimiento;
    private int codigodeseguridad;
    @PodamExclude 
    @ManyToOne
    private UsuarioEntity dueno;

    public TarjetaDeCreditoEntity() {
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechadevencimiento() {
        return fechadevencimiento;
    }

    public void setFechadevencimiento(String fechadevencimiento) {
        this.fechadevencimiento = fechadevencimiento;
    }

    public int getCodigodeseguridad() {
        return codigodeseguridad;
    }

    public void setCodigodeseguridad(int codigodeseguridad) {
        this.codigodeseguridad = codigodeseguridad;
    }

    
}
