/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;


import Util.Conexionbd;
import Util.InterfaceCRUD;
import ModeloVO.ReporteVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Juan David
 */
public class ReporteDAO extends Conexionbd implements InterfaceCRUD {
    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    String Id_Reporte="",Fecha_Reporte="",Comportamiento="",Id_Adult="";
   
   
   private boolean operaciones = false;

    public ReporteDAO(ReporteVO reportevo) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            Id_Reporte =  reportevo.getId_Reporte();
            Fecha_Reporte= reportevo.getFecha_Reporte();
            Comportamiento= reportevo.getComportamiento();
           Id_Adult= reportevo.getId_Adult();
            
           
            
        } catch (Exception e) {
            System.out.println("!Error!" + e.toString());
        }
        
}

    public ReporteDAO() {
       
    }

    @Override
    public boolean agregarRegistro() {
        try {
            puente.executeUpdate("call insertar_reporte ('"+Id_Reporte+"','" +Fecha_Reporte +"','" +Comportamiento + "','"+Id_Adult +"');");
            operaciones=true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
       try {
            puente.executeUpdate("call modificar_reporte ('"+Id_Reporte+"','" +Fecha_Reporte +"','" +Comportamiento + "','"+Id_Adult +"');");
       operaciones=true; 
       } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
    public static ReporteVO consultariden (String Identificacion) {
        ReporteVO recVO = null;
        try {
            Conexionbd conexionbd = new Conexionbd();
            Connection conexion = conexionbd.obtenerConexion();
            Statement puente = conexion.createStatement();

            ResultSet mensajero = puente.executeQuery("call CONSULTA_ESPE_REPORTE ('" + Identificacion + "');");
            while (mensajero.next()) {

             recVO = new ReporteVO(Identificacion, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));

            }
            mensajero.close();
            puente.close();

        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return recVO;
    }
   
 public ArrayList <ReporteVO> listarreporte()
    {
        Conexionbd conexionbd = new Conexionbd();
        ArrayList <ReporteVO> listarreporte = new ArrayList<>();
        try {
            puente = conexionbd.obtenerConexion().createStatement();
            mensajero = puente.executeQuery("select * from Reporte");
            
            while (mensajero.next()) {
              ReporteVO  repVO = new ReporteVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                listarreporte.add(repVO);
                
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        
    return listarreporte;
}
 

    public ArrayList<ReporteVO> listarreporteidentificacion(String cedula) {
        Conexionbd conexionbd = new Conexionbd();
        ArrayList <ReporteVO> listareporte = new ArrayList();
        
        try {
            puente = conexionbd.obtenerConexion().createStatement();
            mensajero = puente.executeQuery("select * from reporte where Id_Adult = '"+cedula+"' ");
            while (mensajero.next())
            {
                ReporteVO recVO = new ReporteVO (mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                listareporte.add(recVO);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    
    return listareporte;
    }   
    
}


