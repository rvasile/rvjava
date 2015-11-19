package hello;

public class Tableta {

    private final int id_tableta;
    private final String producator;
    private final String model;

    public Tableta(int id_tableta, String producator,String model) {
        this.id_tableta = id_tableta;
        this.producator = producator;
        this.model = model ;
    }

    public long getIdTableta() {
        return id_tableta;
    }

    public void setIdTableta(int id_tableta){
        this.id_tableta=id_tableta;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator){
        this.producator=producator;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model){
        this.model=model;
    }
}