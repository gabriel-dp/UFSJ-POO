package factory;

import model.*;
import view.EntityPanel;
import controller.EntityController;

public abstract class EntityFactory {

    public static <T> EntityFactory getFactory(Class<T> typeClass) {
        if (typeClass == Vehicle.class) {
            return new VehiclesFactory();
        } else if (typeClass == Procedure.class) {
            return new ProceduresFactory();
        } else if (typeClass == Maintenance.class) {
            return new MaintenancesFactory();
        } else {
            return null;
        }
    }

    public abstract Entity createEntity(int id, Object... args);

    public abstract EntityPanel createPanel();

    public abstract EntityController createController();

}
