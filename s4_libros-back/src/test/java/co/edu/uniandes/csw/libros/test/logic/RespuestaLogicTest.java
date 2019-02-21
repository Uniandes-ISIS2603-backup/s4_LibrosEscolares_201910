/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.test.logic;

import co.edu.uniandes.csw.libros.ejb.RespuestaLogic;
import co.edu.uniandes.csw.libros.entities.RespuestaEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.RespuestaPersistence;
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
 * @author diegogomez
 */
@RunWith(Arquillian.class)
public class RespuestaLogicTest {

    @Inject
    private RespuestaLogic logic;

    @PersistenceContext
    private EntityManager em;

    PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private UserTransaction utx;

    private List<RespuestaEntity> data = new ArrayList<RespuestaEntity>();

    @Deployment
    public static JavaArchive deployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RespuestaEntity.class.getPackage())
                .addPackage(RespuestaLogic.class.getPackage())
                .addPackage(RespuestaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");

    }

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
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
    }

    public void insertData() {
        for (int j = 0; j < 3; j++) {
            RespuestaEntity newEntity = factory.manufacturePojo(RespuestaEntity.class);
            em.persist(newEntity);
            data.add(newEntity);
        }
    }

    public void clearData() {
        em.createQuery("delete from RespuestaEntity").executeUpdate();
    }

    @Test
    public void createRespuestaTest() throws BusinessLogicException {
        RespuestaEntity newEntity = factory.manufacturePojo(RespuestaEntity.class);
        RespuestaEntity result = logic.crearRespuesta(newEntity);
        Assert.assertNotNull(result);
        RespuestaEntity entity = em.find(RespuestaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    @Test(expected = BusinessLogicException.class)
    public void createRespuestaConMismoIdTest() throws BusinessLogicException {

        PodamFactory factory = new PodamFactoryImpl();
        RespuestaEntity newEntity = factory.manufacturePojo(RespuestaEntity.class);
        newEntity.setId(data.get(0).getId());
        logic.crearRespuesta(newEntity);
        
    }
}
