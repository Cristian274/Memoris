/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Juan David
 */
public class ReporteVO {
    String Id_Reporte,Fecha_Reporte,Comportamiento,Id_Adult;

    public ReporteVO(String Id_Reporte, String Fecha_Reporte, String Comportamiento, String Id_Adult) {
        this.Id_Reporte = Id_Reporte;
        this.Fecha_Reporte = Fecha_Reporte;
        this.Comportamiento = Comportamiento;
        this.Id_Adult = Id_Adult;
    }

    public String getId_Reporte() {
        return Id_Reporte;
    }

    public void setId_Reporte(String Id_Reporte) {
        this.Id_Reporte = Id_Reporte;
    }

    public String getFecha_Reporte() {
        return Fecha_Reporte;
    }

    public void setFecha_Reporte(String Fecha_Reporte) {
        this.Fecha_Reporte = Fecha_Reporte;
    }

    public String getComportamiento() {
        return Comportamiento;
    }

    public void setComportamiento(String Comportamiento) {
        this.Comportamiento = Comportamiento;
    }

    public String getId_Adult() {
        return Id_Adult;
    }

    public void setId_Adult(String Id_Adult) {
        this.Id_Adult = Id_Adult;
    }

    public ReporteVO() {
    }
    
    
}
