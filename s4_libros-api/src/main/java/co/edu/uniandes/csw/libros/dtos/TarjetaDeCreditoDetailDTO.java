/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import java.io.Serializable;

/**
 *
 * @author Miguel Muñoz
 */
public class TarjetaDeCreditoDetailDTO extends TarjetaDeCreditoDTO implements Serializable {

    public TarjetaDeCreditoDetailDTO(String numero, String fechadevencimiento, int codigodeseguridad) {
        super(numero, fechadevencimiento, codigodeseguridad);
    }

   
    
}
