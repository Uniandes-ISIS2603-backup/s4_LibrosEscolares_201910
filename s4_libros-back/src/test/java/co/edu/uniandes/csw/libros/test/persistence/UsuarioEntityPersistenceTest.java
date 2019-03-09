/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.test.persistence;

import co.edu.uniandes.csw.libros.entities.UsuarioEntity;
import co.edu.uniandes.csw.libros.persistence.UsuarioPersistence;
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
 * @author nf.jaramillo
 */

@RunWith(Arquillian.class)
public class UsuarioEntityPersistenceTest {
    @Inject
    private UsuarioPersistence ep;
    
    @PersistenceContext
    private EntityManager em;
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    /**
     * Lista que tiene los datos de prueba.
     */
    private List<UsuarioEntity> data = new ArrayList<UsuarioEntity>();
    
     /** Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    private UserTransaction utx;
    
    @Deployment
    public static JavaArchive deployment()
            
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioPersistence.class.getPackage())
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
        em.createQuery("delete from UsuarioEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            UsuarioEntity entity = factory.manufacturePojo(UsuarioEntity.class);

            em.persist(entity);
            data.add(entity);

        }
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
    
    /**
     * Prueba para consultar un Usuario.
     */
    @Test
    public void getUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        UsuarioEntity newEntity = ep.find(entity.getId());
        org.junit.Assert.assertNotNull(newEntity);
        org.junit.Assert.assertEquals(entity.getNombreUsuario(), newEntity.getNombreUsuario());
    }
    
    /**
     * Prueba para consultar la lista de usuarios.
     */
    @Test
    public void getEditorialsTest() {
        List<UsuarioEntity> list = ep.findAll();
        org.junit.Assert.assertEquals(data.size(), list.size());
        for (UsuarioEntity ent : list) {
            boolean found = false;
            for (UsuarioEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            org.junit.Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para eliminar un usuario.
     */
    @Test
    public void deleteUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        ep.delete(entity.getId());
        UsuarioEntity deleted = em.find(UsuarioEntity.class, entity.getId());
        org.junit.Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un usuario.
     */
    @Test
    public void updateUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        UsuarioEntity newEntity = factory.manufacturePojo(UsuarioEntity.class);

        newEntity.setId(entity.getId());

        ep.update(newEntity);

        UsuarioEntity resp = em.find(UsuarioEntity.class, entity.getId());

        org.junit.Assert.assertEquals(newEntity.getNombreUsuario(), resp.getNombreUsuario());
    }
    
    /**
     * Prueba para consultar un Usuario por correo.
     */
    @Test
    public void findUsuarioByMailTest() {
        UsuarioEntity entity = data.get(0);
        UsuarioEntity newEntity = ep.findByMail(entity.getCorreo());
        org.junit.Assert.assertNotNull(newEntity);
        org.junit.Assert.assertEquals(entity.getNombreUsuario(), newEntity.getNombreUsuario());

        newEntity = ep.findByMail(null);
        org.junit.Assert.assertNull(newEntity);
    }
}
