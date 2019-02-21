/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.test.logic;

import co.edu.uniandes.csw.libros.ejb.TarjetaDeCreditoLogic;
import co.edu.uniandes.csw.libros.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.libros.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.TarjetaDeCreditoPersistence;
import co.edu.uniandes.csw.libros.persistence.TarjetaDeCreditoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Miguel Muñoz
 */
@RunWith(Arquillian.class)
public class TarjetaDeCreditoLogicTest {

private PodamFactory factory = new PodamFactoryImpl();

@Inject
private TarjetaDeCreditoLogic libroLogic;

 @PersistenceContext
private EntityManager em;

 @Inject
private UserTransaction utx;

private List<TarjetaDeCreditoEntity> data = new ArrayList<TarjetaDeCreditoEntity>();


@Deployment
public static JavaArchive createDeployment()       
{
    return ShrinkWrap.create(JavaArchive.class)
            .addPackage(TarjetaDeCreditoEntity.class.getPackage())
            .addPackage(TarjetaDeCreditoLogic.class.getPackage())
            .addPackage(TarjetaDeCreditoPersistence.class.getPackage())
            .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
            .addAsManifestResource("META-INF/beans.xml","beans.xml");

}



  /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from TarjetaDeCreditoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            TarjetaDeCreditoEntity entity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);

            em.persist(entity);
            data.add(entity);

        }
    }
    
    @Test
    public void createTarjetaDeCreditoTest() throws BusinessLogicException 
    {
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaDeCreditoEntity newEntity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);
        newEntity.setNumero("754324475272");
        TarjetaDeCreditoEntity result = libroLogic.crearTarjetaDeCredito(newEntity);
        Assert.assertNotNull(result);
        TarjetaDeCreditoEntity entity = em.find(TarjetaDeCreditoEntity.class,result.getId());
        Assert.assertEquals(newEntity.getId(),entity.getId());
        Assert.assertEquals(newEntity.getNumero(),entity.getNumero());
        
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createTarjetaDeCreditoConMismoNumeroTest() throws BusinessLogicException
    {
        TarjetaDeCreditoEntity newEntity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);
        newEntity.setNumero(data.get(0).getNumero());
        libroLogic.crearTarjetaDeCredito(newEntity);
    }


}
