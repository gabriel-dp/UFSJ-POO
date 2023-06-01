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

    public String toString() {
        return String.format("Model = %s | Plate = %s | Client = %s", this.model, this.plate, this.client);
    }

}
