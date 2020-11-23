<%-- 
    Document   : dvdcatalog
    Created on : Nov 23, 2020, 3:09:15 PM
    Author     : GP63
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.DvdcatalogTable"%>
<%@page import="model.Dvdcatalog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Catalog</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <jsp:useBean id="dvd" class="model.Dvdcatalog" scope="request"/>
    <%
                       
            List<Dvdcatalog> dvdList = DvdcatalogTable.findAllDvdcatalog();
            Iterator<Dvdcatalog> itr = dvdList.iterator();
            
     %>
    <body>
        <center>
        <h1>DVD Catalog</h1>
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
              while (itr.hasNext()) {
                   out.println("<form name=\"AddToCart\" method=\"post\" action=\"AddToCartController\">");
                   dvd = itr.next();
                   out.println("<tr>");
                   out.println("<td hidden><input type=\"number\" name=\"idCatalog\" value=" + dvd.getId() + "></input></td>");
                   out.println("<td> " + dvd.getName() + "</td>");
                   out.println("<td> " + dvd.getRate() + "</td>");
                   out.println("<td> " + dvd.getYears() + "</td>");
                   out.println("<td> " + dvd.getPrice() + "</td>");
                   out.println("<td><input type=\"number\" name=\"quantity\" placeholder=\"Enter Quantity\" id=\"textsend\" onkeyup=\"success()\"></input></td>");
                   out.println("<td><button type=\"submit\" name=\"addtocart\" id=\"button\">AddToCart</button></td>");
                   out.println("</tr>");
                   out.println("</form>");
                }
            %>
        </table>
        <br>
        <a href="dvdcart.jsp"><input type="submit" value="Shopping Cart" name="cart" /></a>
        </center>
          
    </body>
    <script type="text/javascript">
        function success() {
            if (document.getElementById("textsend").value === "") {
                document.getElementById('button').disabled = true;
            } else {
                document.getElementById('button').disabled = false;
            }
        }
    </script>
</html>
