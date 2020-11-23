/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Dvdcart;
import model.DvdcartTable;
import model.Dvdcatalog;
import model.DvdcatalogTable;

/**
 *
 * @author GP63
 */
public class AddToCartController extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DVDShopPU");

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        EntityManager em = emf.createEntityManager(); //สร้าง object ของ EntityManager
//        HttpSession session = request.getSession(); //สร้าง session
//        session.setAttribute("entitymanager",em);  //set Attribute ระดับ session เพื่อให้ component ทุกตัวเข้าถึง session นี้
        
        int id = Integer.parseInt(request.getParameter("idCatalog"));
        Dvdcatalog dvdcat = DvdcatalogTable.findDvdcatalogById(id);
        Dvdcart dvdC = new Dvdcart();
        List<Dvdcart> oldDvdC = DvdcartTable.findDvdcartByIdCatalog(dvdcat);
        int rowInserted;
        if(oldDvdC == null){
            dvdC.setIdCatalog(dvdcat);
            dvdC.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            rowInserted = DvdcartTable.insertDvdcart(dvdC);
        }
        else {
            dvdC.setId(oldDvdC.get(0).getId());
            dvdC.setIdCatalog(dvdcat);
            dvdC.setQuantity(oldDvdC.get(0).getQuantity()+ Integer.parseInt(request.getParameter("quantity")));
            rowInserted = DvdcartTable.updateDvdCart(dvdC);
        }
        request.setAttribute("rowInserted", rowInserted);
        request.getRequestDispatcher("addresult.jsp").forward(request, response);
        
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
