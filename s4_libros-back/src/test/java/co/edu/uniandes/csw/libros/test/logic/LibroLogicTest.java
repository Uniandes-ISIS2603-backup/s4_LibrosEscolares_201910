/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.libros.test.logic;

import co.edu.uniandes.csw.libros.ejb.LibroLogic;
import co.edu.uniandes.csw.libros.entities.LibroEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.LibroPersistence;
import java.util.ArrayList;
import java.util.List;
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
public class LibroLogicTest {

private PodamFactory factory = new PodamFactoryImpl();

@Inject
private LibroLogic libroLogic;

 @PersistenceContext
private EntityManager em;

 @Inject
private UserTransaction utx;

private List<LibroEntity> data = new ArrayList<LibroEntity>();


@Deployment
public static JavaArchive createDeployment()       
{
    return ShrinkWrap.create(JavaArchive.class)
            .addPackage(LibroEntity.class.getPackage())
            .addPackage(LibroLogic.class.getPackage())
            .addPackage(LibroPersistence.class.getPackage())
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
        em.createQuery("delete from LibroEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            LibroEntity entity = factory.manufacturePojo(LibroEntity.class);

            em.persist(entity);
            data.add(entity);

        }
    }
    
    @Test
    public void createLibroTest() throws BusinessLogicException 
    {
        PodamFactory factory = new PodamFactoryImpl();
        LibroEntity newEntity = factory.manufacturePojo(LibroEntity.class);
        newEntity.setISBN("7540-3244-75-27-2");
        LibroEntity result = libroLogic.crearLibro(newEntity);
        Assert.assertNotNull(result);
        LibroEntity entity = em.find(LibroEntity.class,result.getId());
        Assert.assertEquals(newEntity.getId(),entity.getId());
        Assert.assertEquals(newEntity.getTitulo(),entity.getTitulo());
        
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createLibroConMismoISBNTest() throws BusinessLogicException
    {
        LibroEntity newEntity = factory.manufacturePojo(LibroEntity.class);
        newEntity.setISBN(data.get(0).getISBN());
        libroLogic.crearLibro(newEntity);
    }


}
