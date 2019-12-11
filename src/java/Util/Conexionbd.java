package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexionbd {
    
    private String driverbd, urlbd, userbd, passwordbd, bd;    
    private  Connection conexion;
    
    public Conexionbd()
    {
        driverbd = "com.mysql.jdbc.Driver";
        userbd="root";
        passwordbd="";
        bd="adherencia_terapeutica";
        urlbd="jdbc:mysql://localhost:3306/" + bd;
        
        try 
        {
            Class.forName(driverbd).newInstance();
            conexion = DriverManager.getConnection(urlbd, userbd,passwordbd);
            System.out.println("Conexion Okei!");
        } catch (Exception e) 
        {
            System.out.println("Error al conectar con BD" +e.toString());
        }
    }
    public Connection obtenerConexion()
    {
        return conexion;
    }
    public Connection cerrarConexion() throws SQLException
    {
        conexion.close();
        conexion=null;
        return conexion;
    }
    
    
            
    public static void main(String[] args) {
        new Conexionbd();
    }
    private Connection ObtenerConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
