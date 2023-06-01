package model;

public class Procedure extends Entity {

    private String procedureName;
    private double value;

    public Procedure(int id, String procedureName, double value) {
        super(id);
        this.procedureName = procedureName;
        this.value = value;
    }

    public String toString() {
        return String.format("Name = %s | Value = %.2f", this.procedureName, this.value);
    }

}
