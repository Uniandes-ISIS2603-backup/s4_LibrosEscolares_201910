/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.dtos;

import co.edu.uniandes.csw.libros.entities.CanjeEntity;
import co.edu.uniandes.csw.libros.entities.CarroComprasEntity;
import co.edu.uniandes.csw.libros.entities.LibroEntity;
import co.edu.uniandes.csw.libros.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class UsuarioDetailDTO extends UsuarioDTO implements Serializable {

    private List<TarjetaDeCreditoDTO> tarjetas;
    private List<LibroDTO> libros;
    private List<CanjeDTO> canjesRecibidos;
    private List<CanjeDTO> canjesCreados;
    private CarroComprasDTO carroCompras;

    private static final Logger LOGGER = Logger.getLogger(UsuarioDetailDTO.class.getName());

    public UsuarioDetailDTO() {

    }

    public UsuarioDetailDTO(UsuarioEntity entity) {
        super(entity);
        if (entity != null) {
            if (entity.getTarjetas() != null) {
                tarjetas = new ArrayList<>();
                for (TarjetaDeCreditoEntity te : entity.getTarjetas()) {
                    //  tarjetas.add(new TarjetaDeCreditoDTO(te));
                }
            }
            if (entity.getLibros() != null) {
                libros = new ArrayList<>();
                for (LibroEntity le : entity.getLibros()) {
                    libros.add(new LibroDTO(le));
                }
            }
            if (entity.getCanjesRecibidos() != null) {
                canjesRecibidos = new ArrayList<>();
                for (CanjeEntity ce : entity.getCanjesRecibidos()) {
                    canjesRecibidos.add(new CanjeDTO(ce));
                }
            }
            if (entity.getCanjesCreados() != null) {
                canjesCreados = new ArrayList<>();
                for (CanjeEntity ce : entity.getCanjesCreados()) {
                    canjesCreados.add(new CanjeDTO(ce));
                }
            }
          
            
        }
    }

    @Override
    public UsuarioEntity toEntity() {
        UsuarioEntity entidad = super.toEntity();
        /**
         * if(getTarjetas() !=null) { List<TarjetaDeCreditoEntity> te = new
         * ArrayList<>(); for(TarjetaDeCreditoDTO dtoTarjeta: getTarjetas()) {
         * te.add(dtoTarjeta.toEntity()); } entidad.setTarjetas(te);
        }*
         */
        if (getLibros() != null) {
            List<LibroEntity> le = new ArrayList<>();
            for (LibroDTO dtoLibro : getLibros()) {
                le.add(dtoLibro.toEntity());
            }
            entidad.setLibros(le);
        }
        if (getCanjesRecibidos() != null) {
            List<CanjeEntity> ce = new ArrayList<>();
            for (CanjeDTO dtoCanje : getCanjesRecibidos()) {
                ce.add(dtoCanje.toEntity());
            }
            entidad.setCanjesRecibidos(ce);
        }
        if (getCanjesCreados() != null) {
            List<CanjeEntity> ce = new ArrayList<>();
            LOGGER.log(Level.INFO, "Creando canje: ");
            for (CanjeDTO dtoCanje : getCanjesCreados()) {
                LOGGER.log(Level.INFO, "Creando canje con id: " + dtoCanje.getId());
                CanjeEntity canje = dtoCanje.toEntity();
                LOGGER.log(Level.INFO, "Canje creado con id:  " + canje.getId());
                ce.add(canje);
                LOGGER.log(Level.INFO, "Canje agregado a la lista");

            }
            entidad.setCanjesCreados(ce);
        }/*
        if(ordenesCreadas !=null)
        {
            List<OrdenEntity> oe = new ArrayList<>();
            for(OrdenDTO dtoOrden: ordenesCreadas)
            {
                oe.add(dtoOrden.toEntity());
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

    /**
     * @return the tarjetas
     */
    public List<TarjetaDeCreditoDTO> getTarjetas() {
        return tarjetas;
    }

    /**
     * @param tarjetas the tarjetas to set
     */
    public void setTarjetas(List<TarjetaDeCreditoDTO> tarjetas) {
        this.tarjetas = tarjetas;
    }

    /**
     * @return the libros
     */
    public List<LibroDTO> getLibros() {
        return libros;
    }

    /**
     * @param libros the libros to set
     */
    public void setLibros(List<LibroDTO> libros) {
        this.libros = libros;
    }

    /**
     * @return the canjesRecibidos
     */
    public List<CanjeDTO> getCanjesRecibidos() {
        return canjesRecibidos;
    }

    /**
     * @param canjesRecibidos the canjesRecibidos to set
     */
    public void setCanjesRecibidos(List<CanjeDTO> canjesRecibidos) {
        this.canjesRecibidos = canjesRecibidos;
    }

    /**
     * @return the canjesCreados
     */
    public List<CanjeDTO> getCanjesCreados() {
        return canjesCreados;
    }

    /**
     * @param canjesCreados the canjesCreados to set
     */
    public void setCanjesCreados(List<CanjeDTO> canjesCreados) {
        this.canjesCreados = canjesCreados;
    }

    /**
     * @return the carroCompras
     */
    public CarroComprasDTO getCarroCompras() {
        return carroCompras;
    }

    /**
     * @param carroCompras the carroCompras to set
     */
    public void setCarroCompras(CarroComprasDTO carroCompras) {
        this.carroCompras = carroCompras;
    }

}
