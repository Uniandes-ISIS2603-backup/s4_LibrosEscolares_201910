/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.test.persistence;

import co.edu.uniandes.csw.libros.entities.PedidoEntity;
import co.edu.uniandes.csw.libros.persistence.PedidoPersistence;
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
 * @author diegogomez
 */
@RunWith(Arquillian.class)
public class PedidoEntityPersistence {

    @Inject
    private PedidoPersistence pedidoPersistence;

    @PersistenceContext
    private EntityManager em;

    @Deployment
    public static JavaArchive deployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PedidoEntity.class.getPackage())
                .addPackage(PedidoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");

    }

    @Test
    public void createPedidoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        PedidoEntity pedidoEntity = factory.manufacturePojo(PedidoEntity.class);

        PedidoEntity pedidoNew = pedidoPersistence.create(pedidoEntity);
        Assert.assertNotNull(pedidoNew);
        
        PedidoEntity pedido = em.find(PedidoEntity.class, pedidoEntity.getId());
        Assert.assertEquals(pedidoEntity.getId(), pedido.getId()); 
    }

}
