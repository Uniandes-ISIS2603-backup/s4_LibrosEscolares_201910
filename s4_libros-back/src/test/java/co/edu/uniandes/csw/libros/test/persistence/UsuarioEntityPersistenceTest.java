/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.test.persistence;

import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import co.edu.uniandes.csw.libros.persistence.UsuarioPersistence;
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
 * @author nf.jaramillo
 */

@RunWith(Arquillian.class)
public class UsuarioEntityPersistenceTest {
    @Inject
    private UsuarioPersistence ep;
    
    @PersistenceContext
    private EntityManager em;
    
    @Deployment
    public static JavaArchive deployment()
            
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
        
    }
    @Test
    public void createUsuarioTest()
    {
        PodamFactory factory = new PodamFactoryImpl();
        UsuarioEntity newue = factory.manufacturePojo(UsuarioEntity.class);
        UsuarioEntity ue = ep.create(newue);
        
        Assert.assertNotNull(ue);
        
        UsuarioEntity entoty = em.find(UsuarioEntity.class,ue.getId());
        Assert.assertEquals(newue.getNombreUsuario(),ue.getNombreUsuario());
    }
}
