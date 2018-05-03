<%-- 
    Document   : seguroCreate
    Created on : 29-abr-2018, 13:58:32
    Author     : aitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmacion</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen" />
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Confirmar datos</h1>
            <form action="<%=request.getContextPath()%>/Conclusion" method="POST">
                <table style="margin: 0 auto;">

                    <tr>
                        <td><label for="anilla">Anilla: </label></td>
                        <td><input type="text" style="border: 1px solid white;" id="anilla" name="anilla" value="${requestScope.ave.anilla}" readonly></td>
                    </tr>
                    <tr>
                        <td><label for="especie">Especie: </label></td>
                        <td><input type="text" id="especie" name="especie" value="${requestScope.ave.especie}"></td>
                    </tr>
                    <tr>
                        <td><label for="lugar">Lugar: </label></td>
                        <td><input type="text" id="lugar" name="lugar" value="${requestScope.ave.lugar}"></td>
                    </tr>
                    <tr>
                        <td><label for="fecha">Fecha: </label></td>
                        <td><input type="text" id="fecha" name="fecha" value="${requestScope.ave.fecha}"></td>
                    </tr>
                    <td>
                        <br>
                    </td>
                </table>
                <input type="submit" name="enviar" value="Insertar"/>
                <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menu" value="Menu Principal"/></a><br><br>
            </form>    
        </div>
    </body>
</html>
