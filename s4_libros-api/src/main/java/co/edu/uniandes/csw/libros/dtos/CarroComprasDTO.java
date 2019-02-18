/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import java.io.Serializable;

/**
 *
 * @author Andres Ramirez
 */
public class CarroComprasDTO implements Serializable{
    
    private Double valorPagar;
    private UsuarioDTO comprador;
    private String nombreU;
    
    public CarroComprasDTO(){
        
    }

    /**
     * @return the valorPagar
     */
    public Double getValorPagar() {
        return valorPagar;
    }

    /**
     * @param valorPagar the valorPagar to set
     */
    public void setValorPagar(Double valorPagar) {
        this.valorPagar = valorPagar;
    }

    /**
     * @return the comprador
     */
    public UsuarioDTO getComprador() {
        return comprador;
    }

    /**
     * @param comprador the comprador to set
     */
    public void setComprador(UsuarioDTO comprador) {
        this.comprador = comprador;
    }

    /**
     * @return the nombreU
     */
    public String getNombreU() {
        return nombreU;
    }

    /**
     * @param nombreU the nombreU to set
     */
    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    
    
    
    
}
