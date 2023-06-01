package vision.entities;

import control.*;
import model.*;

public class MenuVehicles extends MenuEntity {

    private Persistent vehicles;

    public MenuVehicles(Persistent vehicles) {
        super("Vehicle");
        this.vehicles = vehicles;
    }

    private Vehicle getVehicle(int id) {
        System.out.print("Model: ");
        String model = scan.nextLine();
        System.out.print("Plate: ");
        String plate = scan.nextLine();
        System.out.print("Client: ");
        String client = scan.nextLine();

        return new Vehicle(id, model, plate, client);
    }

    protected void insertEntity() {
        System.out.println("Add Vehicle");

        int id = this.getId();
        try {
            vehicles.searchId(id);
            System.out.println("\nId already exists");
        } catch (IdException _error) {
            Vehicle newVehicle = this.getVehicle(id);
            this.vehicles.insert(newVehicle);
            System.out.println("\nVehiculo added successfully");
        }
    }

    protected void modifyEntity() {
        System.out.println("Modify Vehicle data");

        int id = this.getId();
        try {
            Entity oldVehicle = this.vehicles.searchId(id);
            Vehicle newVehicle = this.getVehicle(id);
            this.vehicles.modify(oldVehicle, newVehicle);
            System.out.println("\nVehicle modified successfully");
        } catch (IdException error) {
            System.out.println(error.getMessage());
        }
    }

    protected void removeEntity() {
        System.out.println("Remove Vehicle");

        int id = this.getId();
        try {
            Entity vehicle = this.vehicles.searchId(id);
            this.vehicles.remove(vehicle);
            System.out.println("\nVeículo removed successfully");
        } catch (IdException erro) {
            System.out.println(erro.getMessage());
        }
    }

    protected void searchIdEntity() {
        System.out.println("Search Vehicle by Id");

        int id = this.getId();
        try {
            Entity vehicle = this.vehicles.searchId(id);
            System.out.println(vehicle.toString());
        } catch (IdException error) {
            System.out.println(error.getMessage());
        }
    }

    protected void seeAllEntity() {
        System.out.println(this.vehicles.toString());
    }

}
