<%-- 
    Document   : removedvd
    Created on : Nov 23, 2020, 11:15:57 PM
    Author     : GP63
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
       <h1><%=request.getAttribute("rowDeleted") + " movie is remove from cart"%> </h1>
        </br>
        <jsp:include page="dvdcart.jsp" flush="true" />
    </body>
</html>
