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
public class ClientContainer {
    
    private int id;
    private String name;
    private String prenume;
    private String telefon;
    private String email;
    private String adresa;
    private String cnp;

    public ClientContainer(int id, String name, String prenume, String telefon, String email, String adresa, String cnp) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
        this.adresa = adresa;
        this.cnp = cnp;
    }

    public ClientContainer(int id, String name, String prenume, String telefon) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
        this.telefon = telefon;
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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
    
    
    
}


