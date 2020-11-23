<%-- 
    Document   : dvdcart
    Created on : Nov 23, 2020, 6:11:21 PM
    Author     : GP63
--%>

<%@page import="model.DvdcatalogTable"%>
<%@page import="model.Dvdcatalog"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.DvdcartTable"%>
<%@page import="java.util.List"%>
<%@page import="model.Dvdcart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <jsp:useBean id="dvd" class="model.Dvdcart" scope="request"/>
    <%
                       
            List<Dvdcart> dvdList = DvdcartTable.findAllDvdcart();
            Iterator<Dvdcart> itr = dvdList.iterator();
            
     %>
    
    <body>
        <center>
        <h1>Shopping Cart</h1>
        <table border="1">
          <tr>
            <th>Name</th>
            <th>Rate</th>
            <th>Year</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Add To Cart</th>
          </tr>
          
          <%
               while(itr.hasNext()) {
                   dvd = itr.next();
                   out.println("<tr>");
                   out.println("<td> "+ dvd.getIdCatalog().getName() + "</td>");
                   out.println("<td> "+ dvd.getIdCatalog().getRate() + "</td>");
                   out.println("<td> "+ dvd.getIdCatalog().getYears()+ "</td>");
                   out.println("<td> "+ dvd.getIdCatalog().getPrice()+ "</td>");
                   out.println("<td> "+ dvd.getQuantity()+ "</td>");
          %> <td> <a href="RemoveController?id=<%=dvd.getId()%>"><input type="submit" value="Remove" name="remove" /> </a> </td> <% 
                   out.println("<tr>");
               }
          %>
        </table>
        <br>
        <td>
        <a href="dvdcatalog.jsp"><input type="submit" value="Back To Catalog" name="back" /></a>
        <input onclick="window.location.href = '/DVDShop/CheckoutController'" type="button" value="Check Out" name="checkout" />
        <td/>
        </center>
          
    </body>
</html>
