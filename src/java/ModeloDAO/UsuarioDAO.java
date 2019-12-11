

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Util.InterfaceCRUD;
import Util.Conexionbd;

/**
 *
 * @author APRENDIZ
 */
public class UsuarioDAO extends Conexionbd implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    private String Id_usu = "";
    private String daonom_Usuario = "";
    private String daocontrasena = "";
    private String roles = "";
    private String nombrecompl="";
    private boolean operaciones = false;

    public UsuarioDAO(UsuarioVO UsuarioVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            
            Id_usu = UsuarioVO.getId_usu();
            daonom_Usuario = UsuarioVO.getNom_usu();
            daocontrasena = UsuarioVO.getCont_Usu();
            nombrecompl=UsuarioVO.getNombrecomple();
            
            roles=UsuarioVO.getRol();
        } catch (Exception e) {
            System.out.println("!Error!" + e.toString());
        }
    }

  public UsuarioDAO(){}

    @Override
    public boolean agregarRegistro() {
        try {
           
            puente.executeUpdate("call insertar_usuario ('"+Id_usu+"','" + daonom_Usuario+ "','" + daocontrasena + "','"+ Integer.parseInt(roles)+"','"+ nombrecompl +"');");
            operaciones = true;
        } catch (Exception e) {
            System.out.println("!Error!" + e.toString());

        }
        return operaciones;

    }
     public boolean actualizarRegistro() {
        try {
            puente.executeUpdate("call modificar_usuario ('" + Id_usu + "','" + daonom_Usuario + "','" + nombrecompl + "','" + daocontrasena + "','"+roles+"');");
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
    
     public  ArrayList <UsuarioVO> consultarlog(String Login) {
         ArrayList <UsuarioVO> usuVO = new ArrayList<>();
        try {
            Conexionbd conexionbd = new Conexionbd();
            Connection conexion = conexionbd.obtenerConexion();
            Statement puente = conexion.createStatement();

            ResultSet mensajero = puente.executeQuery("select * from usuario where usuario_id = '"+Login+"';");
            while (mensajero.next()) {

             Id_usu =mensajero.getString("usuario_id");
            daonom_Usuario = mensajero.getString("usuario");
            daocontrasena = mensajero.getString("contra");
            nombrecompl=mensajero.getString("nombre_completo");
            roles=mensajero.getString("nivelUsuario");
            UsuarioVO usuVO2 = new UsuarioVO();
            usuVO2.setId_usu(Id_usu);
            usuVO2.setNom_usu(daonom_Usuario);
            usuVO2.setCont_Usu(daocontrasena);
            usuVO2.setNombrecomple(nombrecompl);
            usuVO2.setRol(roles);
            usuVO.add(usuVO2);
            }
            mensajero.close();
            puente.close();

        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return usuVO;
    }
    
    public ArrayList <UsuarioVO> listarUsuario()
    {
        Conexionbd conexionbd = new Conexionbd();
        ArrayList <UsuarioVO> listarUsuario = new ArrayList<>();
        try {
            puente = conexionbd.obtenerConexion().createStatement();
            mensajero = puente.executeQuery("select * from USUARIO");
            
            while (mensajero.next()) {
                UsuarioVO usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),mensajero.getString(5));
                listarUsuario.add(usuVO);
                
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        
    return listarUsuario;
}
    
    
public boolean validarLogin(String usuario, String password) {
        try {

            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            mensajero = puente.executeQuery("call PALogin ('" + usuario + "' , '" + password + "');");

            if (mensajero.next()) {
                operaciones = true;
            }
            this.cerrarConexion();

        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }
 public ArrayList<UsuarioVO> IniciarSesion(String usuario, String clave) {
        Conexionbd conBD = new Conexionbd();
        ArrayList<UsuarioVO> lista = new ArrayList<>();
        try {
            puente = conBD.obtenerConexion().createStatement();

            mensajero = puente.executeQuery("call PALogin ('" + usuario + "' , '" + clave + "');");
             while (mensajero.next()) {

                Id_usu = mensajero.getString("usuario_id");
                daonom_Usuario = mensajero.getString("usuario");
                daocontrasena = mensajero.getString("contra");
                roles = mensajero.getString("nivelUsuario");
                nombrecompl=mensajero.getString("nombre_completo");
                
               
                

                UsuarioVO usuVO = new UsuarioVO(Id_usu, daonom_Usuario,daocontrasena , roles,nombrecompl);
                lista.add(usuVO);
                
                this.cerrarConexion();
                
            }
             
             
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
           

        }
        return lista;
    }
      
 public boolean ConsulNo(String usuario) {
        try {

            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            mensajero = puente.executeQuery("call PLogin ('" + usuario + "');");

            if (mensajero.next()) {
                operaciones = true;
            }
            this.cerrarConexion();

        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }
 public ArrayList<UsuarioVO> Sesion(String usuario) {
        Conexionbd conBD = new Conexionbd();
        ArrayList<UsuarioVO> lista = new ArrayList<>();
        try {
            puente = conBD.obtenerConexion().createStatement();

            mensajero = puente.executeQuery("call PLogin ('" + usuario + "');");
             while (mensajero.next()) {

                Id_usu = mensajero.getString("usuario_id");
                daonom_Usuario = mensajero.getString("usuario");
                daocontrasena = mensajero.getString("contra");
                roles = mensajero.getString("nivelUsuario");
                nombrecompl=mensajero.getString("nombre_completo");
                
               
                

                UsuarioVO usuVO = new UsuarioVO(Id_usu, daonom_Usuario,daocontrasena , roles,nombrecompl);
                lista.add(usuVO);
                
                this.cerrarConexion();
                
            }
             
             
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
           

        }
        return lista;
    }    
  

}

  
