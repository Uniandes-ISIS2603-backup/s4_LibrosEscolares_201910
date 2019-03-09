/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.test.persistence;

import co.edu.uniandes.csw.libros.entities.CanjeEntity;
import co.edu.uniandes.csw.libros.entities.LibroEntity;
import co.edu.uniandes.csw.libros.persistence.CanjePersistence;
import co.edu.uniandes.csw.libros.persistence.LibroPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author William Smith
 */
@RunWith(Arquillian.class)
public class CanjeEntityPersistenceTest {
    
    @Inject
    private CanjePersistence cp;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;

    private List<CanjeEntity> data = new ArrayList<CanjeEntity>();
    
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
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
    
    private void clearData() {
        em.createQuery("delete from CanjeEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {

           CanjeEntity entity = factory.manufacturePojo(CanjeEntity.class);

            em.persist(entity);

            data.add(entity);
        }
    }
    
    @Deployment
    public static JavaArchive createDeployment (){
         return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CanjeEntity.class.getPackage())
                .addPackage(CanjePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    @Test
    public void createCanjeTest(){
        
        PodamFactory factory=new PodamFactoryImpl();
        CanjeEntity newCanjeEntity=factory.manufacturePojo(CanjeEntity.class);
        CanjeEntity ce=cp.create(newCanjeEntity);
        
        Assert.assertNotNull(ce);
        
        CanjeEntity entity=em.find(CanjeEntity.class, ce.getId());
        
        Assert.assertEquals(newCanjeEntity.getId(), entity.getId());
    }
    
    @Test
    public void getCanjesTest() {
        List<CanjeEntity> list = cp.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CanjeEntity ent : list) {
            boolean found = false;
            for (CanjeEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
