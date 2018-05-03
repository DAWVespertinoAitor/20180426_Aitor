/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Ave;
import es.albarregas.connections.ConnectionMySQL;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author aitor
 */
@WebServlet(name = "Conclusion", urlPatterns = {"/Conclusion"})
public class Conclusion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "";
        String eleccion = request.getParameter("enviar");
        
        List<Ave> listaAves = new ArrayList();
        if (eleccion != null) {
            switch (eleccion) {
                case "Insertar":
                    try {
                        Ave ave = new Ave();
                        BeanUtils.populate(ave, request.getParameterMap());
                        Statement sentencia = (Statement) ConnectionMySQL.getConnectionMySQL().createStatement();
                        request.setAttribute("aveIntro", ave);
                        sentencia.execute("INSERT INTO aves (anilla, especie, lugar, fecha) VALUES('" + ave.getAnilla() + "','" + ave.getEspecie() + "','" + ave.getLugar() + "','" + ave.getFecha() + "');");

                    } catch (SQLException ex) {
                        ex.getStackTrace();
                    } catch (IllegalAccessException ex) {
                        ex.getStackTrace();
                    } catch (InvocationTargetException ex) {
                        ex.getStackTrace();
                    }
                    url = "JSP/create/finCreate.jsp";

                    break;
                case "read":
                    url = "JSP/read/read.jsp";
                    break;
                case "Actualizar":
                    try {
                        Ave ave = new Ave();
                        BeanUtils.populate(ave, request.getParameterMap());
                        Statement sentencia = (Statement) ConnectionMySQL.getConnectionMySQL().createStatement();
                        request.setAttribute("aveActu", ave);
                        sentencia.execute("UPDATE aves SET especie = '"+ave.getEspecie()+"', lugar = '"+ave.getLugar()+"', fecha = '"+ave.getFecha()+"' WHERE anilla = '"+ave.getAnilla()+"';");
                    } catch (SQLException ex) {
                        ex.getStackTrace();
                    } catch (IllegalAccessException ex) {
                        ex.getStackTrace();
                    } catch (InvocationTargetException ex) {
                        ex.getStackTrace();
                    }
                    url = "JSP/update/finUpdate.jsp";
                    break;
                case "Eliminar":
                    try {

                        String[] anilla = request.getParameterValues("anilla");
                        Statement sentencia = (Statement) ConnectionMySQL.getConnectionMySQL().createStatement();
                        ResultSet resultado;
                        for (int i = 0; i < anilla.length; i++) {
                            sentencia.execute("DELETE FROM aves WHERE anilla = " + anilla[i]);
                        }
                    } catch (SQLException ex) {
                        ex.getStackTrace();
                    }
                    url = "JSP/delete/finDelete.jsp";
                    break;
            }
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
