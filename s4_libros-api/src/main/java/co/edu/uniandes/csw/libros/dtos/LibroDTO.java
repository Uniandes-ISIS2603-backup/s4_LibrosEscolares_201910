/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import co.edu.uniandes.csw.libros.entities.LibroEntity;
import java.io.Serializable;
import javax.swing.Icon;

/**
 *
 * @author Miguel Muñoz
 */
public class LibroDTO implements Serializable{
    
    private Long id;
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private Integer edicion;
    private String estado;
    private Icon portada;
    private Double precio;

    /**
     *
     */
    public LibroDTO() {
    }

    public LibroDTO(LibroEntity nuevoLibroEntity) {
        if(nuevoLibroEntity!=null)
        {
            id=nuevoLibroEntity.getId();
            ISBN=nuevoLibroEntity.getISBN();
            titulo=nuevoLibroEntity.getTitulo();
            autor=nuevoLibroEntity.getAutor();
            editorial=nuevoLibroEntity.getEditorial();
            edicion=nuevoLibroEntity.getEdicion();
            estado=nuevoLibroEntity.getEstado();
            portada=nuevoLibroEntity.getPortada();
            precio=nuevoLibroEntity.getPrecio();

        }
    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     *
     * @param ISBN
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     *
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     *
     * @return
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     *
     * @param editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     *
     * @return
     */
    public int getEdicion() {
        return edicion;
    }

    /**
     *
     * @param edicion
     */
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    /**
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    public Icon getPortada() {
        return portada;
    }

    /**
     *
     * @param portada
     */
    public void setPortada(Icon portada) {
        this.portada = portada;
    }

    /**
     *
     * @return
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    } 
    
     public LibroEntity toEntity() {
    LibroEntity entity = new LibroEntity();
    entity.setISBN(ISBN);
    entity.setTitulo(titulo);
    entity.setAutor(autor);
    entity.setEditorial(editorial);
    entity.setEdicion(edicion);
    entity.setEstado(estado);
    entity.setPortada(portada);
    entity.setPrecio(precio);
    return entity;
}
    
}
