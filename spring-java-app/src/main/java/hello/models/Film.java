package hello;

import java.util.List;
import java.util.ArrayList;

public class Film{
    private int id;
    private String denumire;
    private double rating;

    public Film() {}

    public Film(int id, String denumire, double rating){
      this.id = id;
      this.denumire = denumire;
      this.rating = rating;
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

    public double getRating(){
      return this.rating;
    }

    public void setRating(double rating){
      this.rating = rating;
    }

}
