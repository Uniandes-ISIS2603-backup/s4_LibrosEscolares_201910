/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

/**
 *
 * @author Miguel Muñoz
 */
public class TarjetaDeCreditoDTO {
    private String numero;
    private String fechadevencimiento;
    private int codigodeseguridad;

    /**
     *
     * @param numero
     * @param fechadevencimiento
     * @param codigodeseguridad
     */
    public TarjetaDeCreditoDTO(String numero, String fechadevencimiento, int codigodeseguridad) {
        this.numero = numero;
        this.fechadevencimiento = fechadevencimiento;
        this.codigodeseguridad = codigodeseguridad;
    }

    /**
     *
     * @return
     */
    public String getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public String getFechadevencimiento() {
        return fechadevencimiento;
    }

    /**
     *
     * @param fechadevencimiento
     */
    public void setFechadevencimiento(String fechadevencimiento) {
        this.fechadevencimiento = fechadevencimiento;
    }

    /**
     *
     * @return
     */
    public int getCodigodeseguridad() {
        return codigodeseguridad;
    }

    /**
     *
     * @param codigodeseguridad
     */
    public void setCodigodeseguridad(int codigodeseguridad) {
        this.codigodeseguridad = codigodeseguridad;
    }
    
}
