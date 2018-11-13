/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Neha Sharma
 */
public class signup extends HttpServlet {

    //private String age;

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
        String n=request.getParameter("name");
        //Let me show you the other way
       // int ag=Integer.parseInt(request.getParameter("age"));
        String a=request.getParameter("age");
        String d=request.getParameter("DOB");
        
        String g = request.getParameter("gender");
        String add=request.getParameter("address");
        String state=request.getParameter("state");
        String adhar=request.getParameter("adhar");
        String voter=request.getParameter("voter");
        String gen;
    if ("female".equals(g)) 
    {
       gen=g;
    }
    else if("male".equals(g))
    {
         gen=g;
    }
    else
         gen=g;
        
                                
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/votesystem?useSSL=false","root","nehasharma1481");
           Statement stmt=conn.createStatement();
            PreparedStatement pstmt=conn.prepareStatement("INSERT INTO signup VALUES(?,?,?,?,?,?,?,?)");
            pstmt.setString(1,n);
            //pstmt.setInt(3,ag);
            //Smjhi?
         
            pstmt.setInt(2, Integer.parseInt(a));
            pstmt.setString(3, gen);
            pstmt.setString(4, d);
              pstmt.setString(5, add);
                pstmt.setString(6, state);
                  pstmt.setString(7, adhar);
                    pstmt.setString(8, voter);
            pstmt.executeUpdate();
            
        }
        catch(Exception e)
        {
                 System.out.println(e);   
        }
       
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>"); 
            out.println("<head>");
            out.println("<title>Servlet signup</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>you are registered</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
