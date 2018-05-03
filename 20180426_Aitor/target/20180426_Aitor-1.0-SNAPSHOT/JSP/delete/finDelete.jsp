<%-- 
    Document   : finDelete
    Created on : 29-abr-2018, 13:59:08
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminación finalizada</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen" />
    </head>
    <body>
        <div class="columnasCentradas">
            <h1 style="color: green">Datos eliminados correctamente</h1>
            <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menu" value="Menu Principal"/></a><br><br>
        </div>
    </body>
</html>
