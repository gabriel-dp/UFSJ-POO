package model;

import java.util.ArrayList;

public class Maintenance extends Entity {

    private Vehicle vehicle;
    private ArrayList<Service> services;

    public Maintenance(int id, Vehicle vehicle, ArrayList<Service> services) {
        super(id);
        this.vehicle = vehicle;
        this.services = services;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public ArrayList<Service> getServices() {
        return this.services;
    }

    public double getTotalValue() {
        double total = 0;
        for (Service service : getServices()) {
            total += service.getProcedure().getValue() * service.getQuantity();
        }
        return total;
    }

}
