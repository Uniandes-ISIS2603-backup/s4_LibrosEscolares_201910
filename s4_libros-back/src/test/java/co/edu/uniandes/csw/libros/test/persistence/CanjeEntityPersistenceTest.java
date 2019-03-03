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
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
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
}
