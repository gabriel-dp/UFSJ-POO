package model;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Maintenance extends Entity {

    private Vehicle vehicle;
    private ArrayList<Service> services;

    public Maintenance(int id, Vehicle vehicle, ArrayList<Service> services) {
        super(id);
        this.vehicle = vehicle;
        this.services = services;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.vehicle.toString() + "\n");
        sb.append("Services: [\n");
        for (Service service : this.services) {
            sb.append("  " + service.toString() + "\n");
        }
        sb.append("]");
        return sb.toString();
    }

}
