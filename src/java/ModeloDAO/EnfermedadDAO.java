package ModeloDAO;

/**
 *
 * @author Cristian Florez
 */

import ModeloVO.EnfermedadVO;
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
public class EnfermedadDAO extends Conexionbd implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    //********************
    private String Id_Enf, Nom_Enf, Sint_Enf, Trat_Enf;

    private boolean operacion = false;

    public EnfermedadDAO(EnfermedadVO enfVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            Id_Enf = enfVO.getId_Enf();
            Nom_Enf = enfVO.getNom_Enf();
            Sint_Enf = enfVO.getSint_Enf();
            Trat_Enf = enfVO.getTrat_Enf();
            

        } catch (Exception e) {
            System.out.println("¡Error!" + e.toString());
        }
    }
    public EnfermedadDAO() {
        
    }
    @Override
    public boolean agregarRegistro() {
        try {
            puente.executeUpdate("call insertar_enfermedad ('"+Id_Enf+"','" + Nom_Enf + "','" + Sint_Enf + "', '" + Trat_Enf + "');");
            operacion = true;
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());

        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            puente.executeUpdate("call  modificar_enfermedad  ('" + Id_Enf + "','" + Nom_Enf + "','" + Sint_Enf + "','" + Trat_Enf + "')");
            operacion = true;
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return operacion;
    }

    public ArrayList<EnfermedadVO> listarEnfermedad() {
        Conexionbd conexionbd = new Conexionbd();
        ArrayList<EnfermedadVO> listaCategoria = new ArrayList<>();
        try {
            puente = conexionbd.obtenerConexion().createStatement();
            mensajero = puente.executeQuery("select * from ENFERMEDAD");

            while (mensajero.next()) {

                EnfermedadVO enfVO = new EnfermedadVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                listaCategoria.add(enfVO);

            }
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return listaCategoria;
    }

    public ArrayList <EnfermedadVO> consultariden (String Identificacion) {
        ArrayList <EnfermedadVO> enfeVO = new ArrayList<>();
        try {
            Conexionbd conexionbd = new Conexionbd();
            Connection conexion = conexionbd.obtenerConexion();
            Statement puente = conexion.createStatement();

            ResultSet mensajero = puente.executeQuery("call CONSULTA_ESPE_ENFERMEDAD ('" + Identificacion + "');");
            while (mensajero.next()) {
                Id_Enf=mensajero.getString("Id_Enf");
                Nom_Enf=mensajero.getString("Nombre_Enf");
                Sint_Enf=mensajero.getString("Sintomas_Enf");
                Trat_Enf=mensajero.getString("Tratamiento_Enf");
                EnfermedadVO enfeVO2= new EnfermedadVO();
                enfeVO2.setId_Enf(Id_Enf);
                enfeVO2.setNom_Enf(Nom_Enf);
                enfeVO2.setSint_Enf(Sint_Enf);
                enfeVO2.setTrat_Enf(Trat_Enf);
                enfeVO.add(enfeVO2);
                
            }
            mensajero.close();
            puente.close();

        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return enfeVO;
    }
    

}

