/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.FamiliarVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Util.Conexionbd;
import Util.InterfaceCRUD;
import java.sql.SQLException;

/**
 *
 * @author Cristian Florez
 */
public class FamiliarDAO extends Conexionbd implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    //********************
    private String Id_Usuario="",Id_Fam = "", Nomb_Fam = "", Apel_Fam = "", Paren_Fam = "", Email_Fam = "", Foto_Fam = "", Id_Adult = "";

    private boolean operacion = false;

    public FamiliarDAO(FamiliarVO famVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            Id_Usuario=famVO.getId_Usuario();
            Id_Fam = famVO.getId_Fam();
            Nomb_Fam = famVO.getNomb_Fam();
            Apel_Fam = famVO.getApel_Fam();
            Paren_Fam = famVO.getParen_Fam();
            Email_Fam = famVO.getEmail_Fam();
            Foto_Fam = famVO.getFot_Fam();
            Id_Adult = famVO.getId_Adult();
            

        } catch (Exception e) {
            System.out.println("¡Error!" + e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
        
             try {
           int num=(int)(Math.random()*9999+1111);
           puente.executeUpdate("call insertar_familiar ('"+Id_Fam+"', '"+Nomb_Fam+"', '"+Apel_Fam+"', '"+Paren_Fam+"', '"+Email_Fam+"','"+Foto_Fam+"','"+Id_Adult+"','"+Id_Usuario+"');");
           puente.executeUpdate("call insertar_usuario ('"+num+"', '"+Email_Fam+"', '"+Id_Fam+"',3, '"+Nomb_Fam+"');");
            operacion = true;
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return operacion;
    
    }

    public FamiliarDAO() {
    }

    @Override
    public boolean actualizarRegistro() {
     try {
           
           puente.executeUpdate("call modificar_familiar ('"+Id_Fam+"', '"+Nomb_Fam+"', '"+Apel_Fam+"', '"+Paren_Fam+"', '"+Email_Fam+"','"+Foto_Fam+"');");
            operacion = true;
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return operacion;
    
    }

    public ArrayList<FamiliarVO> listarfamiliar() {
        Conexionbd conexionbd = new Conexionbd();
        ArrayList<FamiliarVO> listaFamiliar = new ArrayList<>();
        try {
            puente = conexionbd.obtenerConexion().createStatement();
            mensajero = puente.executeQuery("select * from Familiar");

            while (mensajero.next()) {

                FamiliarVO famVO = new FamiliarVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
                listaFamiliar.add(famVO);

            }
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return listaFamiliar;
    }

    public ArrayList<FamiliarVO> consultarIda (String idam)
    {
      ArrayList  <FamiliarVO> famVO = new ArrayList<>();
        try {
            Conexionbd conexionbd = new Conexionbd();
            Connection conexion = conexionbd.obtenerConexion();
            Statement puente = conexion.createStatement();
            
            
               ResultSet mensajero = puente.executeQuery("call CONSULTA_FAMILIAR_ESPE ('"+idam+"'); ");
               while (mensajero.next())
               {
                   Id_Fam=mensajero.getString("Id_Fam");
                   Nomb_Fam=mensajero.getString("Nombre_Fam");
                   Apel_Fam=mensajero.getString("Apellidos_Fam");
                   Paren_Fam=mensajero.getString("Parentesco_Fam");
                   Email_Fam=mensajero.getString("Email_Fam");
                   Foto_Fam=mensajero.getString("Foto_Fam");
                   Id_Adult=mensajero.getString("Id_Adulto");
                   Id_Usuario=mensajero.getString("Id_Usuario");
                  FamiliarVO adulVO2=new FamiliarVO();
                   adulVO2.setId_Fam(Id_Fam);
                   adulVO2.setNomb_Fam(Nomb_Fam);
                   adulVO2.setApel_Fam(Apel_Fam);
                   adulVO2.setParen_Fam(Paren_Fam);
                   adulVO2.setEmail_Fam(Email_Fam);
                   adulVO2.setFot_Fam(Foto_Fam);
                   adulVO2.setId_Adult(Id_Adult);
                   adulVO2.setId_Usuario(Id_Usuario);
                   famVO.add(adulVO2);
                     }
               mensajero.close();
               puente.close();
        } catch (SQLException e) {
            System.out.println("Error" + e.toString());
        }
    return famVO;
    }
    
}
