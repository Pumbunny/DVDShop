/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author GP63
 */
public class DvdcatalogTable {
    
    public static List<Dvdcatalog> findAllDvdcatalog(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShopPU");
        EntityManager em = emf.createEntityManager();
        List<Dvdcatalog> dvdList = null;
        try {
            dvdList = (List<Dvdcatalog>) em.createNamedQuery("Dvdcatalog.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return dvdList;
    }
    public static Dvdcatalog findDvdcatalogById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShopPU");
        EntityManager em = emf.createEntityManager();
        Dvdcatalog emp = null;
        try {
            emp = em.find(Dvdcatalog.class, id);
            //em.close();

        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return emp;
    }
    
}
