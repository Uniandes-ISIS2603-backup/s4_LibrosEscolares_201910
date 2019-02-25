/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import co.edu.uniandes.csw.libros.entities.CanjeEntity;
import co.edu.uniandes.csw.libros.entities.LibroEntity;
import co.edu.uniandes.csw.libros.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import java.io.Serializable;
import java.util.ArrayList;
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
   // private List<OrdenDTO> ordenesRecibidas;
    
    public UsuarioDetailDTO()
    {
        
    }
    
    public UsuarioDetailDTO(UsuarioEntity entity)
    {
        super(entity);
        if(entity !=null)
        {
            if(entity.getTarjetas()!=null)
            {
                tarjetas = new ArrayList<>();
                for(TarjetaDeCreditoEntity te : entity.getTarjetas())
                {
                  //  tarjetas.add(new TarjetaDeCreditoDTO(te));
                }
            }
            if(entity.getLibros()!=null)
            {
                libros = new ArrayList<>();
                for(LibroEntity le : entity.getLibros())
                {
                  //  libros.add(new LibroDTO(le));
                }
            }
            if(entity.getCanjesRecibidos()!=null)
            {
                canjesRecibidos = new ArrayList<>();
                for(CanjeEntity ce : entity.getCanjesRecibidos())
                {
                  //  canjesRecibidos.add(new CanjeDTO(ce));
                }
            }
            if(entity.getCanjesCreados()!=null)
            {
                canjesCreados = new ArrayList<>();
                for(CanjeEntity ce : entity.getCanjesCreados())
                {
                  //  canjesCreados.add(new CanjeDTO(ce));
                }
            }
            /*
            if(entity.getOrdenesCreadas()!=null)
            {
                ordenesCreadas = new ArrayList<>();
                for(OrdenEntity oe : entity.getOrdenesCreadas())
                {
                  //  ordenesCreadas.add(new OrdenDTO(oe));
                }
            }
            if(entity.getOrdenesRecibidas()!=null)
            {
                ordenesRecibidas = new ArrayList<>();
                for(OrdenEntity oe : entity.getOrdenesRecibidas())
                {
                  //  ordenesRecibidas.add(new OrdenDTO(oe));
                }
            }*/
        }
    }
    @Override
    public UsuarioEntity toEntity()
    {
        UsuarioEntity entidad = super.toEntity();
        if(tarjetas !=null)
        {
            List<TarjetaDeCreditoEntity> te = new ArrayList<>();
            for(TarjetaDeCreditoDTO dtoTarjeta: tarjetas)
            {
                //te.add(dtoTarjeta.toEntity());
            }
        }
        if(libros !=null)
        {
            List<LibroEntity> le = new ArrayList<>();
            for(LibroDTO dtoLibro: libros)
            {
                //le.add(dtoLibro.toEntity());
            }
        }
        if(canjesRecibidos !=null)
        {
            List<CanjeEntity> ce = new ArrayList<>();
            for(CanjeDTO dtoCanje: canjesRecibidos)
            {
                //ce.add(dtoCanje.toEntity());
            }
        }
        if(canjesCreados !=null)
        {
            List<CanjeEntity> ce = new ArrayList<>();
            for(CanjeDTO dtoCanje: canjesCreados)
            {
                //ce.add(dtoCanje.toEntity());
            }
        }/*
        if(ordenesCreadas !=null)
        {
            List<OrdenEntity> oe = new ArrayList<>();
            for(OrdenDTO dtoOrden: ordenesCreadas)
            {
                //oe.add(dtoOrden.toEntity());
            }
        }
        if(ordenesRecibidas !=null)
        {
            List<OrdenEntity> oe = new ArrayList<>();
            for(OrdenDTO dtoOrden: ordenesRecibidas)
            {
                //oe.add(dtoOrden.toEntity());
            }
        }*/
        return entidad;
    }
    
}
