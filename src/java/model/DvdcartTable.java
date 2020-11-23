/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author GP63
 */
public class DvdcartTable {
    public static List<Dvdcart> findAllDvdcart(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShopPU");
        EntityManager em = emf.createEntityManager();
        List<Dvdcart> dvdList = null;
        try {
            dvdList = (List<Dvdcart>) em.createNamedQuery("Dvdcart.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return dvdList;
    }
    
    public static List<Dvdcart> findDvdcartByIdCatalog(Dvdcatalog id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShopPU");
        EntityManager em = emf.createEntityManager();
        List<Dvdcart> emp = null;
        try {
            Query query = em.createNamedQuery("Dvdcart.findByIdCatalog");
            query.setParameter("idCatalog", id);
            emp = (List<Dvdcart>) query.getResultList();
            if (emp.isEmpty()) {
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return emp;
    }
    
    public static int updateDvdCart(Dvdcart emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShopPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Dvdcart target = em.find(Dvdcart.class, emp.getId());
            if (target == null) {
                return 0;
            }
            target.setIdCatalog(emp.getIdCatalog());
            target.setQuantity(emp.getQuantity());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        }
        return 1;

    }
    public static int insertDvdcart(Dvdcart emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShopPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        }
        return 1;
    }
    
    public static int removeDvdcart(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShopPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Dvdcart target = em.find(Dvdcart.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        } finally {
            em.close();
            emf.close();
        }
        return 1;
    }
}
