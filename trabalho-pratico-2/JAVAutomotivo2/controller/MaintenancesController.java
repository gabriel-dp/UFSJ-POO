package controller;

import java.util.ArrayList;

import model.Entity;
import model.Maintenance;
import model.Service;
import data.Data;
import data.Persistent;

public class MaintenancesController implements Controller {

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

}
