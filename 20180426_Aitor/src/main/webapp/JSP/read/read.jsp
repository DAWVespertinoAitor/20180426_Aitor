<%-- 
    Document   : read
    Created on : 29-abr-2018, 13:59:23
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar Aves</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen" />
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Avistamientos </h1>
            <table style="margin: 0 auto;">
                <tr>
                    <th>Anilla</th>
                    <th>Especie</th>
                    <th>Lugar</th>
                    <th>Fecha</th>
                </tr>
                    <c:forEach var="aves" items="${listaAves}">
                    <tr>
                        <td><c:out value="${aves.anilla}"/></td>
                        <td><c:out value="${aves.especie}"/></td>
                        <td><c:out value="${aves.lugar}"/></td>
                        <td><c:out value="${aves.fecha}"/></td>
                    </tr>
                </c:forEach>
            </table><br>
            <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menu" value="Menu Principal"/></a><br><br>
        </div>
    </body>
</html>
