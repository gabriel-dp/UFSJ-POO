package controller;

import java.util.ArrayList;

import model.*;
import data.*;

public class MaintenancesController extends EntityController<Maintenance> {

    public Persistent<Maintenance> getPersistent() {
        return Data.getInstance().getMaintenances();
    }

    public Object[][] getTableData() {
        ArrayList<Maintenance> list = getPersistent().getEntities();
        Object[][] tableData = new Object[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            Maintenance Maintenance = list.get(i);
            tableData[i][0] = Maintenance.getId();
            tableData[i][1] = Maintenance.getVehicle().getId();
            tableData[i][2] = Maintenance.getTotalValue();
        }

        return tableData;
    }

    public Vehicle[] getVehiclesArray() {
        ArrayList<Vehicle> vehiclesList = Data.getInstance()
                .getVehicles()
                .getEntities();
        Vehicle[] vehiclesArray = new Vehicle[vehiclesList.size()];
        vehiclesArray = vehiclesList.toArray(vehiclesArray);
        return vehiclesArray;
    }

    public Procedure[] getProceduresArray() {
        ArrayList<Procedure> proceduresList = Data.getInstance()
                .getProcedures()
                .getEntities();
        Procedure[] proceduresArray = new Procedure[proceduresList.size()];
        proceduresArray = proceduresList.toArray(proceduresArray);
        return proceduresArray;
    }

}
