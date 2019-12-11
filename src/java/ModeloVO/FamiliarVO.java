package ModeloVO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristian Florez
 */
public class FamiliarVO {
      String Id_Fam, Nomb_Fam, Apel_Fam, Paren_Fam, Email_Fam, Fot_Fam, Id_Adult, Id_Usuario;

    public FamiliarVO(String Id_Fam, String Nomb_Fam, String Apel_Fam, String Paren_Fam, String Email_Fam, String Fot_Fam, String Id_Adult, String Id_Usuario) {
        this.Id_Fam = Id_Fam;
        this.Nomb_Fam = Nomb_Fam;
        this.Apel_Fam = Apel_Fam;
        this.Paren_Fam = Paren_Fam;
        this.Email_Fam = Email_Fam;
        this.Fot_Fam = Fot_Fam;
        this.Id_Adult = Id_Adult;
        this.Id_Usuario = Id_Usuario;
    }

    public String getId_Fam() {
        return Id_Fam;
    }

    public void setId_Fam(String Id_Fam) {
        this.Id_Fam = Id_Fam;
    }

    public String getNomb_Fam() {
        return Nomb_Fam;
    }

    public void setNomb_Fam(String Nomb_Fam) {
        this.Nomb_Fam = Nomb_Fam;
    }

    public String getApel_Fam() {
        return Apel_Fam;
    }

    public void setApel_Fam(String Apel_Fam) {
        this.Apel_Fam = Apel_Fam;
    }

    public String getParen_Fam() {
        return Paren_Fam;
    }

    public void setParen_Fam(String Paren_Fam) {
        this.Paren_Fam = Paren_Fam;
    }

    public String getEmail_Fam() {
        return Email_Fam;
    }

    public void setEmail_Fam(String Email_Fam) {
        this.Email_Fam = Email_Fam;
    }

    public String getFot_Fam() {
        return Fot_Fam;
    }

    public void setFot_Fam(String Fot_Fam) {
        this.Fot_Fam = Fot_Fam;
    }

    public String getId_Adult() {
        return Id_Adult;
    }

    public void setId_Adult(String Id_Adult) {
        this.Id_Adult = Id_Adult;
    }

    public String getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(String Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public FamiliarVO() {
    }

 
    
   
      
}

