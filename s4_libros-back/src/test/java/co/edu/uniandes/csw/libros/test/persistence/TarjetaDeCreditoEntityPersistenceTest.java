/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.test.persistence;

import co.edu.uniandes.csw.libros.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.libros.persistence.TarjetaDeCreditoPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Miguel Muñoz
 */
@RunWith(Arquillian.class)
public class TarjetaDeCreditoEntityPersistenceTest {
    @Inject
    private TarjetaDeCreditoPersistence ep;
    
    @PersistenceContext
    private EntityManager em;
     @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TarjetaDeCreditoEntity.class.getPackage())
                .addPackage(TarjetaDeCreditoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Test
    public void createTarjetaDeCreditoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaDeCreditoEntity tc = factory.manufacturePojo(TarjetaDeCreditoEntity.class);
        
        TarjetaDeCreditoEntity tarjeta = ep.create(tc);

        Assert.assertNotNull(tarjeta);

        TarjetaDeCreditoEntity entidad = em.find(TarjetaDeCreditoEntity.class, tarjeta.getId());
        Assert.assertEquals(tc.getNumero(), entidad.getNumero());
    }
    
    
}
