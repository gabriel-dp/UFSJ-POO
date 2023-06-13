package controller;

import java.util.ArrayList;

import model.*;
import data.*;

public class MaintenancesController extends EntityController {

    public Persistent getPersistent() {
        return Data.getInstance().getMaintenances();
    }

    public Object[][] getTableData() {
        ArrayList<Entity> list = Data.getInstance().getMaintenances().getEntities();
        Object[][] tableData = new Object[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            Maintenance Maintenance = (Maintenance) list.get(i);
            tableData[i][0] = Maintenance.getId();
            tableData[i][1] = Maintenance.getVehicle().getId();

            double total = 0;
            for (Service service : Maintenance.getServices()) {
                total += service.getProcedure().getValue() * service.getQuantity();
            }
            tableData[i][2] = total;
        }

        return tableData;
    }

    public Vehicle[] getVehiclesArray() {
        ArrayList<Entity> vehiclesList = Data.getInstance()
                .getVehicles()
                .getEntities();
        Vehicle[] vehiclesArray = new Vehicle[vehiclesList.size()];
        vehiclesArray = vehiclesList.toArray(vehiclesArray);
        return vehiclesArray;
    }

    public Procedure[] getProceduresArray() {
        ArrayList<Entity> proceduresList = Data.getInstance()
                .getProcedures()
                .getEntities();
        Procedure[] proceduresArray = new Procedure[proceduresList.size()];
        proceduresArray = proceduresList.toArray(proceduresArray);
        return proceduresArray;
    }

}
