/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Conexion;
import helper.AppHelper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alann
 */
@WebServlet(name = "RegistroC", urlPatterns = {"/registroC"})
public class RegistroC extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("/WEB-INF/registroUsu.jsp").forward(request, response);
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
        boolean resultado;
        boolean resultad;
        String NombreUsuario = request.getParameter("txtUsu");
        String Nombre = request.getParameter("txtNombre");
        String Apellido = request.getParameter("txtApellido");
        String Edad = request.getParameter("numberEdad");
        String Telefono = request.getParameter("telTelefono");
        String RFC = request.getParameter("txtRFC");
        String Estado = request.getParameter("txtEstado");
        String Pais = request.getParameter("txtPais");
        String tarjeta = request.getParameter("numberTarjetaC");
        String Contraseña = request.getParameter("txtPass");
        String Correo = request.getParameter("txtCorreo");
        
        Conexion con = new Conexion();
        try {
            resultado = con.RegistroCliente(Nombre, Apellido, Edad, Telefono,RFC,Estado, Pais, tarjeta);
             //String destPage = "login.jsp";
             System.out.println(resultado);
             if(resultado = true){
                 resultad = con.RegistroUsuCliente(RFC, NombreUsuario, Contraseña, Correo);
                 if(resultad = true){
                request.setAttribute("msje", "Registro exitoso");
                     response.sendRedirect(AppHelper.baseUrl() + "login");
                 }
             }else{
                request.setAttribute("msje", "Registro fallido");
                 response.sendRedirect(AppHelper.baseUrl() + "registroC");
             }
            
        } catch (Exception e) {
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
