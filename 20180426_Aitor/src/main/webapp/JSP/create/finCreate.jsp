<%-- 
    Document   : finCreate
    Created on : 29-abr-2018, 13:58:40
    Author     : aitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finalizado</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen" />
    </head>
    <body>
        <div class="columnasCentradas">
            <h1 style="color: green">¡Datos introducidos con exito!</h1>
            <table style="margin: 0 auto;">
                <tr>
                    <td><label for="anilla">Anilla: </label></td>
                    <td><input type="text" style="border: 1px solid white;" id="anilla" name="anilla" value="${requestScope.aveIntro.anilla}" readonly></td>
                </tr>
                <tr>
                    <td><label for="especie">Especie: </label></td>
                    <td><input type="text" style="border: 1px solid white;" id="especie" name="especie" value="${requestScope.aveIntro.especie}"></td>
                </tr>
                <tr>
                    <td><label for="lugar">Lugar: </label></td>
                    <td><input type="text" style="border: 1px solid white;" id="lugar" name="lugar" value="${requestScope.aveIntro.lugar}"></td>
                </tr>
                <tr>
                    <td><label for="fecha">Fecha: </label></td>
                    <td><input type="text" style="border: 1px solid white;" id="fecha" name="fecha" value="${requestScope.aveIntro.fecha}"></td>
                </tr>
                <td>
                    <br>
                </td>
            </table>
            <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menu" value="MenuPrincipal"/></a><br><br>  
        </div>
    </body>
</html>
