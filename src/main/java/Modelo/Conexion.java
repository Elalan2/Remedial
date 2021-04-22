
package Modelo;
import helper.AppHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author alann
 */
public class Conexion {
    private String URL = "jdbc:mysql://localhost:3306/hoteladri?allowPublicKeyRetrieval=true&useSSL=false";
    private String USER = "root";
    private String PWD = "8246951753l";
    private String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    private Connection conn;
    
    //public Connection conectar(){
    public Conexion(){    
        //Connection cn = null;
    try{
        Class.forName(CLASSNAME);
        conn = DriverManager.getConnection(URL, USER, PWD);
        } catch(ClassNotFoundException e){
            System.err.println("Error "+e);
        }catch(SQLException e){
            System.err.println("Error "+e);
        }
    }
    public Connection getConexion(){
        return conn;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Conexion conn = new Conexion();
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
    
     public Usuario Identificar(String nombreUsuario, String contraseña) throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, PWD);
        String sql = "SELECT * FROM usuario WHERE nombreUsuario = ? and contraseña = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, nombreUsuario);
        statement.setString(2, contraseña);
 
        ResultSet result = statement.executeQuery();
        Usuario user = null;
        if (result.next()) {
            user = new Usuario();
            user.setCorreo(result.getString("Correo"));
            user.setIdUsuario(result.getInt("idUsuario"));
            user.setTipoUsu(result.getInt("idTipoUsuario"));
            user.setNombreUsuario("nombreUsuario");
            
        }
        return user;
    }
     
     public boolean RegistroCliente(String Nombre,String Apellido, String Edad,String Telefono,String RFC, String Estado, String Pais, String tarjeta) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, PWD);
        String sql = "INSERT INTO cliente (Nombre,Apellido,Edad,Telefono,RFC,Estado,Pais,tarjeta)VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        boolean resultado;
        statement.setString(1, Nombre);
        statement.setString(2, Apellido);
        statement.setString(3, Edad);
        statement.setString(4, Telefono);
        statement.setString(5, RFC);
        statement.setString(6, Estado);
        statement.setString(7, Pais);
        statement.setString(8, tarjeta);
        
        
        int result = statement.executeUpdate();

            if (result > 0) {
                //String consulta = "select idCliente from cliente where mail_usu = ? and password_usu = ?";
             resultado = true;

            }else{
               resultado = false;
            }
 
        connection.close();
        return resultado;
        
    }
    
     public boolean RegistroUsuCliente(String RFC,String NombreUsuario, String Contraseña,String Correo) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, PWD);
        String sql = "INSERT INTO usuario ( idUsuario, idCliente, NombreUsuario, Contraseña, Correo, IdTipoUsuario ) \n" +
                     "VALUES(null, (SELECT  idCliente FROM cliente WHERE RFC = ?), ?, ?, ?, 1);";
        PreparedStatement statement = connection.prepareStatement(sql);
        boolean resultado;
        Usuario user = new Usuario();
        ResultSet resulta = statement.executeQuery();
        user.setIdUsuario(resulta.getInt("idTipoUsuario"));
        statement.setInt(1, user.getIdUsuario());
        statement.setString(2, NombreUsuario);
        statement.setString(3, Contraseña);
        statement.setString(4, Correo);
        int result = statement.executeUpdate();

            if (result > 0) {
            
             resultado = true;

            }else{
               resultado = false;
            }
 
        connection.close();
        return resultado;
        
    }
     
     public boolean SoloUsuario(String NombreUsuario, String Contraseña,String Correo) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, PWD);
        String sql = "INSERT INTO usuario (idUsuario,idCliente,NombreUsuario,Contraseña,Correo,IdTipoUsuario)VALUES(null,null,?,?,?,1)";
        PreparedStatement statement = connection.prepareStatement(sql);
        boolean resultado;
        statement.setString(1, NombreUsuario);
        statement.setString(2, Contraseña);
        statement.setString(3, Correo);
        
        
        int result = statement.executeUpdate();

            if (result > 0) {
                //String consulta = "select idCliente from cliente where mail_usu = ? and password_usu = ?";
             resultado = true;

            }else{
               resultado = false;
            }
 
        connection.close();
        return resultado;
        
    }
  
      public boolean checarCorreo(String mail) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(URL, USER, PWD);) {
            String sql = "SELECT * FROM usuario WHERE correo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, mail);

            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                return true;
            } 
            connection.close();
        }
        return false;
    }

    public String resetPass(String mail) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(URL, USER, PWD);) {
            String nueva_pass = AppHelper.randomString(10);

            String sql = "UPDATE usuario SET contraseña = MD5(?) WHERE correo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nueva_pass);
            statement.setString(2, mail);

            int update = statement.executeUpdate();

            if (update == 0) {
                nueva_pass = "";
            } 

            connection.close();
            return nueva_pass;
        }
}
}