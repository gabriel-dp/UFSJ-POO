package model;

public class Procedure extends Entity {

    private String procedureName;
    private double value;

    public Procedure(int id, String procedureName, double value) {
        super(id);
        this.procedureName = procedureName;
        this.value = value;
    }

    public String getProcedureName() {
        return this.procedureName;
    }

    public double getValue() {
        return this.value;
    }

    public Object[] getData() {
        return new Object[] {
                this.getId(),
                this.getProcedureName(),
                this.getValue(),
        };
    }

}
