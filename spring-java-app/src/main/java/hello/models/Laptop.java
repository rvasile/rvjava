package hello.models;

public class Laptop {

    private int id;
    private String denumire;
    private String procesor;




    public Laptop(int id, String denumire,String procesor) {
        this.id = id;
        this.denumire = denumire ;
        this.procesor = procesor ;
    }

    public long getIdLaptop() {
        return id;
    }

    public void setIdLaptop(int id){
        this.id=id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire){
        this.denumire=denumire;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor){
        this.procesor=procesor;
    }

}
