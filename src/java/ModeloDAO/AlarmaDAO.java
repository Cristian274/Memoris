/*

Id_Alarm
Nom_Med
Via_Adminis_Alarm
Dosis_Medica_Alarm
Frecuencia_Medica_Alarm
Fecha_Inicio_Alarm
Fecha_Final_Alarm
Hora_Alarma
Tono_Alarm
Id_Cuidador
Id_Medicamento

 */
package ModeloDAO;

import ModeloVO.AlarmaVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Util.Conexionbd;
import Util.InterfaceCRUD;
import java.sql.CallableStatement;
import java.sql.SQLException;

/* @author Dayanna  */
public class AlarmaDAO extends Conexionbd implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    private String Id_Alarm = "", Nom_Med = "", Via_Adminis_Alarm = "", Cantidad_Alarm = "", Dosis_Medica_Alarm = "", Frecuencia_Medica_Alarm = "", Fecha_Inicio_Alarm = "", Fecha_Final_Alarm = "", Id_Cuidador = "", Id_Medicamento = "";

    private boolean operacion = false;

    public AlarmaDAO(AlarmaVO alaVO) {

        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            Id_Alarm = alaVO.getId_Alarm();
            Via_Adminis_Alarm = alaVO.getVia_Adminis_Alarm();
            Cantidad_Alarm = alaVO.getCantidad_Alarm();
            Dosis_Medica_Alarm = alaVO.getDosis_Medica_Alarm();
            Frecuencia_Medica_Alarm = alaVO.getFrecuencia_Medica_Alarm();
            Fecha_Inicio_Alarm = alaVO.getFecha_Inicio_Alarm();
            Fecha_Final_Alarm = alaVO.getFecha_Final_Alarm();

            Id_Cuidador = alaVO.getId_Cuidador();
            Id_Medicamento = alaVO.getId_Medicamento();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }

    }

    public AlarmaDAO() {
    }

    @Override
    public boolean agregarRegistro() {
        try {
            System.out.println(Id_Alarm + "\n" + Id_Cuidador + "\n" + Cantidad_Alarm + "\n" + Dosis_Medica_Alarm + "\n" + Fecha_Final_Alarm + "\n" + Fecha_Inicio_Alarm + "\n" + Frecuencia_Medica_Alarm + "\n" + Id_Medicamento + "\n" + Via_Adminis_Alarm);
            puente.executeUpdate("call insertar_alarma ('" + Id_Alarm + "', '" + Via_Adminis_Alarm + "', '" + Cantidad_Alarm + "','" + Dosis_Medica_Alarm + "', '" + Frecuencia_Medica_Alarm + "','" + Fecha_Inicio_Alarm + "','" + Fecha_Final_Alarm + "','" + Id_Cuidador + "','" + Id_Medicamento + "');");
            operacion = true;
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return operacion;

    }

    @Override
    public boolean actualizarRegistro() {
        try {

            puente.executeUpdate("call modificar_alarma ('" + Id_Alarm  + "', '" + Via_Adminis_Alarm + "', '" + Cantidad_Alarm + "','" + Dosis_Medica_Alarm + "', '" + Frecuencia_Medica_Alarm + "','" + Fecha_Inicio_Alarm + "','" + Fecha_Final_Alarm +  "');");
            operacion = true;
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return operacion;
    }

    public ArrayList <AlarmaVO> consultarId(String id) {
      ArrayList  <AlarmaVO> alaVO = new ArrayList<>();
        try {
            Conexionbd conexionbd = new Conexionbd();
            Connection conexion = conexionbd.obtenerConexion();
            Statement puente = conexion.createStatement();


            ResultSet mensajero = puente.executeQuery("call CONSULTA_ESPE_ALARMA  ('" + id + "');");
            while (mensajero.next()) {
              
            Id_Alarm = mensajero.getString("Id_Alarm");
            Via_Adminis_Alarm = mensajero.getString("Via_Adminis_Alarm");
            Cantidad_Alarm = mensajero.getString("Cantidad_Alarm");
            Dosis_Medica_Alarm = mensajero.getString("Dosis_Medica_Alarm");
            Frecuencia_Medica_Alarm = mensajero.getString("Frecuencia_Medica_Alarm");
            Fecha_Inicio_Alarm = mensajero.getString("Fecha_Inicio_Alarm");
            Fecha_Final_Alarm = mensajero.getString("Fecha_Final_Alarm");
            Id_Cuidador = mensajero.getString("Id_Cuidador");
            Id_Medicamento = mensajero.getString("Id_Medicamento");
            AlarmaVO alarVO= new AlarmaVO();
            alarVO.setId_Alarm(Id_Alarm);
            alarVO.setVia_Adminis_Alarm(Via_Adminis_Alarm);
            alarVO.setCantidad_Alarm(Cantidad_Alarm);
            alarVO.setDosis_Medica_Alarm(Dosis_Medica_Alarm);
            alarVO.setFrecuencia_Medica_Alarm(Frecuencia_Medica_Alarm);
            alarVO.setFecha_Inicio_Alarm(Fecha_Inicio_Alarm);
            alarVO.setFecha_Final_Alarm(Fecha_Final_Alarm);
            alarVO.setId_Cuidador(Id_Cuidador);
            alarVO.setId_Medicamento(Id_Medicamento);
            alaVO.add(alarVO);
            }
            mensajero.close();
            puente.close();

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }

        return alaVO;
    }

    public ArrayList<AlarmaVO> listarAlarma() {
        Conexionbd conexionbd = new Conexionbd();
        ArrayList<AlarmaVO> listaAlarma = new ArrayList<>();
        try {
            puente = conexionbd.obtenerConexion().createStatement();
            mensajero = puente.executeQuery("call CONSULTA_GENE_ALARMA()");

            while (mensajero.next()) {
                AlarmaVO alaVO = new AlarmaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), mensajero.getString(9));
                listaAlarma.add(alaVO);

            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }

        return listaAlarma;
    }
/*
    public ArrayList<AlarmaVO> consultarultimaid() {
        ArrayList<AlarmaVO> consultaultimaID = new ArrayList<>();
        Conexionbd conexion2 = new Conexionbd();
        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("select top 1 *\n"
                    + "  from ALARMA\n"
                    + " order by Id_Alarm desc;");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                Id_Alarm = mensajero.getString("Id_Alarm");

                AlarmaVO ultimoid = new AlarmaVO();
                ultimoid.setId_Alarm(Id_Alarm);

                consultaultimaID.add(ultimoid);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());

        }
        return consultaultimaID;

    }
*/
}
