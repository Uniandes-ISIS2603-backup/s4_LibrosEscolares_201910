/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public enum EstadoDelPedidoDTO implements Serializable  {
    
    ACEPTADO_POR_EL_VENDEDOR,
    ENVIADO,
    EN_REVISION,
    RECIBIDO,
    NO_ACEPTADO
    
}
