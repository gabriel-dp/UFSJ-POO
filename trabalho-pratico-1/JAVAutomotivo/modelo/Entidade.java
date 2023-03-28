package modelo;

public abstract class Entidade {

    private int id;

    public Entidade(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    abstract public String toString();

}