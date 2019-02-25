/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.test.persistence;

import co.edu.uniandes.csw.libros.entities.RespuestaEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.RespuestaPersistence;
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
public class RespuestaEntityPersistence {
    
    @Inject
    private RespuestaPersistence ep;

    @PersistenceContext
    private EntityManager em;

    @Deployment
    public static JavaArchive deployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RespuestaEntity.class.getPackage())
                .addPackage(RespuestaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");

    }
    
    @Test
    public void createRespuestaTest() throws BusinessLogicException{
        PodamFactory factory = new PodamFactoryImpl();
        RespuestaEntity re = factory.manufacturePojo(RespuestaEntity.class);
        RespuestaEntity respuesta = ep.create(re);

        Assert.assertNotNull(respuesta);

        RespuestaEntity rree = em.find(RespuestaEntity.class, respuesta.getId());
        Assert.assertEquals(re.getRazon(), rree.getRazon());
    }
}
