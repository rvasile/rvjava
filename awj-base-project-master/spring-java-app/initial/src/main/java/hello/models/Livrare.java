package hello.models;

public class Livrare {

    private int id_livrare;
    private double pret;
    private String nume_client;

    public Livrare(int id_livrare,double pret, String nume_client) {
        this.id_livrare = id_livrare;
        this.pret = pret;
        this.nume_client = nume_client;
    }

    public int getIdLivrare() {
        return id_livrare;
    }

    public void setIdLivrare(int id_livrare){
        this.id_livrare=id_livrare;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret){
        this.pret=pret;
    }

    public String getNumeClient() {
        return nume_client;
    }

    public void setNumeClient(String nume_client){
        this.nume_client=nume_client;
    }

}
