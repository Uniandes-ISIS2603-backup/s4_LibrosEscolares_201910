/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class UsuarioDetailDTO extends UsuarioDTO implements Serializable{
    
    private List<TarjetaDeCreditoDTO> tarjetas;
    private List<LibroDTO> libros;
    private List<CanjeDTO> canjesRecibidos;
    private List<CanjeDTO> canjesCreados;
   //private List<OrdenDTO> ordenesCreadas;
   // private List<PedidoDTO> ordenesRecibidas;
    
    public UsuarioDetailDTO()
    {
        
    }
    
    public UsuarioDetailDTO(UsuarioEntity entity)
    {
        super(entity);
        if(entity !=null)
        {
            nombreUsuario= entity.getNombreUsuario();
            correo = entity.getCorreo();
            calificacion = entity.getCalificacion();
            id = entity.getId();
        }
    } 
}
