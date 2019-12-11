package ModeloVO;
public class UsuarioVO {
    String Id_usu, Nom_usu, Cont_Usu,nombrecomple;
    String rol;

    public UsuarioVO(String Id_usu, String Nom_usu, String Cont_Usu,String rol,String nombrecomple) {
        this.Id_usu = Id_usu;
        this.Nom_usu = Nom_usu;
        this.Cont_Usu = Cont_Usu;
        this.nombrecomple=nombrecomple;
       
        this.rol=rol;
    }

    public String getNombrecomple() {
        return nombrecomple;
    }

    public void setNombrecomple(String nombrecomple) {
        this.nombrecomple = nombrecomple;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getId_usu() {
        return Id_usu;
    }

    public void setId_usu(String Id_usu) {
        this.Id_usu = Id_usu;
    }

    public String getNom_usu() {
        return Nom_usu;
    }

    public void setNom_usu(String Nom_usu) {
        this.Nom_usu = Nom_usu;
    }

    public String getCont_Usu() {
        return Cont_Usu;
    }

    public void setCont_Usu(String Cont_Usu) {
        this.Cont_Usu = Cont_Usu;
    }


    public UsuarioVO() {
    }

    
    
    
   
    
}
