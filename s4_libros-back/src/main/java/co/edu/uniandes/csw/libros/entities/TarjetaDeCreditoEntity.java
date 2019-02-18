/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Miguel Muñoz
 */
@Entity
public class TarjetaDeCreditoEntity extends BaseEntity implements Serializable
{
    private int numero;
    private String fechadevencimiento;
    private int codigodeseguridad;

    public TarjetaDeCreditoEntity() {
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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
