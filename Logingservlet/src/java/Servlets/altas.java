/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.*;
import static java.lang.System.out;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

/**
 * @version 1.0 30/08/2017
 * @author Nevarezz Tovar Juan Carlos, Monroy Gonzalez Juan Ignacio
 */
@WebServlet(name = "altas", urlPatterns = {"/altas"})
public class altas extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario;
        String contra;
        usuario = request.getParameter("usuario");
        contra = request.getParameter("pass");

        Connection c;
        Statement sta;
        ResultSet r;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "n0m3l0");
            sta = c.createStatement();

            sta.executeUpdate("insert into Usuarios (usua,pass) values ('" + usuario + "','" + contra + "');");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<script> alert('Te has registrado exitosamente'); </script>");
            out.print("<script> window.location='index.html'; </script>");

        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException | SQLException e) {
           out.print("Lmao :'v");
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
