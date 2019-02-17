/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Andres Ramirez
 */
public class CarroComprasDetailDTO extends CarroComprasDTO implements Serializable{
    
    
    private List<LibroDTO> libros;
}
