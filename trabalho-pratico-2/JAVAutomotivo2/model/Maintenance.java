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

    public String getServicesString() {
        StringBuilder sb = new StringBuilder();
        for (Service service : this.services) {
            sb.append(service.getService());
            sb.append(" ");
        }
        return sb.toString();
    }

    public Object[] getData() {
        return new Object[] {
                this.getId(),
                this.getVehicle().getId(),
                this.getServicesString()
        };
    }

}
