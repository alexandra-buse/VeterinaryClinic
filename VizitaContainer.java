/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cabinet_veterinar_app;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author alexa
 */
public class VizitaContainer {
    private int id;
    private int pacient;
    private int doctor;
    private int procedura;
    private float pret;
    private String dataprog;

    public VizitaContainer(int id, int pacient, int doctor, int procedura, float pret, String dataprog) {
        this.id = id;
        this.pacient = pacient;
        this.doctor = doctor;
        this.procedura = procedura;
        this.pret = pret;
        this.dataprog = dataprog;
    }

    public VizitaContainer(int id, int pacient, int doctor) {
        this.id = id;
        this.pacient = pacient;
        this.doctor = doctor;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPacient() {
        //String qry="select Nume from Animal where IdAnimal = '" + pacient + "'";
        //Statement st=conn.createStatement();
        //ResultSet rs=st.executeQuery(qry);
        //return rs.getString("Nume");
        return pacient;
    }

    public void setPacient(int pacient) {
        this.pacient = pacient;
    }

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public int getProcedura() {
        return procedura;
    }

    public void setProcedura(int procedura) {
        this.procedura = procedura;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getDataprog() {
        return dataprog;
    }

    public void setDataprog(String dataprog) {
        this.dataprog = dataprog;
    }
    
    
    
    
}
