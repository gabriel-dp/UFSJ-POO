package control;

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

    public static Data createData() {
        return data;
    }

    public Persistent getVehicles() {
        return this.vehicles;
    }

    public Persistent getProcedure() {
        return this.procedures;
    }

    public Persistent getMaintenance() {
        return this.maintenances;
    }

}
