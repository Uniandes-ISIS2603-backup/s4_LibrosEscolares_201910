/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.libros.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Miguel Muñoz
 */
@Stateless
public class LibroPersistence {
    @PersistenceContext(unitName="librosPU")
    protected EntityManager em;
    
}
