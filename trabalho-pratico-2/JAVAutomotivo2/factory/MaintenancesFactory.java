package factory;

import model.*;
import view.*;
import controller.*;

import java.util.ArrayList;

public class MaintenancesFactory extends EntityFactory {

    @SuppressWarnings("unchecked") // Supress ArrayList casting warning
    public Entity createEntity(int id, Object... args) {
        return new Maintenance(id, (Vehicle) args[0], (ArrayList<Service>) args[1]);
    }

    public EntityPanel createPanel() {
        return new MaintenancesPanel();
    }

    public EntityController createController() {
        return new MaintenancesController();
    }

}
