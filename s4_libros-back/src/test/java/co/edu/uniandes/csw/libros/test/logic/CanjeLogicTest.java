/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.test.logic;

import co.edu.uniandes.csw.libros.ejb.CanjeLogic;
import co.edu.uniandes.csw.libros.ejb.LibroLogic;
import co.edu.uniandes.csw.libros.entities.CanjeEntity;
import co.edu.uniandes.csw.libros.entities.LibroEntity;
import co.edu.uniandes.csw.libros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.libros.persistence.CanjePersistence;
import co.edu.uniandes.csw.libros.persistence.LibroPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import static org.glassfish.pfl.basic.tools.argparser.ElementParser.factory;
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
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class CanjeLogicTest {
    
    @Inject
    private CanjeLogic canjeLogic;
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;
    
    private List<CanjeEntity> data = new ArrayList<CanjeEntity>();
    
    @Before
    public void configTest(){
        try{
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        }
        catch(Exception e){
            e.printStackTrace();
            try{
                utx.rollback();
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
    
    private void clearData(){
        em.createQuery("delete from CanjeEntity").executeUpdate();
    }
    
    private void insertData(){
        for(int i=0;i<3;i++){
            CanjeEntity entity=factory.manufacturePojo(CanjeEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Deployment
    public static JavaArchive createDeployment()       
    {
        return ShrinkWrap.create(JavaArchive.class)
            .addPackage(CanjeEntity.class.getPackage())
            .addPackage(CanjeLogic.class.getPackage())
            .addPackage(CanjePersistence.class.getPackage())
            .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
            .addAsManifestResource("META-INF/beans.xml","beans.xml");

    }
    
    @Test
    public void createCanjeTest() throws BusinessLogicException {
        CanjeEntity newEntity = factory.manufacturePojo(CanjeEntity.class);
        CanjeEntity result = canjeLogic.createCanje(newEntity);
        Assert.assertNotNull(result);
        CanjeEntity entity = em.find(CanjeEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    
//    @Test(expected = BusinessLogicException.class)
//    public void createCanjeConMismosUsuariosTest() throws BusinessLogicException {
//       CanjeEntity newEntity = factory.manufacturePojo(CanjeEntity.class);
//        newEntity.setUsuarioQueOfrece(newEntity.getUsuarioQueRecibe());
//        canjeLogic.createCanje(newEntity);
//    }
//    
//    @Test(expected = BusinessLogicException.class)
//    public void createCanjeConMismosLibrosTest() throws BusinessLogicException {
//       CanjeEntity newEntity = factory.manufacturePojo(CanjeEntity.class);
//        newEntity.setLibroOfrecido(newEntity.getLibroPedido());
//        canjeLogic.createCanje(newEntity);
//    }
    

}
