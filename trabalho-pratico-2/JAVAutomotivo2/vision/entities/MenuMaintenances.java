package vision.entities;

import java.util.ArrayList;

import controller.*;
import model.*;

public class MenuMaintenances extends MenuEntity {

    private Persistent maintenances;
    private Persistent vehicles;
    private Persistent procedures;

    public MenuMaintenances(Persistent maintenances, Persistent vehicles, Persistent procedures) {
        super("Maintenances");
        this.maintenances = maintenances;
        this.vehicles = vehicles;
        this.procedures = procedures;
    }

    private ArrayList<Service> createServices() {
        ArrayList<Service> newServices = new ArrayList<Service>();

        do {
            try {
                System.out.print("Procedure Id: ");
                int idProcedimento = this.getId();
                Procedure procedure = (Procedure) this.procedures.searchId(idProcedimento);

                System.out.print("Quantity: ");
                int quantity = this.getInteger();

                newServices.add(new Service(procedure, quantity));
            } catch (IdException error) {
                System.out.println(error.getMessage());
                break;
            }
        } while (true);

        return newServices;
    }

    private Vehicle getVehicle() {
        try {
            System.out.print("Vehicle Id: ");
            return ((Vehicle) this.vehicles.searchId(this.getId()));
        } catch (IdException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    protected void insertEntity() {
        System.out.println("Add Maintenance");

        int maintenanceId = this.getId();
        try {
            this.maintenances.searchId(maintenanceId);
            System.out.println("\nId already exists");
        } catch (IdException _error) {
            Vehicle veiculo = this.getVehicle();
            if (veiculo == null)
                return;
            ArrayList<Service> servicos = this.createServices();
            if (servicos.size() == 0)
                return;

            Maintenance newMaintenance = new Maintenance(maintenanceId, veiculo, servicos);
            this.maintenances.insert(newMaintenance);
            System.out.println("\nMaintenance added successfully");
        }
    }

    protected void modifyEntity() {
        System.out.println("Modify Maintenance data");

        int id = this.getId();
        try {
            Entity oldMaintenance = this.maintenances.searchId(id);

            Vehicle newVehicle = this.getVehicle();
            if (newVehicle == null)
                return;
            ArrayList<Service> newServices = this.createServices();
            if (newServices.size() == 0)
                return;

            Maintenance newMaintenance = new Maintenance(id, newVehicle, newServices);
            this.maintenances.modify(oldMaintenance, newMaintenance);

            System.out.println("\nMaintenance modified successfully");
        } catch (IdException error) {
            System.out.println(error.getMessage());
        }
    }

    protected void removeEntity() {
        System.out.println("Remove Maintenance");

        int id = this.getId();
        try {
            Entity maintenance = this.maintenances.searchId(id);
            this.maintenances.remove(maintenance);
            System.out.println("\nMaintenance removed successfully");
        } catch (IdException error) {
            System.out.println(error.getMessage());
        }
    }

    protected void searchIdEntity() {
        System.out.println("Search Maintenance by Id");

        int id = this.getId();
        try {
            Entity maintenance = this.maintenances.searchId(id);
            System.out.println(maintenance.toString());
        } catch (IdException error) {
            System.out.println(error.getMessage());
        }
    }

    protected void seeAllEntity() {
        System.out.print(this.maintenances.toString());
    }

}
