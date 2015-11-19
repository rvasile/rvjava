package hello;

public class Persoana {

    private final int id;
    private final String nume;
    private final String localitate;

    public Persoana(int id, String nume,String localitate) {
        this.id = id;
        this.nume = nume ;
        this.localitate=localitate;
    }

    public long getId() {
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume){
        this.nume=nume;
    }

    public String getLocalitate() {
        return localitate ;
    }

    public void setLocalitate(String localitate){
        this.localitate=localitate;
    }


}
