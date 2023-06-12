package controller;

public class IdException extends Exception {

    private int id;

    public IdException(int id) {
        super(String.format("Id not found (%d)", id));
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

}
