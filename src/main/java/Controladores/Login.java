/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Conexion;
import Modelo.Usuario;
import helper.AppHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alann
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

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
            throws ServletException, IOException { }
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            // datos duros
//            String usuarioOK = "usuario@uteq.com";
//            String passwordOK = "qwerty";
//            // obtener valores de los parámetros
//            String usuario = request.getParameter("exampleInputEmail");
//            String password = request.getParameter("exampleInputPassword");
//            
//            if(usuarioOK.equals(usuario) && passwordOK.equals(password)) {
//                response.sendRedirect("index2.html");
//            }
//            else {
//                response.sendRedirect("401.html");
//            }
//        }
//    }

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
        request.getRequestDispatcher("/WEB-INF/identificar.jsp").forward(request, response);
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
        String nombreUsuario = request.getParameter("txtUsu");
        String contraseña = request.getParameter("txtPass");
        Conexion con = new Conexion();
        try {
            Usuario user = con.Identificar(nombreUsuario, contraseña);
            if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.setAttribute("msje", "Bienvenido al sistema");
            session.setAttribute("iniciado", true);
            if(user.getTipoUsu()== 1){
                response.sendRedirect(AppHelper.baseUrl() + "usuario");
            }else if(user.getTipoUsu()==  2){
                response.sendRedirect(AppHelper.baseUrl() + "admin");
            }
        } else {
            request.setAttribute("msje", "Credenciales Incorrectas");
            //request.getRequestDispatcher(AppHelper.baseUrl() + "login").forward(request, response);
            response.sendRedirect("login");
        }
        }  catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
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
