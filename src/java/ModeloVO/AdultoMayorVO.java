package ModeloVO;
/*
Id_Adult
Nombres_Adult
Apellidos_Adult
Genero_Adult
Fecha_Adult
Foto_Adult
*/
/* @author Dayanna */
public class AdultoMayorVO {
    
    String IdAdult, Nombres_Adult, Apellidos_Adult, Genero_Adult, Fecha_Adult, Foto_Adult;

    public AdultoMayorVO(String IdAdult, String Nombres_Adult, String Apellidos_Adult, String Genero_Adult, String Fecha_Adult, String Foto_Adult) {
        this.IdAdult = IdAdult;
        this.Nombres_Adult = Nombres_Adult;
        this.Apellidos_Adult = Apellidos_Adult;
        this.Genero_Adult = Genero_Adult;
        this.Fecha_Adult = Fecha_Adult;
        this.Foto_Adult = Foto_Adult;
    }

    public String getIdAdult() {
        return IdAdult;
    }

    public void setIdAdult(String IdAdult) {
        this.IdAdult = IdAdult;
    }

    public String getNombres_Adult() {
        return Nombres_Adult;
    }

    public void setNombres_Adult(String Nombres_Adult) {
        this.Nombres_Adult = Nombres_Adult;
    }

    public String getApellidos_Adult() {
        return Apellidos_Adult;
    }

    public void setApellidos_Adult(String Apellidos_Adult) {
        this.Apellidos_Adult = Apellidos_Adult;
    }

    public String getGenero_Adult() {
        return Genero_Adult;
    }

    public void setGenero_Adult(String Genero_Adult) {
        this.Genero_Adult = Genero_Adult;
    }

    public String getFecha_Adult() {
        return Fecha_Adult;
    }

    public void setFecha_Adult(String Fecha_Adult) {
        this.Fecha_Adult = Fecha_Adult;
    }

    public String getFoto_Adult() {
        return Foto_Adult;
    }

    public void setFoto_Adult(String Foto_Adult) {
        this.Foto_Adult = Foto_Adult;
    }

    public AdultoMayorVO() {
    }

   
    
    
            
}
