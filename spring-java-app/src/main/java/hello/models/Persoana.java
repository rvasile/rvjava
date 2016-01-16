package hello.models;

public class Persoana {
  private int id;
    private String name;


    public Persoana() {
    }

    public Persoana(int id, String name) {
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
