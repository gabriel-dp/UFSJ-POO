package data;

import model.*;

/*
 * Singleton Design Pattern - Eager Initialization
 * Controls Data instance to have only one Data
 */

public class Data {

    private static final Data data = new Data();

    private Persistent<Vehicle> vehicles = new Persistent<>();
    private Persistent<Procedure> procedures = new Persistent<>();
    private Persistent<Maintenance> maintenances = new Persistent<>();

    public static Data getInstance() {
        return data;
    }

    public Persistent<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public Persistent<Procedure> getProcedures() {
        return this.procedures;
    }

    public Persistent<Maintenance> getMaintenances() {
        return this.maintenances;
    }

}
