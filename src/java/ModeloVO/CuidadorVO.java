/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Cristian Florez
 */
public class CuidadorVO {
    
    String Id_Cuid, Nomb_Cuid, Apel_Cuid, Email_Cuid, Telefono_Cuid, Foto_Cuid, Id_usuario;

    public String getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(String Id_usuario) {
        this.Id_usuario = Id_usuario;
    }

    public String getId_Cuid() {
        return Id_Cuid;
    }

    public void setId_Cuid(String Id_Cuid) {
        this.Id_Cuid = Id_Cuid;
    }

    public String getNomb_Cuid() {
        return Nomb_Cuid;
    }

    public void setNomb_Cuid(String Nomb_Cuid) {
        this.Nomb_Cuid = Nomb_Cuid;
    }

    public String getApel_Cuid() {
        return Apel_Cuid;
    }

    public void setApel_Cuid(String Apel_Cuid) {
        this.Apel_Cuid = Apel_Cuid;
    }

    public String getEmail_Cuid() {
        return Email_Cuid;
    }

    public void setEmail_Cuid(String Email_Cuid) {
        this.Email_Cuid = Email_Cuid;
    }

    public String getTelefono_Cuid() {
        return Telefono_Cuid;
    }

    public void setTelefono_Cuid(String Telefono_Cuid) {
        this.Telefono_Cuid = Telefono_Cuid;
    }

    public String getFoto_Cuid() {
        return Foto_Cuid;
    }

    public void setFoto_Cuid(String Foto_Cuid) {
        this.Foto_Cuid = Foto_Cuid;
    }

    public CuidadorVO(String Id_Cuid, String Nomb_Cuid, String Apel_Cuid, String Email_Cuid, String Telefono_Cuid, String Foto_Cuid, String Id_Usuario) {
        this.Id_Cuid = Id_Cuid;
        this.Nomb_Cuid = Nomb_Cuid;
        this.Apel_Cuid = Apel_Cuid;
        this.Email_Cuid = Email_Cuid;
        this.Telefono_Cuid = Telefono_Cuid;
        this.Foto_Cuid = Foto_Cuid;
        this.Id_usuario=Id_Usuario;
    }

    public CuidadorVO() {
    }

   
    
}
