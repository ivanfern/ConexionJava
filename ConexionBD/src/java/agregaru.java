/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.swing.plaf.OptionPaneUI;
/**
 *
 * @author ivanfern
 */
public class agregaru extends HttpServlet {


    private Connection con;
    private Statement set;
    private ResultSet rs;
    @Override
     public void init(ServletConfig cfg) throws ServletException{
      
      String URL = "jdbc:mysql:3306//localhost/saeo";
      //usuario de la db
      String userName = "root";
      //password
      String password = "n0m310";
      try{
          //colocar el driver de la conexion mysql, sql,firebase, con el manejador
          Class.forName("com.mysql.jdbc.Driver");
          
          //a veces por la version del manejador de mysql
          //URL ="jdbc://localhost/saeo";
          
          //Hacemos uso de los objetos de con y set
          con = DriverManager.getConnection(URL, userName, password);
          //con set prepararamos la sentencia
          set = con.createStatement();
          
          System.out.println("conecto con la DB");
      }catch(Exception e){
          System.out.println("No conecto con la DB");
          //donde fue el error
          System.out.println(e.getMessage());
          System.out.println(e.getStackTrace());
      }
    }
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet agregaru</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet agregaru at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    /*Encapsulamiento de Coneccion*/
    static Connection Conexion;
    public static Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = (Connection)DriverManager.getConnection("");
            
        }catch(Exception e){
            System.out.println("No conecto con la DB");
          //donde fue el error
          System.out.println(e.getMessage());
          System.out.println(e.getStackTrace());
        }
        return Conexion;
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
