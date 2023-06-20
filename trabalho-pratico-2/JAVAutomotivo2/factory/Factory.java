package factory;

import model.*;

public class Factory<T extends AbstractFactory> {

    public static <T> AbstractFactory getInstance(Class<T> typeClass) {
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

}
