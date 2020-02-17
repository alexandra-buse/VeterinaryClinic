/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cabinet_veterinar_app;

/**
 *
 * @author alexa
 */
public class AngajatContainer {
    private int id;
    private String name;
    private String prenume;
    private String telefon;
    private String email;
    private String adresa;
    private String dataangajare;
    private String cnp;
    private float salariu;
    private byte[] photo;

    public AngajatContainer(int id, String name, String prenume, String telefon, String email, String adresa, String dataangajare, String cnp, float salariu, byte[] photo) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
        this.adresa = adresa;
        this.dataangajare = dataangajare;
        this.cnp = cnp;
        this.salariu = salariu;
        this.photo = photo;
    }

    public AngajatContainer(int id, String name, String prenume, String telefon, byte[] photo) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
        this.telefon = telefon;
        this.photo = photo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getDataangajare() {
        return dataangajare;
    }

    public void setDataangajare(String dataangajare) {
        this.dataangajare = dataangajare;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public float getSalariu() {
        return salariu;
    }

    public void setSalariu(float salariu) {
        this.salariu = salariu;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
    
    
    
}
