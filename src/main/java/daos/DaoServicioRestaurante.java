/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.DtoDetalleReciboRestaurante;
import dtos.DtoMenu;
import interfaces.IServicioRestaurante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adry
 */
public class DaoServicioRestaurante implements IServicioRestaurante{
    private String URL = "jdbc:mysql://localhost:3306/hotel?useSSL=false";
    private String USER = "root";
    private String PWD = "";
    private Connection conn;
    ResultSet rs;
    PreparedStatement ps;
    String consulta;
   

    @Override
    public List<DtoMenu> read() throws Exception {
     List<DtoMenu> datosMenu = new ArrayList<>();
     consulta="Select idMenu,Elemento,Tamaño,Precio from menu";
     Class.forName("com.mysql.cj.jdbc.Driver");
     conn=DriverManager.getConnection(URL,USER,PWD);
     ps=conn.prepareStatement(consulta);
     rs=ps.executeQuery();
     while (rs.next()){
        DtoMenu menu= new DtoMenu();
        menu.setIdMenu(rs.getInt("idMenu"));
        menu.setElemento(rs.getString("elemento"));
        menu.setTamaño(rs.getString("tamaño"));
        menu.setPrecio(rs.getFloat("precio"));
        datosMenu.add(menu);
     }
     conn.close();
     return  datosMenu;
    }

    @Override
    public boolean create(DtoMenu dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DtoMenu dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoMenu readOrde(int idMenu) throws Exception {
        DtoMenu orden= null;
        
     consulta="Select idMenu,Elemento,Tamaño,Precio from menu where idMenu="+idMenu;
     Class.forName("com.mysql.cj.jdbc.Driver");
     conn=DriverManager.getConnection(URL,USER,PWD);
     ps=conn.prepareStatement(consulta);
//     ps.setInt(1,idMenu);
     rs=ps.executeQuery();
     if(rs.next()){
         orden = new DtoMenu();
         orden.setIdMenu(rs.getInt("idMenu"));
          orden.setElemento(rs.getString("Elemento"));
        orden.setTamaño(rs.getString("Tamaño"));
        orden.setPrecio(rs.getFloat("Precio"));
     }
     //DtoMenu menu= new DtoMenu();
        //menu.setIdMenu(rs.getInt("idMenu"));
        //menu.setElemento(rs.getString("elemento"));
        //menu.setTamaño(rs.getString("tamaño"));
        //menu.setPrecio(rs.getFloat("precio"));
       // datosMenu.add(orden);
    
        conn.close();
     return  orden;
    }

    @Override
    public boolean pedir(DtoDetalleReciboRestaurante dto) throws Exception {
        DtoDetalleReciboRestaurante dtoDetalle= new DtoDetalleReciboRestaurante();
        Class.forName("com.mysql.cj.jdbc.Driver");
        consulta="insert into reciboRestaurate(idReciboR,idCuarto,Fecha)values(?,1,?)";
        conn=DriverManager.getConnection(URL,USER,PWD);
     ps=conn.prepareStatement(consulta);
     
        
        return false;
    }

    @Override
    public List<DtoMenu> readOrden(int idMenu) throws Exception {
       DtoMenu orden= null;
        
     consulta="Select idMenu,Elemento,Tamaño,Precio from menu where idMenu="+idMenu;
     Class.forName("com.mysql.cj.jdbc.Driver");
     conn=DriverManager.getConnection(URL,USER,PWD);
     ps=conn.prepareStatement(consulta);
//     ps.setInt(1,idMenu);
     rs=ps.executeQuery();
     while(rs.next()){
         orden = new DtoMenu();
         orden.setIdMenu(rs.getInt("idMenu"));
          orden.setElemento(rs.getString("Elemento"));
        orden.setTamaño(rs.getString("Tamaño"));
        orden.setPrecio(rs.getFloat("Precio"));
     }
     List<DtoMenu> menu= new ArrayList<DtoMenu>();
     
     menu.add(orden);
//     DtoMenu menu= new DtoMenu();
        //menu.setIdMenu(rs.getInt("idMenu"));
        //menu.setElemento(rs.getString("elemento"));
        //menu.setTamaño(rs.getString("tamaño"));
        //menu.setPrecio(rs.getFloat("precio"));
       // datosMenu.add(orden);
    
        conn.close();
     return  menu;
    }

    @Override
    public boolean terimnarorden(int idmenu, int cantidad, float subtotal) throws Exception {
        
            DtoDetalleReciboRestaurante dtoDetalle= new DtoDetalleReciboRestaurante();
        Class.forName("com.mysql.cj.jdbc.Driver");
        consulta="insert into detallereciborestaurante (IdReciboRestaurante,idMenu,Cantidad, Subtotal)values(1,"+idmenu+","+cantidad+","+subtotal+")";
        conn=DriverManager.getConnection(URL,USER,PWD);
     ps=conn.prepareStatement(consulta);
      ps.executeUpdate();
      
  
        return false;
        
        
        
    }
}


     

