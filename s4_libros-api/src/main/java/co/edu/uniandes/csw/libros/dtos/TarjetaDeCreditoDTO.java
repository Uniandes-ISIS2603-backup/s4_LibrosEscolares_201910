/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import co.edu.uniandes.csw.libros.entities.TarjetaDeCreditoEntity;

/**
 *
 * @author Miguel Muñoz
 */
public class TarjetaDeCreditoDTO {
    private long id;

    
    private String numero;
    private String fechadevencimiento;
    private int codigodeseguridad;

   
    public TarjetaDeCreditoDTO() {
       
    }

    public TarjetaDeCreditoDTO(TarjetaDeCreditoEntity nuevoTarjetaDeCreditoEntity) {
        if(nuevoTarjetaDeCreditoEntity!=null)
        {
            id=nuevoTarjetaDeCreditoEntity.getId();
            numero=nuevoTarjetaDeCreditoEntity.getNumero();
            fechadevencimiento=nuevoTarjetaDeCreditoEntity.getFechadevencimiento();
            codigodeseguridad=nuevoTarjetaDeCreditoEntity.getCodigodeseguridad();
        }
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public TarjetaDeCreditoEntity toEntity() {
        TarjetaDeCreditoEntity entity = new TarjetaDeCreditoEntity();
        entity.setCodigodeseguridad(codigodeseguridad);
        entity.setFechadevencimiento(fechadevencimiento);
        entity.setNumero(numero);
        entity.setId(id);
         return entity;
    }
  
    
}
