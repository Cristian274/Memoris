package ModeloDAO;

import ModeloVO.AdultoMayorVO;
import ModeloVO.MedicamentoVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Util.Conexionbd;
import Util.InterfaceCRUD;
import java.sql.SQLException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
 



public class MedicamentoDAO extends Conexionbd implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    //********************
    private String Id_Med = "", Nomb_Med = "", Cant_Med = "", Composi_Med = "", Contraindi_Med = "", Dosis_Med = "", Fecha_Venci_Med = "", Nom_Lab_Med = "", Via_Med = "";

    private boolean operacion = false;

    //****
    public MedicamentoDAO(MedicamentoVO medVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            Id_Med = medVO.getId_Med();
            Nomb_Med = medVO.getNomb_Med();
            Cant_Med = medVO.getCant_Med();
            Composi_Med = medVO.getComposi_Med();
            Contraindi_Med = medVO.getContraindi_Med();
            Dosis_Med = medVO.getDosis_Med();
            Fecha_Venci_Med = medVO.getFecha_Venci_Med();
            Nom_Lab_Med = medVO.getNom_Lab_Med();
            Via_Med = medVO.getVia_Med();
 
    
    
    
        } catch (Exception e) {
            System.out.println("¡Error!" + e.toString());
        }

    }

    public MedicamentoDAO() {
    }

    @Override
    public boolean agregarRegistro() {
        try {
            puente.executeUpdate("call insertar_medicamento "
                    + "('" + Id_Med + "', '" + Nomb_Med + "','" + Fecha_Venci_Med + "',"
                    + " '" + Composi_Med + "', '" + Via_Med + "', '"
                    + Cant_Med + "', '" + Dosis_Med + "' , '" + Nom_Lab_Med + "' , '" + Contraindi_Med + "');");
            operacion = true;
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());

        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
       try {
           
           puente.executeUpdate("call modificar_medicamento('"+Id_Med+"', '"+Nomb_Med+"', '"+Fecha_Venci_Med+"','"+Composi_Med+"', '"+Via_Med+"','"+Cant_Med+"','"+Dosis_Med+"','"+Nom_Lab_Med+"','"+Contraindi_Med+"');");
            operacion = true;
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return operacion;
    
    }
    
    public ArrayList<MedicamentoVO> listarmedicamento() {
        Conexionbd conexionbd = new Conexionbd();
        ArrayList<MedicamentoVO> listaCategoria = new ArrayList<>();
        try {
            puente = conexionbd.obtenerConexion().createStatement();
            mensajero = puente.executeQuery("select * from MEDICAMENTO");

            while (mensajero.next()) {

                MedicamentoVO enfVO = new MedicamentoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), mensajero.getString(9));
                listaCategoria.add(enfVO);

            }
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return listaCategoria;
    }

    
    

    public  ArrayList <MedicamentoVO>consultariden(String idm) {
        ArrayList <MedicamentoVO> mediVO = new ArrayList<>();
        try {
            Conexionbd conexionbd = new Conexionbd();
            Connection conexion = conexionbd.obtenerConexion();
            Statement puente = conexion.createStatement();
            
            
               ResultSet mensajero = puente.executeQuery("call CONSULTA_MED_ESPE ('"+idm+"'); ");
               while (mensajero.next())
               {
            Id_Med = mensajero.getString("Id_Med");
            Nomb_Med = mensajero.getString("Nombre_Med");
            Cant_Med = mensajero.getString("Cantidad_Med");
            Composi_Med = mensajero.getString("Composi_Med");
            Contraindi_Med = mensajero.getString("Contraindi_Med");
            Dosis_Med = mensajero.getString("Dosis_Med");
            Fecha_Venci_Med = mensajero.getString("Fecha_Venci_Med");
            Nom_Lab_Med = mensajero.getString("Nom_Lab_Med");
            Via_Med = mensajero.getString("Via_Med");
                   MedicamentoVO meVO2=new MedicamentoVO();
            meVO2.setId_Med(Id_Med);
            meVO2.setNomb_Med(Nomb_Med);
            meVO2.setCant_Med(Cant_Med);
            meVO2.setComposi_Med(Composi_Med);
            meVO2.setContraindi_Med(Contraindi_Med);
            meVO2.setDosis_Med(Dosis_Med);
            meVO2.setFecha_Venci_Med(Fecha_Venci_Med);
            meVO2.setNom_Lab_Med(Nom_Lab_Med);
            meVO2.setVia_Med(Via_Med);
                   mediVO.add(meVO2);
                     }
               mensajero.close();
               puente.close();
        } catch (SQLException e) {
            System.out.println("Error" + e.toString());
        }
    return mediVO;

    }

    


}
