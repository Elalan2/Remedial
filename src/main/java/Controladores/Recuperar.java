/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Conexion;
import helper.AppHelper;
import helper.Email;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "Recuperar", urlPatterns = {"/recuperar","/enviar_recuperacion"})
public class Recuperar extends HttpServlet {
    private String host;
    private String port;
    private String email;
    private String name;
    private String pass;
    
    @Override
    public void init() {
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        email = context.getInitParameter("email");
        name = context.getInitParameter("name");
        pass = context.getInitParameter("pass");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/recuperar_pass.jsp").forward(request, response);
    }
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/enviar_recuperacion":
                String mail = request.getParameter("mail");
                  Conexion conexion = new Conexion();
                  JSONObject json = new JSONObject();
                  json.put("test", mail);
                  try {
                    if(conexion.checarCorreo(mail)){
                        String nueva_pass = conexion.resetPass(mail);
                        if(!nueva_pass.equals("")) {
                            String recipient = mail;
                            String subject = "Recuperación de contraseña";
                            
                            String content = "Estos son sus nuevos datos de ingreso<br><br>" +
                                    "<b>Correo: </b>" + mail + "<br>" +
                                    "<b>Contraseña temporal: </b>" + nueva_pass + "<br>" + 
                                    "<br>Debe cambiar su contraseña después de ingresar.";
                            
                            String message = "";
                            try {
                                Email.sendEmail(host, port, email, name, pass, recipient, subject, content);
                                json.put("resultado", true);
                                json.put("mensaje", "Email de recuperación enviado.");
                            } catch (UnsupportedEncodingException | MessagingException ex) {
                                json.put("resultado", false);
                                json.put("error", ex.getMessage());
                            }
                        }else{
                            json.put("resultado", false);
                            json.put("error", "No se pudo reiniciar la contraseña.");
                        }
                    } else{
                        json.put("resultado", false);
                        json.put("error", "No se encuentra el correo ingresado.");
                    }     
                } catch (ClassNotFoundException | SQLException | JSONException e) {
                    throw new ServletException(e);
                } finally {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter(); 
                    out.print(json);
                    out.flush();
                }               
       } 
    }   
}
