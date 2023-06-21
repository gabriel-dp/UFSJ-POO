package factory;

import view.*;
import controller.*;
import model.Vehicle;

public class VehiclesFactory extends EntityFactory<Vehicle> {

    public Vehicle createEntity(int id, Object... args) {
        return new Vehicle(id, (String) args[0], (String) args[1], (String) args[2]);
    }

    public EntityPanel<Vehicle> createPanel() {
        return new VehiclesPanel();
    }

    public EntityController<Vehicle> createController() {
        return new VehiclesController();
    }

}
