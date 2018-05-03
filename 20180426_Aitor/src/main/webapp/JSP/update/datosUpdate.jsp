<%-- 
    Document   : seguroUpdate
    Created on : 29-abr-2018, 13:59:47
    Author     : aitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar datos</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen" />
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Actualizar los datos</h1>
            <form action="<%=request.getContextPath()%>/Conclusion" method="POST">
                <table style="margin: 0 auto;">

                    <tr>
                        <td><label for="anilla">Anilla: </label></td>
                        <td><input type="text" style="border: 1px solid white;" id="anilla" name="anilla" value="${requestScope.aveEscogida.anilla}" readonly></td>
                    </tr>
                    <tr>
                        <td><label for="especie">Especie: </label></td>
                        <td><input type="text" id="especie" name="especie" value="${requestScope.aveEscogida.especie}"></td>
                    </tr>
                    <tr>
                        <td><label for="lugar">Lugar: </label></td>
                        <td><input type="text" id="lugar" name="lugar" value="${requestScope.aveEscogida.lugar}"></td>
                    </tr>
                    <tr>
                        <td><label for="fecha">Fecha: </label></td>
                        <td><input type="text" id="fecha" name="fecha" value="${requestScope.aveEscogida.fecha}"></td>
                    </tr>
                    <td>
                        <br>
                    </td>
                </table>
                <input type="submit" name="enviar" value="Actualizar"/>
                <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menu" value="Menu Principal"/></a><br><br>
            </form>    
        </div>
    </body>
</html>
