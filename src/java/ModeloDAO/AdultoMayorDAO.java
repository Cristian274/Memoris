package ModeloDAO;
/*
Id_Adult
Nombres_Adult
Apellidos_Adult
Genero_Adult
Fecha_Adult
Foto_Adult
*/
import ModeloVO.AdultoMayorVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Util.Conexionbd;
import Util.InterfaceCRUD;
import java.sql.SQLException;
/* @author Dayanna */
public class AdultoMayorDAO extends Conexionbd implements InterfaceCRUD   {
    
    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
   
    private String Id_Adult = "", Nombres_Adult = "", Apellidos_Adult = "", Genero_Adult = "", Fecha_Adult = "", Foto_Adult = "";
    
    private boolean operacion = false;
    
    public AdultoMayorDAO (AdultoMayorVO aduVO)
    {
     super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            
            Id_Adult = aduVO. getIdAdult();
            Nombres_Adult = aduVO.getNombres_Adult();
            Apellidos_Adult = aduVO.getApellidos_Adult();
            Genero_Adult = aduVO.getGenero_Adult();
            Fecha_Adult = aduVO.getFecha_Adult();
            Foto_Adult = aduVO.getFoto_Adult();
        }
        catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
 
    
    }
    
    public AdultoMayorDAO(){}

    @Override
    public boolean agregarRegistro() {
        try {
            puente.executeUpdate("call insertar_adulto ('"+Id_Adult+"', '"+Nombres_Adult+"', '"+Apellidos_Adult+"','"+Genero_Adult+"', '"+Fecha_Adult+"','"+Foto_Adult+"');");
            operacion=true;
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return operacion;
  }

 
    public boolean actualizarRegistro() {
       
           try {
           
           puente.executeUpdate("call modificar_adulto ('"+Id_Adult+"', '"+Nombres_Adult+"', '"+Apellidos_Adult+"','"+Genero_Adult+"', '"+Fecha_Adult+"','"+Foto_Adult+"');");
            operacion = true;
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.toString());
        }
        return operacion;
    
 }
    

    public ArrayList<AdultoMayorVO> consultarIda (String idam)
    {
      ArrayList  <AdultoMayorVO> adulVO = new ArrayList<>();
        try {
            Conexionbd conexionbd = new Conexionbd();
            Connection conexion = conexionbd.obtenerConexion();
            Statement puente = conexion.createStatement();
            
            
               ResultSet mensajero = puente.executeQuery("call Consulta_Adulto ('"+idam+"'); ");
               while (mensajero.next())
               {
                   Id_Adult=mensajero.getString("Id_Adult");
                   Nombres_Adult=mensajero.getString("Nombres_Adult");
                   Apellidos_Adult=mensajero.getString("Apellidos_Adult");
                   Genero_Adult=mensajero.getString("Genero_Adult");
                   Fecha_Adult=mensajero.getString("Fecha_Nac_Adult");
                   Foto_Adult=mensajero.getString("Foto_Adult");
                   AdultoMayorVO adulVO2=new AdultoMayorVO();
                   adulVO2.setIdAdult(Id_Adult);
                   adulVO2.setNombres_Adult(Nombres_Adult);
                   adulVO2.setApellidos_Adult(Apellidos_Adult);
                   adulVO2.setGenero_Adult(Genero_Adult);
                   adulVO2.setFecha_Adult(Fecha_Adult);
                   adulVO2.setFoto_Adult(Foto_Adult);
                   adulVO.add(adulVO2);
                     }
               mensajero.close();
               puente.close();
        } catch (SQLException e) {
            System.out.println("Error" + e.toString());
        }
    return adulVO;
    }
    public ArrayList <AdultoMayorVO> listaradulto()
    {
        Conexionbd conexionbd = new Conexionbd();
        ArrayList <AdultoMayorVO> listaadulto = new ArrayList();
        
        try {
            puente = conexionbd.obtenerConexion().createStatement();
            mensajero = puente.executeQuery(" call ConsultaGeneralAdulto()");
            while (mensajero.next())
            {
                AdultoMayorVO adulVO = new AdultoMayorVO (mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),mensajero.getString(5), mensajero.getString(6));
                listaadulto.add(adulVO);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    
    return listaadulto;
    }
    
    public ArrayList <AdultoMayorVO> listaradultoidentificacion(String idam)
    {
        Conexionbd conexionbd = new Conexionbd();
        ArrayList <AdultoMayorVO> listaadulto = new ArrayList();
        
        try {
            puente = conexionbd.obtenerConexion().createStatement();
            mensajero = puente.executeQuery("call Consulta_Adulto ('"+idam+"'); ");
            while (mensajero.next())
            {
                AdultoMayorVO adulVO = new AdultoMayorVO (mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),mensajero.getString(5), mensajero.getString(6));
                listaadulto.add(adulVO);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    
    return listaadulto;
    }
}
// falta eliminar//inactivar 