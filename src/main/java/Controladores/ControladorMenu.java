/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import daos.DaoServicioRestaurante;
import dtos.DtoListaListas;
import dtos.DtoMenu;
import dtos.DtoMenuVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
 * @author Craft
 */
@WebServlet(name = "ControladorMenu", urlPatterns = {"/Menu", "/orden","/agregarSesion","/miOrden",
    "/guardardatos"})
public class ControladorMenu extends HttpServlet {

    //ToDo. inicializar el dao
    
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
        try{
            String ruta=request.getServletPath();
            response.setContentType("text/html;charset=UTF-8");
           DaoServicioRestaurante daoServRest;
            switch(ruta){
                case "/Menu":
                    daoServRest = new DaoServicioRestaurante();
                    List<DtoMenu> listaMenu =daoServRest.read();
                    request.setAttribute("datos", listaMenu);
                    request.getRequestDispatcher("/WEB-INF/servicioRestaurante.jsp").forward(request, response);
                break;
                
                case "/orden":
                    
                    String id=request.getParameter("idMenu").toString();
                    System.out.print(id);
                    int idMenu=Integer.parseInt(id);
                     daoServRest = new DaoServicioRestaurante();
                       //String idMenu= request.getParameter("idMenu");
                       List<DtoMenu> listaOrden =daoServRest.readOrden(idMenu);
                       //DtoMenu dtomenu = daoServRest.read(Integer.parseInt(idMenu)); 
                       request.setAttribute("dato", listaOrden);
                       //if(dtomenu !=null){
                         //  request.setAttribute("dato", dtomenu);
                       //}
              
                    request.getRequestDispatcher("/WEB-INF/orden.jsp").forward(request, response);
                     
                break;
                
            }
            
            
        }catch(Exception ex){
          Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE,null,ex);
         response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            
        }
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
        HttpSession sesion= request.getSession(true);
        try{
            String ruta=request.getServletPath();
            response.setContentType("text/html;charset=UTF-8");
            switch(ruta){
                case"/Menu":
                    DaoServicioRestaurante daoServRest = new DaoServicioRestaurante();
                    List<DtoMenu> listaMenu =daoServRest.read();
                    request.setAttribute("datos", listaMenu);
                    request.getRequestDispatcher("/WEB-INF/servicioRestaurante.jsp").forward(request, response);
                break;
                
                
                
                
                case "/agregarSesion":
                    DaoServicioRestaurante daoServRes = new DaoServicioRestaurante();

                    String id=request.getParameter("idMenu").toString();
                    String cantidad=request.getParameter("cantidad").toString();
                    

                        int idMenu=Integer.parseInt(id);
                     daoServRes = new DaoServicioRestaurante();
                       //String idMenu= request.getParameter("idMenu");
                       DtoMenu listaOrden =daoServRes.readOrde(idMenu);
                       
                       DtoMenuVO listaVO=new DtoMenuVO(listaOrden,Integer.parseInt(cantidad));
                       
                       
                       
                       List<DtoMenuVO> listaNueva=new ArrayList<DtoMenuVO>();
                       
                       listaNueva.add(listaVO);
//                       List<DtoMenuVO> listaSesion;
//                       DtoListaListas listNueva=new DtoListaListas(listaNueva);
                     List<DtoMenuVO> listaSesion = null;  
                       
//                 List <DtoListaListas> listSesion;
                       if(sesion.getAttribute("listas")!=null){
                           System.out.println("controller.ControladorMenu.doPost()");
                       listaSesion =  (List<DtoMenuVO>) sesion.getAttribute("listas");
                        listaSesion.add(listaVO);
                        
                       }else{
                   
    
                    sesion.setAttribute("listas", listaNueva);
//                    
                   List <DtoMenuVO> listSesionss;
//
                     listSesionss =  (List<DtoMenuVO>) sesion.getAttribute("listas");

                        for(DtoMenuVO listSesion1 : listSesionss) {
                            
                            System.out.println(listSesion1.getCantidad()+"alo");
                    }
//                    
                      }
                    break;

                    case "/miOrden":
                       

                    request.getRequestDispatcher("/WEB-INF/listaOrden.jsp").forward(request, response);
                    break;
                    
                    case "/guardardatos":
                        
                        DaoServicioRestaurante daoServResta = new DaoServicioRestaurante();
                        
                                List <DtoMenuVO> listSesionss;
//
                     listSesionss =  (List<DtoMenuVO>) sesion.getAttribute("listas");
                        
                      for(DtoMenuVO l : listSesionss) {
                          System.out.print("en el list");
                          daoServResta.terimnarorden(l.getIdMenu(), l.getCantidad(), l.getCantidad()*l.getPrecio());
                          
                    }
                     sesion.setAttribute("listas", null);
                        break;
            }
            
            
        }catch(Exception ex){
            System.out.println(ex);
          
            
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
