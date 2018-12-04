package ba.unsa.rpr.tutorijal7;

import java.io.Serializable;

public class Grad implements Serializable {
    private String naziv;
    private int brojStanovnika;
    private double[] temperature = new double[1000];


    public Grad() {

    }

    public Grad(String naziv,double[] temperature,int brojStanovnika ) {
        this.naziv=naziv;
        this.brojStanovnika = brojStanovnika;
        this.temperature=temperature;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }
}
