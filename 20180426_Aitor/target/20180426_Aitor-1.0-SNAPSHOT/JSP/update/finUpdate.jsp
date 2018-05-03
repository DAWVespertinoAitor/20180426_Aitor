<%-- 
    Document   : finUpdate
    Created on : 29-abr-2018, 13:59:39
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos actualizados</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen" />
    </head>
    <body>
         <div class="columnasCentradas">
            <h1 style="color: green">¡Datos actualizados con exito!</h1>
            <table style="margin: 0 auto;">
                <tr>
                    <td>Anilla:</td>
                    <td><c:out value="${requestScope.aveActu.anilla}"/></td>
                </tr>
                <tr>
                    <td>Especie:</td>
                    <td><c:out value="${requestScope.aveActu.especie}"/></td>
                </tr>
                <tr>
                    <td>Lugar:</td>
                    <td><c:out value="${requestScope.aveActu.lugar}"/></td>
                </tr>
                <tr>
                    <td>Fecha:</td>
                    <td><c:out value="${requestScope.aveActu.fecha}"/></td>
                </tr>
                <td>
                    <br>
                </td>
            </table>
            <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menu" value="MenuPrincipal"/></a><br><br>  
        </div>
    </body>
</html>
