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
public class AnimalContainer {
    private int id;
    private String name;
    private int rasa;
    private char sex;
    private String culoare;
    private String dateofbirth;
    private String microchip;
    private float greutate;
    private int numeStapan;
    private byte[] photo;

    public AnimalContainer(int id, String name, float greutate, String dateofbirth, String microchip,byte[] photo) {
        this.id = id;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.greutate = greutate;
        this.microchip = microchip;
        this.photo = photo;
    }

    public AnimalContainer(int id, String name, int rasa, char sex, String culoare, String dateofbirth, String microchip, float greutate, int numeStapan, byte[] photo) {
        this.id = id;
        this.name = name;
        this.rasa = rasa;
        this.sex = sex;
        this.culoare = culoare;
        this.dateofbirth = dateofbirth;
        this.microchip = microchip;
        this.greutate = greutate;
        this.numeStapan = numeStapan;
        this.photo = photo;
    }

    AnimalContainer(int aInt, String string, byte[] bytes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public int getRasa() {
        return rasa;
    }

    public void setRasa(int rasa) {
        this.rasa = rasa;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public float getGreutate() {
        return greutate;
    }

    public void setGreutate(float greutate) {
        this.greutate = greutate;
    }

    public int getNumeStapan() {
        return numeStapan;
    }

    public void setNumeStapan(int numeStapan) {
        this.numeStapan = numeStapan;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
    
    
}
