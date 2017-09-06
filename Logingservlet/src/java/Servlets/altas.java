/*
    AUTOR: Monroy Gonzalez Juan Ignacio / J. Carlos Nevarez Tovar 5IM6
    VERSIÓN: 1.0 
    DESCRIPCIÓN: Clase de java que hace una alta a la base datos
    COMPILACIÓN: Se compila en tiempo de ejecución. 
    EJECUCIÓN: Ejecutando la pagina con GlashFish server y subiendo una base de datos MYSQL.
 */
package Servlets;

//LIBRERIAS
import java.io.*;
import static java.lang.System.out;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

/**
 * <h3>Clase altas</h3>
 * Recibe el request de altas.html y sube datos a una Base de Datos
 * @author Monroy Gonzalez Juan Ignacio
 * @version v1.0.1
 * @since 30/08/2017
 */
@WebServlet(name = "altas", urlPatterns = {"/altas"})
public class altas extends HttpServlet {

    /**
    * <h3>Método doPost</h3>
    * Recibe los parametros de altas.html y sube datos a una Base de Datos
    * @author Nevarez Tovar Juan Carlos, Monroy Gonzalez Juan Ignacio
    * @version v1.0.1
    * @since 30/08/2017
    * 
    * @param request peticion del servlet
    * @param response repuesta del servlet 
    * @throws ServletException si ocurre un servlet-specific error
    * @throws IOException si ocurre un I/O error
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Parametros de datos
        String usuario;
        String contra;
        usuario = request.getParameter("usuario");
        contra = request.getParameter("pass");
        
        //Instancias de conexion
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
     * Regrera una pequeña descripción del servlet
     *
     * @return un String que contiene una descripción del servlet
     */
    @Override
    public String getServletInfo() {
        return "Corta descripcion";
    }// </editor-fold>

}//Cierre de clase
