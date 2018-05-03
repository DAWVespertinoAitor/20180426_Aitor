/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;


import es.albarregas.beans.Ave;
import es.albarregas.connections.ConnectionMySQL;
import java.io.IOException;
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

/**
 *
 * @author aitor
 */
@WebServlet(name = "Eleccion", urlPatterns = {"/Eleccion"})
public class Eleccion extends HttpServlet {

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

        String url = "";
        String eleccion = request.getParameter("el");
        
        List<Ave> listaAves = new ArrayList();
        if (eleccion != null) {
            switch (eleccion) {
                case "create":
                    url = "JSP/create/create.jsp";
                    break;
                case "read":
                    
                    try {
                        Statement sentencia = (Statement) ConnectionMySQL.getConnectionMySQL().createStatement();
                        ResultSet resultado = sentencia.executeQuery("SELECT * FROM aves");
                        
                        while(resultado.next()){
                            Ave ave = new Ave();
                            ave.setAnilla(resultado.getString("anilla"));
                            ave.setEspecie(resultado.getString("especie"));
                            ave.setLugar(resultado.getString("lugar"));
                            ave.setFecha(resultado.getString("fecha"));
                            listaAves.add(ave);
                        }
                        resultado.close();
                    } catch (SQLException ex) {
                        ex.getStackTrace();
                    }
                    request.setAttribute("listaAves", listaAves);
                    url = "JSP/read/read.jsp";
                    break;
                case "update":
                    try {
                        Statement sentencia = (Statement) ConnectionMySQL.getConnectionMySQL().createStatement();
                        ResultSet resultado = sentencia.executeQuery("SELECT * FROM aves");
                        
                        while(resultado.next()){
                            Ave ave = new Ave();
                            ave.setAnilla(resultado.getString("anilla"));
                            ave.setEspecie(resultado.getString("especie"));
                            ave.setLugar(resultado.getString("lugar"));
                            ave.setFecha(resultado.getString("fecha"));
                            listaAves.add(ave);
                        }
                        resultado.close();
                    } catch (SQLException ex) {
                        ex.getStackTrace();
                    }
                    request.setAttribute("listaAves", listaAves);
                    url = "JSP/update/update.jsp";
                    break;
                case "delete":
                    try {
                        Statement sentencia = (Statement) ConnectionMySQL.getConnectionMySQL().createStatement();
                        ResultSet resultado = sentencia.executeQuery("SELECT * FROM aves");
                        
                        while(resultado.next()){
                            Ave ave = new Ave();
                            ave.setAnilla(resultado.getString("anilla"));
                            ave.setEspecie(resultado.getString("especie"));
                            ave.setLugar(resultado.getString("lugar"));
                            ave.setFecha(resultado.getString("fecha"));
                            listaAves.add(ave);
                        }
                        resultado.close();
                    } catch (SQLException ex) {
                        ex.getStackTrace();
                    }
                    request.setAttribute("listaAves", listaAves);
                    url = "JSP/delete/delete.jsp";
                    break;
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
