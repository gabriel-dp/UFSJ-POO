package model;

public class Vehicle extends Entity {

    private String model;
    private String plate;
    private String client;

    public Vehicle(int id, String model, String plate, String client) {
        super(id);
        this.model = model;
        this.plate = plate;
        this.client = client;
    }

    public String getModel() {
        return this.model;
    }

    public String getPlate() {
        return this.plate;
    }

    public String getClient() {
        return this.client;
    }

    public String toString() {
        return String.format("%d | %s | %s | %s", getId(), getModel(), getPlate(), getClient());
    }
}
