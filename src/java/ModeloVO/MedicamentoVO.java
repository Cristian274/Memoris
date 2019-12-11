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
public class MedicamentoVO {
    
    String Id_Med, Nomb_Med, Fecha_Venci_Med,Composi_Med,Via_Med, Cant_Med, Dosis_Med, Nom_Lab_Med, Contraindi_Med;

    public MedicamentoVO(String Id_Med, String Nomb_Med, String Fecha_Venci_Med, String Composi_Med, String Via_Med, String Cant_Med, String Dosis_Med, String Nom_Lab_Med, String Contraindi_Med) {
        this.Id_Med = Id_Med;
        this.Nomb_Med = Nomb_Med;
        this.Fecha_Venci_Med = Fecha_Venci_Med;
        this.Composi_Med = Composi_Med;
        this.Via_Med = Via_Med;
        this.Cant_Med = Cant_Med;
        this.Dosis_Med = Dosis_Med;
        this.Nom_Lab_Med = Nom_Lab_Med;
        this.Contraindi_Med = Contraindi_Med;
    }

    public String getId_Med() {
        return Id_Med;
    }

    public void setId_Med(String Id_Med) {
        this.Id_Med = Id_Med;
    }

    public String getNomb_Med() {
        return Nomb_Med;
    }

    public void setNomb_Med(String Nomb_Med) {
        this.Nomb_Med = Nomb_Med;
    }

    public String getFecha_Venci_Med() {
        return Fecha_Venci_Med;
    }

    public void setFecha_Venci_Med(String Fecha_Venci_Med) {
        this.Fecha_Venci_Med = Fecha_Venci_Med;
    }

    public String getComposi_Med() {
        return Composi_Med;
    }

    public void setComposi_Med(String Composi_Med) {
        this.Composi_Med = Composi_Med;
    }

    public String getVia_Med() {
        return Via_Med;
    }

    public void setVia_Med(String Via_Med) {
        this.Via_Med = Via_Med;
    }

    public String getCant_Med() {
        return Cant_Med;
    }

    public void setCant_Med(String Cant_Med) {
        this.Cant_Med = Cant_Med;
    }

    public String getDosis_Med() {
        return Dosis_Med;
    }

    public void setDosis_Med(String Dosis_Med) {
        this.Dosis_Med = Dosis_Med;
    }

    public String getNom_Lab_Med() {
        return Nom_Lab_Med;
    }

    public void setNom_Lab_Med(String Nom_Lab_Med) {
        this.Nom_Lab_Med = Nom_Lab_Med;
    }

    public String getContraindi_Med() {
        return Contraindi_Med;
    }

    public void setContraindi_Med(String Contraindi_Med) {
        this.Contraindi_Med = Contraindi_Med;
    }

    public MedicamentoVO() {
    }

    

}

    