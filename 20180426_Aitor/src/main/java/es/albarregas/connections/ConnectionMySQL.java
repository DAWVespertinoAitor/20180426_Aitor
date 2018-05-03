/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.connections;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author aitor
 */
public class ConnectionMySQL {

    public static Connection conexion = null;

    public static Connection getConnectionMySQL() {
        if (conexion == null) {
            Context contextoInicial;
            try {
                contextoInicial = new InitialContext();
                DataSource datasource = (DataSource) contextoInicial.lookup("java:comp/env/jdbc/pruebasjava");
                conexion = (Connection) datasource.getConnection();
            } catch (NamingException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conexion;
    }
}
