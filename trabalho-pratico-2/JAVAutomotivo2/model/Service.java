package model;

public class Service {

    private Procedure procedure;
    private int quantity;

    public Service(Procedure procedure, int quantity) {
        this.procedure = procedure;
        this.quantity = quantity;
    }

    public String toString() {
        return String.format("Procedure = { %s } | Quantity = %d", this.procedure.toString(),
                this.quantity);
    }

}
