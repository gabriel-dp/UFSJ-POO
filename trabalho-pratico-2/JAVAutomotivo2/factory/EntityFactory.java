package factory;

import model.*;
import view.EntityPanel;
import controller.EntityController;

public abstract class EntityFactory<T extends Entity> {

    @SuppressWarnings("unchecked")
    public static <E extends Entity> EntityFactory<E> getFactory(Class<E> typeClass) {
        if (typeClass == Vehicle.class) {
            return (EntityFactory<E>) new VehiclesFactory();
        } else if (typeClass == Procedure.class) {
            return (EntityFactory<E>) new ProceduresFactory();
        } else if (typeClass == Maintenance.class) {
            return (EntityFactory<E>) new MaintenancesFactory();
        } else {
            return null;
        }
    }

    public abstract T createEntity(int id, Object... args);

    public abstract EntityPanel<T> createPanel();

    public abstract EntityController<T> createController();

}
