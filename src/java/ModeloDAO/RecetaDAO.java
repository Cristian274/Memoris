/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;
import ModeloVO.RecetaVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Util.InterfaceCRUD;
import Util.Conexionbd;
/**
 *
 * @author Juan David
 */

    public class RecetaDAO extends Conexionbd implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    String Id_Rec="", nommed_recmed="", viaadmin_recmed="",dosis_recmed="", Fecha_Rec="", cantidad_h_recmed="", Id_enf="",Id_Adult="", dosis_med="";

   
   
   private boolean operaciones = false;

    public RecetaDAO(RecetaVO recetaVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            Id_Rec = recetaVO.getId_Rec();
            Fecha_Rec=recetaVO.getFecha_Rec();
            nommed_recmed=recetaVO.getNommed_recmed();
            cantidad_h_recmed=recetaVO.getCantidad_h_recmed();
            dosis_recmed=recetaVO.getDosis_recmed();
            viaadmin_recmed=recetaVO.getViaadmin_recmed();
            Id_enf=recetaVO.getId_enf();
            Id_Adult=recetaVO.getId_Adult();
           
            
        } catch (Exception e) {
            System.out.println("!Error!" + e.toString());
        }
    }

  

    @Override
    public boolean agregarRegistro() {
        try {
            puente.executeUpdate("call insertar_receta('"+Id_Rec+"','"+Fecha_Rec+"','"+nommed_recmed+"','"+cantidad_h_recmed+"','"+dosis_recmed+"','"+viaadmin_recmed+"', '"+Id_enf+"','"+Id_Adult+"');");
            operaciones = true;
        } catch (Exception e) {
            System.out.println("!Error!" + e.toString());

        }
        return operaciones;

    }
    
    public RecetaDAO(){}
    @Override
    public boolean actualizarRegistro() {
        try {
            puente.executeUpdate("call modificar_receta ('"+Id_Rec+"','" +Fecha_Rec +"','"+nommed_recmed +"','"+cantidad_h_recmed +"','" +viaadmin_recmed +"','"+ Id_enf+"','"+Id_Adult+ "');");
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
public static RecetaVO consultariden(String Identificacion) {
        RecetaVO recVO = null;
        try {
            Conexionbd conexionbd = new Conexionbd();
            Connection conexion = conexionbd.obtenerConexion();
            Statement puente = conexion.createStatement();

            ResultSet mensajero = puente.executeQuery("call CONSULTA_RECETA_ESPE ('" + Identificacion + "');");
            while (mensajero.next()) {

              recVO = new RecetaVO(Identificacion, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7),mensajero.getString(8));

            }
            mensajero.close();
            puente.close();

        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return recVO;
    }
    
    public ArrayList <RecetaVO> listarreceta()
    {
        Conexionbd conexionbd = new Conexionbd();
        ArrayList <RecetaVO> listarreceta = new ArrayList<>();
        try {
            puente = conexionbd.obtenerConexion().createStatement();
            mensajero = puente.executeQuery("select * from RECETA_MEDICA");
            
            while (mensajero.next()) {
              RecetaVO   recVO = new RecetaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7),mensajero.getString(8));
                listarreceta.add(recVO);
                
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        
    return listarreceta;
}
    

}
