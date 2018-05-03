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
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
                        boolean seRepite = false;
                        Ave ave = new Ave();
                        Statement sentencia = (Statement) ConnectionMySQL.getConnectionMySQL().createStatement();
                        ResultSet resultado = sentencia.executeQuery("SELECT * FROM aves WHERE anilla = " + request.getParameter("anilla"));
                        BeanUtils.populate(ave, request.getParameterMap());

                        if (resultado.next()) {
                            seRepite = true;
                            url = "JSP/create/create.jsp";
                            request.setAttribute("seRepite", seRepite);
                            request.setAttribute("ave", ave);
                            request.getRequestDispatcher(url).forward(request, response);
                        }

                        if (seRepite == false) {
                            url = "JSP/create/seguroCreate.jsp";
                            System.out.println("He entrado y tengo esta url" + url);
                            request.setAttribute("ave", ave);
                        }

                        resultado.close();
                    } catch (SQLException ex) {
                        ex.getStackTrace();
                    } catch (IllegalAccessException ex) {
                        ex.getStackTrace();
                    } catch (InvocationTargetException ex) {
                        ex.getStackTrace();
                    }
                    break;
                case "read":

                    url = "JSP/read/read.jsp";
                    break;
                case "Actualizar":
                    try {

                        String anilla = request.getParameter("anilla");
                        Statement sentencia = (Statement) ConnectionMySQL.getConnectionMySQL().createStatement();
                        ResultSet resultado = sentencia.executeQuery("SELECT * FROM aves WHERE anilla = " + anilla);

                        Ave ave = new Ave();
                        if (resultado.next()) {
                            ave.setAnilla(resultado.getString("anilla"));
                            ave.setEspecie(resultado.getString("especie"));
                            ave.setLugar(resultado.getString("lugar"));
                            ave.setFecha(resultado.getString("fecha"));
                        }
                        request.setAttribute("aveEscogida", ave);
                        resultado.close();
                    } catch (SQLException ex) {
                        ex.getStackTrace();
                    }
                    url = "JSP/update/datosUpdate.jsp";
                    break;
                case "Eliminar":
                    try {

                        String[] anilla = request.getParameterValues("anilla");
                        Statement sentencia = (Statement) ConnectionMySQL.getConnectionMySQL().createStatement();
                        ResultSet resultado;
                        for (int i = 0; i < anilla.length; i++) {
                            resultado = sentencia.executeQuery("SELECT * FROM aves WHERE anilla = " + anilla[i]);
                            Ave ave = new Ave();
                            if (resultado.next()) {
                                ave.setAnilla(resultado.getString("anilla"));
                                ave.setEspecie(resultado.getString("especie"));
                                ave.setLugar(resultado.getString("lugar"));
                                ave.setFecha(resultado.getString("fecha"));
                                listaAves.add(ave);
                            }
                        }
                        request.setAttribute("avesEscogidas", listaAves);
                    } catch (SQLException ex) {
                        ex.getStackTrace();
                    }
                    url = "JSP/delete/seguroDelete.jsp";
                    break;
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
