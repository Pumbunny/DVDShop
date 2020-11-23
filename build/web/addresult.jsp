<%-- 
    Document   : addresult
    Created on : Nov 23, 2020, 5:38:06 PM
    Author     : GP63
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Catalog</title>
    </head>
    <body>
        <h1><%=request.getAttribute("rowInserted") + " movie is added to cart"%> </h1>
        </br>
        <jsp:include page="dvdcatalog.jsp" flush="true" />
    </body>
</html>
