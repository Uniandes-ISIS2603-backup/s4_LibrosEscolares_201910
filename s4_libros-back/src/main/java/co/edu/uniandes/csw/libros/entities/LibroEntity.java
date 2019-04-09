/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.swing.Icon;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Miguel Muñoz
 */
@Entity
public class LibroEntity extends BaseEntity implements Serializable
{
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int edicion;
    private String estado;
    private String portada;
    private Double precio;
    
    @PodamExclude
    @ManyToOne
    private UsuarioEntity usuario;
    /**
     * Te agregué el contructor vacío por que me daba error al intentar desplegar
     * la aplicación. :D
     * Author Diego Gómez
     */
    public LibroEntity()
    {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
}
