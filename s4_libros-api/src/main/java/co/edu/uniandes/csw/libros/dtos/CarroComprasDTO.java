/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import co.edu.uniandes.csw.libros.entities.CarroComprasEntity;
import java.io.Serializable;

/**
 *
 * @author Andres Ramirez, Diego Gómez
 */
public class CarroComprasDTO implements Serializable{
    
    private Long id;
    private Double valorPagar;
    private UsuarioDTO comprador;
    private String nombreU;
    
    public CarroComprasDTO(){
        
    }
    
    public CarroComprasDTO(CarroComprasEntity entity){
    id = entity.getId();
    valorPagar = entity.getValorPagar();
    
    nombreU = entity.getNombreU();
    
    
    comprador = new UsuarioDTO(entity.getComprador());
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
    
    
    public CarroComprasEntity toEntity(){
    CarroComprasEntity carro = new CarroComprasEntity();
    carro.setId(this.getId());
    carro.setNombreU(this.nombreU);
    carro.setValorPagar(valorPagar);
    
    //TODO
    carro.setComprador(comprador.toEntity());
    
    
    
    return carro;
    }
    
    
    
    
}
