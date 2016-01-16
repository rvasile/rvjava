package hello;

import java.util.List;
import java.util.ArrayList;

public class Carte{
    private int id;
    private String denumire;
    private double pret;

    public Carte() {}

    public Carte(int id, String denumire, double pret){
      this.id = id;
      this.denumire = denumire;
      this.pret = pret;
    }

    public int getId(){
      return this.id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getDenumire(){
      return this.denumire;
    }

    public void setDenumire(String denumire){
      this.denumire = denumire;
    }

    public double getPret(){
      return this.pret;
    }

    public void setPret(double pret){
      this.pret = pret;
    }

}
