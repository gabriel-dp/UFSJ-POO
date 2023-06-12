package controller;

import java.util.ArrayList;

import data.Data;
import data.Persistent;
import model.Entity;
import model.Vehicle;

public class VehiclesController implements Controller {

    public Persistent getPersistent() {
        return Data.getInstance().getVehicles();
    }

    public Object[][] getTableData() {
        ArrayList<Entity> list = Data.getInstance().getVehicles().getEntities();
        Object[][] tableData = new Object[list.size()][4];

        for (int i = 0; i < list.size(); i++) {
            Vehicle vehicle = (Vehicle) list.get(i);
            tableData[i][0] = vehicle.getId();
            tableData[i][1] = vehicle.getModel();
            tableData[i][2] = vehicle.getPlate();
            tableData[i][3] = vehicle.getClient();
        }

        return tableData;
    }

}
