/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Andres Ramirez
 */
@Entity
public class CarroComprasEntity extends BaseEntity implements Serializable{
    
    private Double valorPagar;
    private String  nombreU;
    /*
    @OneToOne(mappedBy = "carroCompras", fetch = FetchType.LAZY)
    private UsuarioEntity comprador;
    
    @OneToMany(mappedBy = "carroCompras", fetch = FetchType.EAGER)
    private List<LibroEntity> libros = new ArrayList<>();
    */
    @PodamExclude
    private UsuarioEntity dueno;
    
    public CarroComprasEntity(){
        
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
    /*
    public void setComprador(UsuarioEntity entity){
    comprador = entity;
    }
    
    public UsuarioEntity getComprador(){
    return comprador;
    }
    */


    /*
    public List<LibroEntity> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroEntity> libros) {
        this.libros = libros;
    }*/
    
}
