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
public class RecetaVO {
    
    String Id_Rec, nommed_recmed,viaadmin_recmed,dosis_recmed, Fecha_Rec, cantidad_h_recmed, Id_enf,Id_Adult;

    public RecetaVO(String Id_Rec, String nommed_recmed, String viaadmin_recmed, String dosis_recmed, String Fecha_Rec, String cantidad_h_recmed, String Id_enf, String Id_Adult) {
        this.Id_Rec = Id_Rec;
        this.nommed_recmed = nommed_recmed;
        this.viaadmin_recmed = viaadmin_recmed;
        this.dosis_recmed = dosis_recmed;
        this.Fecha_Rec = Fecha_Rec;
        this.cantidad_h_recmed = cantidad_h_recmed;
        this.Id_enf = Id_enf;
        this.Id_Adult = Id_Adult;
    }

    public String getId_Rec() {
        return Id_Rec;
    }

    public void setId_Rec(String Id_Rec) {
        this.Id_Rec = Id_Rec;
    }

    public String getNommed_recmed() {
        return nommed_recmed;
    }

    public void setNommed_recmed(String nommed_recmed) {
        this.nommed_recmed = nommed_recmed;
    }

    public String getViaadmin_recmed() {
        return viaadmin_recmed;
    }

    public void setViaadmin_recmed(String viaadmin_recmed) {
        this.viaadmin_recmed = viaadmin_recmed;
    }

    public String getDosis_recmed() {
        return dosis_recmed;
    }

    public void setDosis_recmed(String dosis_recmed) {
        this.dosis_recmed = dosis_recmed;
    }

    public String getFecha_Rec() {
        return Fecha_Rec;
    }

    public void setFecha_Rec(String Fecha_Rec) {
        this.Fecha_Rec = Fecha_Rec;
    }

    public String getCantidad_h_recmed() {
        return cantidad_h_recmed;
    }

    public void setCantidad_h_recmed(String cantidad_h_recmed) {
        this.cantidad_h_recmed = cantidad_h_recmed;
    }

    public String getId_enf() {
        return Id_enf;
    }

    public void setId_enf(String Id_enf) {
        this.Id_enf = Id_enf;
    }

    public String getId_Adult() {
        return Id_Adult;
    }

    public void setId_Adult(String Id_Adult) {
        this.Id_Adult = Id_Adult;
    }

    public RecetaVO() {
    }
    

}