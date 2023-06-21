package factory;

import view.*;
import controller.*;
import model.*;

import java.util.ArrayList;

public class MaintenancesFactory extends EntityFactory<Maintenance> {

    @SuppressWarnings("unchecked") // Supress ArrayList casting warning
    public Maintenance createEntity(int id, Object... args) {
        return new Maintenance(id, (Vehicle) args[0], (ArrayList<Service>) args[1]);
    }

    public EntityPanel<Maintenance> createPanel() {
        return new MaintenancesPanel();
    }

    public EntityController<Maintenance> createController() {
        return new MaintenancesController();
    }

}
