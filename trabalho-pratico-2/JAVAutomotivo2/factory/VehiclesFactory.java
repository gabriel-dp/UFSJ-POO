package factory;

import model.*;
import view.*;
import controller.*;

public class VehiclesFactory extends AbstractFactory {

    public Entity createEntity(int id, Object... args) {
        return new Vehicle(id, (String) args[0], (String) args[1], (String) args[2]);
    }

    public EntityPanel createPanel() {
        return new VehiclesPanel();
    }

    public EntityController createController() {
        return new VehiclesController();
    }

}
