package data;

/*
 * Singleton Design Pattern - Eager Initialization
 * Controls Data instance to have only one Data
 */

public class Data {

    private static final Data data = new Data();

    private Persistent vehicles;
    private Persistent procedures;
    private Persistent maintenances;

    private Data() {
        this.vehicles = new Persistent();
        this.procedures = new Persistent();
        this.maintenances = new Persistent();
    }

    public static Data getInstance() {
        return data;
    }

    public Persistent getVehicles() {
        return this.vehicles;
    }

    public Persistent getProcedures() {
        return this.procedures;
    }

    public Persistent getMaintenances() {
        return this.maintenances;
    }

}
