package model;

public class Service {

    private Procedure procedure;
    private int quantity;

    public Service(Procedure procedure, int quantity) {
        this.procedure = procedure;
        this.quantity = quantity;
    }

    public Procedure getProcedure() {
        return this.procedure;
    }

    public int getQuantity() {
        return this.quantity;
    }

}
