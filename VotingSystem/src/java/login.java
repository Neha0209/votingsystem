/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Neha Sharma
 */
public class login extends HttpServlet {

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
        String a=request.getParameter("adhar");
        String v=request.getParameter("voter");
         boolean flag=false;
        long ad=0,vt=0;
        
         try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/votesystem?useSSL=false","root","nehasharma1481");
           Statement stmt=conn.createStatement();
           PreparedStatement ps = conn.prepareStatement("select * from signup where adhar=? and voter=?");
           ps.setString(1,a);
           ps.setString(2, v);
           ResultSet rs=ps.executeQuery();
          
          
           
                   if(rs.next())
                   {
//                       yahan par har row par getInt and getString se columns ki value utha lo
//                               like
                                   //First column k liye
                       flag=true;
                                    
                  // ab is loop m har row p columns se value nikaalti jaao aur jo krna hai wo karlo saath
                         //  Smjhi?
                
                   }
         //response.sendRedirect("abc.html");
                                     
        }
                                       
                   
        
                  // ab is loop m har row p columns se value nikaalti jaao aur jo krna hai wo karlo saath
                         //  Smjhi?
                
         
        
        catch(Exception e)
        {
                 System.out.println(e);   
        }
       
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            if(flag==true)
            {
                out.println("<p>you are loged in </p>");
            }
            else
            {
                out.println("<p>you are not loged in<br> please enter correct password </p>");
            }
            out.println("<h1>hi</h1>");
            response.sendRedirect("1.html");
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
