/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import java.io.Serializable;

/**
 *
 * @author Diego Gómez
 */
public class PedidoDetailDTO extends PedidoDTO implements Serializable {
    
    private LibroDTO librosOfrecidos;
    
    private LibroDTO librosPedidos;
    
    private UsuarioDTO comprador;
    
    private UsuarioDTO vendedor;
    
    public PedidoDetailDTO() {
    }

    /**
     * @return the librosOfrecidos
     */
    public LibroDTO getLibrosOfrecidos() {
        return librosOfrecidos;
    }

    /**
     * @param librosOfrecidos the librosOfrecidos to set
     */
    public void setLibrosOfrecidos(LibroDTO librosOfrecidos) {
        this.librosOfrecidos = librosOfrecidos;
    }

    /**
     * @return the librosPedidos
     */
    public LibroDTO getLibrosPedidos() {
        return librosPedidos;
    }

    /**
     * @param librosPedidos the librosPedidos to set
     */
    public void setLibrosPedidos(LibroDTO librosPedidos) {
        this.librosPedidos = librosPedidos;
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
     * @return the vendedor
     */
    public UsuarioDTO getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(UsuarioDTO vendedor) {
        this.vendedor = vendedor;
    }
    
    
}
