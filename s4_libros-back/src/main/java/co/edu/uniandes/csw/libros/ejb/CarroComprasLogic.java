/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.ejb;

import co.edu.uniandes.csw.libros.entities.CarroComprasEntity;
import co.edu.uniandes.csw.libros.entities.LibroEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.CarroComprasPersistence;
import co.edu.uniandes.csw.libros.persistence.LibroPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author diego
 */
@Stateless
public class CarroComprasLogic {

    @Inject
    private CarroComprasPersistence persistence;
    @Inject
    private LibroPersistence persistenceLibros;

    public CarroComprasEntity crearCarroCompras(CarroComprasEntity entity) throws BusinessLogicException {
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe un carro de compras con este id: " + entity.getId());
        }
        CarroComprasEntity respuesta = persistence.create(entity);
        return respuesta;
    }

    public CarroComprasEntity getCarroCompras(Long id) throws BusinessLogicException {
        CarroComprasEntity carro = persistence.find(id);
        if (carro == null) {
            throw new BusinessLogicException("No existe un carro de compras con este id: " + id);
        }

        return carro;

    }
    public CarroComprasEntity getCarroComprasUsuario(Long usuario) throws BusinessLogicException {
        CarroComprasEntity carro = persistence.findPorUsuario(usuario);
        if (carro == null) {
            throw new BusinessLogicException("No existe un carro de compras con este id de usuario: " + usuario);
        }

        return carro;

    }

    public CarroComprasEntity updateCarroCompras(CarroComprasEntity entity) {
        return persistence.update(entity);
    }

    public void deleteCarroCompras(Long id) {
        persistence.delete(id);
    }
    
    public List<CarroComprasEntity> getCarrosCompras(){
    return persistence.findAll();
    }
    
    public void removeBook(Long carroId, Long libroId){
    CarroComprasEntity carroEntity = persistence.find(carroId);
    LibroEntity libroEntity = persistenceLibros.find(libroId);
    carroEntity.getLibros().remove(libroEntity);
    }
    
     public void addBook(Long carroId, Long libroId){
    CarroComprasEntity carroEntity = persistence.find(carroId);
    LibroEntity libroEntity = persistenceLibros.find(libroId);
    carroEntity.getLibros().add(libroEntity);
    }

}
