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
public class EnfermedadVO {
   String Id_Enf, Nom_Enf, Sint_Enf, Trat_Enf;

    public String getId_Enf() {
        return Id_Enf;
    }

    public void setId_Enf(String Id_Enf) {
        this.Id_Enf = Id_Enf;
    }

    public String getNom_Enf() {
        return Nom_Enf;
    }

    public void setNom_Enf(String Nom_Enf) {
        this.Nom_Enf = Nom_Enf;
    }

    public String getSint_Enf() {
        return Sint_Enf;
    }

    public void setSint_Enf(String Sint_Enf) {
        this.Sint_Enf = Sint_Enf;
    }

    public String getTrat_Enf() {
        return Trat_Enf;
    }

    public void setTrat_Enf(String Trat_Enf) {
        this.Trat_Enf = Trat_Enf;
    }

    public EnfermedadVO(String Id_Enf, String Nom_Enf, String Sint_Enf, String Trat_Enf) {
        this.Id_Enf = Id_Enf;
        this.Nom_Enf = Nom_Enf;
        this.Sint_Enf = Sint_Enf;
        this.Trat_Enf = Trat_Enf;
    }

    public EnfermedadVO() {
    }

    
}
