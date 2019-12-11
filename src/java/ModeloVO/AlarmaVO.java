
package ModeloVO;

/* @author Dayanna */
public class AlarmaVO {
    
    String Id_Alarm, Via_Adminis_Alarm, Cantidad_Alarm, Dosis_Medica_Alarm, Frecuencia_Medica_Alarm, Fecha_Inicio_Alarm, Fecha_Final_Alarm, Id_Cuidador, Id_Medicamento;

    public AlarmaVO(String Id_Alarm, String Via_Adminis_Alarm, String Cantidad_Alarm, String Dosis_Medica_Alarm, String Frecuencia_Medica_Alarm, String Fecha_Inicio_Alarm, String Fecha_Final_Alarm, String Id_Cuidador, String Id_Medicamento) {
        this.Id_Alarm = Id_Alarm;
        this.Via_Adminis_Alarm = Via_Adminis_Alarm;
        this.Cantidad_Alarm = Cantidad_Alarm;
        this.Dosis_Medica_Alarm = Dosis_Medica_Alarm;
        this.Frecuencia_Medica_Alarm = Frecuencia_Medica_Alarm;
        this.Fecha_Inicio_Alarm = Fecha_Inicio_Alarm;
        this.Fecha_Final_Alarm = Fecha_Final_Alarm;
        this.Id_Cuidador = Id_Cuidador;
        this.Id_Medicamento = Id_Medicamento;
     
    }

    public String getId_Alarm() {
        return Id_Alarm;
    }

    public void setId_Alarm(String Id_Alarm) {
        this.Id_Alarm = Id_Alarm;
    }

    public String getVia_Adminis_Alarm() {
        return Via_Adminis_Alarm;
    }

    public void setVia_Adminis_Alarm(String Via_Adminis_Alarm) {
        this.Via_Adminis_Alarm = Via_Adminis_Alarm;
    }

    public String getCantidad_Alarm() {
        return Cantidad_Alarm;
    }

    public void setCantidad_Alarm(String Cantidad_Alarm) {
        this.Cantidad_Alarm = Cantidad_Alarm;
    }

    public String getDosis_Medica_Alarm() {
        return Dosis_Medica_Alarm;
    }

    public void setDosis_Medica_Alarm(String Dosis_Medica_Alarm) {
        this.Dosis_Medica_Alarm = Dosis_Medica_Alarm;
    }

    public String getFrecuencia_Medica_Alarm() {
        return Frecuencia_Medica_Alarm;
    }

    public void setFrecuencia_Medica_Alarm(String Frecuencia_Medica_Alarm) {
        this.Frecuencia_Medica_Alarm = Frecuencia_Medica_Alarm;
    }

    public String getFecha_Inicio_Alarm() {
        return Fecha_Inicio_Alarm;
    }

    public void setFecha_Inicio_Alarm(String Fecha_Inicio_Alarm) {
        this.Fecha_Inicio_Alarm = Fecha_Inicio_Alarm;
    }

    public String getFecha_Final_Alarm() {
        return Fecha_Final_Alarm;
    }

    public void setFecha_Final_Alarm(String Fecha_Final_Alarm) {
        this.Fecha_Final_Alarm = Fecha_Final_Alarm;
    }

    public String getId_Cuidador() {
        return Id_Cuidador;
    }

    public void setId_Cuidador(String Id_Cuidador) {
        this.Id_Cuidador = Id_Cuidador;
    }

    public String getId_Medicamento() {
        return Id_Medicamento;
    }

    public void setId_Medicamento(String Id_Medicamento) {
        this.Id_Medicamento = Id_Medicamento;
    }

    public AlarmaVO() {
    }
    
}