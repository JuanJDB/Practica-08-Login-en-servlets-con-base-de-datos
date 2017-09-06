/*
    AUTOR: Juan Ignacio Monroy Gonzalez 5IM6
    VERSIÓN: 1.0 
    DESCRIPCIÓN: Clase de java que hace una consulta a la base datos
    OBSERVACIONES: Completar consulta
    COMPILACIÓN: Se compila en tiempo de ejecución. 
    EJECUCIÓN: Ejecutando la pagina con GlashFish server y subiendo una base de datos MYSQL.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * @version v1.0.1
 * @author Monroy Gonzalez Juan Ignacio
 * @since 30/08/2017
 */
@WebServlet(name = "consu", urlPatterns = {"/consu"})
public class consu extends HttpServlet {

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
        String usuario = request.getParameter("usuario");
        String contra = request.getParameter("contra");
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loging", "root", "n0m3l0");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from usu where usuario ='" + usuario + "'");
            if (rs.next()) {
                String aux = rs.getString("cont");
                if (contra.equals(aux)) {
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("Usuario y contraseña correcta");
                } else {
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("contraseña o usuario incorrectos");
                }

            }
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

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
