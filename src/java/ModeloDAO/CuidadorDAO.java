/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.CuidadorVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Util.Conexionbd;
import Util.InterfaceCRUD;

/**
 *
 * @author Cristian Florez
 */
public class CuidadorDAO extends Conexionbd implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    //********************
    private String Id_Cuid = "", Nomb_Cuid = "", Apel_Cuid = "", Telefono_Cuid = "", Email_Cuid = "", Foto_Cuid = "",Id_Usuario="";

    private boolean operacion = false;

    public CuidadorDAO(CuidadorVO cuidVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            Id_Usuario=cuidVO.getId_usuario();
            Id_Cuid = cuidVO.getId_Cuid();
            Nomb_Cuid = cuidVO.getNomb_Cuid();
            Apel_Cuid = cuidVO.getApel_Cuid();
            Email_Cuid = cuidVO.getEmail_Cuid();
            Telefono_Cuid = cuidVO.getTelefono_Cuid();
            Foto_Cuid = cuidVO.getFoto_Cuid();

        } catch (Exception e) {
            System.out.println("¡Error!" + e.toString());
        }
    }

    public CuidadorDAO() {
        
    }

    @Override
    public boolean agregarRegistro() {
        
       try {
            int num=(int)(Math.random()*9999+1111);
           puente.executeUpdate("call insertar_cuidador('"+Id_Cuid+"', '"+Nomb_Cuid+"', '"+Apel_Cuid+"','"+Telefono_Cuid+"', '"+Email_Cuid+"','"+Foto_Cuid+"','"+Id_Usuario+"');");
           puente.executeUpdate("call insertar_usuario('"+num+"', '"+Telefono_Cuid+"', '"+Id_Cuid+"',2, '"+Nomb_Cuid+"');");
           operacion = true;
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return operacion;
    
    }

    @Override
    public boolean actualizarRegistro() {
       try {
           
           puente.executeUpdate("call modificar_cuidador ('"+Id_Cuid+"', '"+Nomb_Cuid+"', '"+Apel_Cuid+"','"+Telefono_Cuid+"', '"+Email_Cuid+"','"+Foto_Cuid+"','"+Id_Usuario+"');");
            operacion = true;
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return operacion;
    
    }


    public ArrayList <CuidadorVO> consultariden(String Identificacion) {
       ArrayList <CuidadorVO> cuidVO = new ArrayList<>();
        try {
            Conexionbd conexionbd = new Conexionbd();
            Connection conexion = conexionbd.obtenerConexion();
            Statement puente = conexion.createStatement();

            ResultSet mensajero = puente.executeQuery("call CONSULTA_CUIDADOR_ESPE ('" + Identificacion + "');");
            while (mensajero.next()) {
            Id_Usuario=mensajero.getString("Id_Cuid");
            Id_Cuid = mensajero.getString("Nombre_Cuid");
            Nomb_Cuid = mensajero.getString("Apellidos_Cuid");
            Apel_Cuid = mensajero.getString("Telefono_Cuid");
            Email_Cuid = mensajero.getString("Email_Cuid");
            Telefono_Cuid = mensajero.getString("Foto_Cuid");
            Foto_Cuid = mensajero.getString("Id_Usuario");
            CuidadorVO cuiVO=new CuidadorVO();
            cuiVO.setId_usuario(Id_Usuario);
            cuiVO.setId_Cuid(Id_Cuid);
            cuiVO.setNomb_Cuid(Nomb_Cuid);
            cuiVO.setApel_Cuid(Apel_Cuid);
            cuiVO.setEmail_Cuid(Email_Cuid);
            cuiVO.setTelefono_Cuid(Telefono_Cuid);
            cuiVO.setFoto_Cuid(Foto_Cuid);
             
            }
            mensajero.close();
            puente.close();

        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return cuidVO;
    }
    
    public ArrayList <CuidadorVO> listarCuidador()
    {
        Conexionbd conexionbd = new Conexionbd();
        ArrayList <CuidadorVO> listarCuidador = new ArrayList<>();
        try {
            puente = conexionbd.obtenerConexion().createStatement();
            mensajero = puente.executeQuery("select * from CUIDADOR");
            
            while (mensajero.next()) {
                CuidadorVO cuidVO = new CuidadorVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6),mensajero.getString(7));
                listarCuidador.add(cuidVO);
                
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        
    return listarCuidador;
}
    

}
