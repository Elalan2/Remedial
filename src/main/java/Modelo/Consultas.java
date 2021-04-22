/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alann
 */
public class Consultas extends Conexion{
     public Usuario Login(String nombreUsuario, String contraseña){
        Usuario user = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM usuario WHERE nombreUsuario = ? and contraseña = ?";
            statement = getConexion().prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            statement.setString(2, contraseña);
            result = statement.executeQuery();
            if (result.next()) {
                user = new Usuario();
                user.setCorreo(result.getString("Correo"));
                user.setIdUsuario(result.getInt("idUsuario"));
                user.setTipoUsu(result.getInt("idTipoUsuario"));
                
            }
            }catch(Exception e){
            System.err.println("Error"+e);
        }finally{
            try{
                if(getConexion() != null) getConexion().close(); 
                if(statement != null) statement.close();
                if(result != null) result.close();
            }catch(Exception ex){
            System.err.println("Error"+ex);
                    }
        }
        return user;
    }
    
     public boolean RegistroCliente(String Nombre,String Apellido, int Edad,String Telefono,String RFC, String Estado, String Pais, String tarjeta) throws ClassNotFoundException, SQLException{
        boolean resultado;
        PreparedStatement statement = null;
         try{
        String sql = "INSERT INTO cliente (Nombre,Apellido,Edad,Telefono,RFC,Estado,Pais,tarjeta)VALUES(?,?,?,?,?,?,?,?)";
        statement = getConexion().prepareStatement(sql);
        
        statement.setString(1, Nombre);
        statement.setString(2, Apellido);
        statement.setInt(3, Edad);
        statement.setString(4, Telefono);
        statement.setString(5, RFC);
        statement.setString(6, Estado);
        statement.setString(7, Pais);
        statement.setString(8, tarjeta);
        
        
        int result = statement.executeUpdate();

            if (result > 0) {
                //String consulta = "select idCliente from cliente where mail_usu = ? and password_usu = ?";
             resultado = true;

            }
            }catch(Exception ex){
            System.err.println("Error "+ex);
        }finally{
                    try{
                        if(getConexion() != null)getConexion().close();
                        if(statement != null)statement.close();
                    }catch(Exception e){
                        System.err.println("Error "+e);
                    }
                }
        return false;
         
        
    }
    
     public boolean RegistroUsuCliente(String RFC,String NombreUsuario, String Contraseña,String Correo) throws ClassNotFoundException, SQLException{
        Usuario user = null;
        PreparedStatement pst = null;
        ResultSet result = null;
        try{
        String sql = "insert into usuario (idUsuario, idCliente, NombreUsuario, Contraseña, Correo, IdTipoUsuario) \n" +
                     "values (null, (select idCliente from cliente where RFC = ?), ?, ?, ?, 1);";
        pst = getConexion().prepareStatement(sql);
        boolean resultado;
        user = new Usuario();
        user.setIdUsuario(result.getInt("idTipoUsuario"));
        pst.setInt(1, user.getIdUsuario());
        pst.setString(2, NombreUsuario);
        pst.setString(3, Contraseña);
        pst.setString(4, Correo);
        
        
        int resultao = pst.executeUpdate();

            if (resultao > 0) {
            
             resultado = true;

            }
            }catch(Exception ex){
            System.err.println("Error "+ex);
        }finally{
                    try{
                        if(getConexion() != null)getConexion().close();
                        if(pst != null)pst.close();
                    }catch(Exception e){
                        System.err.println("Error "+e);
                    }
                }
        return false;
        
    }
     public int validar(Usuario user){
        PreparedStatement pst = null;
        ResultSet rs = null;
        int r = 0;
        try{
            String sql = "SELECT * FROM usuario WHERE nombreUsuario = ? and contraseña = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setString(1, user.getNombreUsuario());
            pst.setString(2, user.getCotraseña());
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                    r++;
            } 
            if(r==1){
                return 1;
            } else{
                return 0;
            }
        }catch(Exception e){
            System.err.println("Error"+e);
            return 0; 
        }
    }

   public static void main(String args[]){
       int r;
       Consultas s = new Consultas();
        Usuario user = new Usuario();
        user.setNombreUsuario("alan");
        user.setCotraseña("1234");
        System.out.println(s.validar(user));
   }
}
