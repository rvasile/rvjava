package hello;

public class Laptop {

    private final int id_laptop;
    private final String denumire;
    private final String procesor;



    public Laptop(int id_laptop, String denumire,String procesor) {
        this.id_laptop = id_laptop;
        this.denumire = denumire ;
        this.procesor = procesor ;
    }

    public long getIdLaptop() {
        return id_laptop;
    }

    public void setIdLaptop(int id_laptop){
        this.id_laptop=id_laptop;
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
