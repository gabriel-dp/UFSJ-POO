package controller;

import data.*;
import model.Vehicle;

import java.util.ArrayList;

public class VehiclesController extends EntityController<Vehicle> {

    public Persistent<Vehicle> getPersistent() {
        return Data.getInstance().getVehicles();
    }

    public Object[][] getTableData() {
        ArrayList<Vehicle> list = getPersistent().getEntities();
        Object[][] tableData = new Object[list.size()][4];

        for (int i = 0; i < list.size(); i++) {
            Vehicle vehicle = list.get(i);
            tableData[i][0] = vehicle.getId();
            tableData[i][1] = vehicle.getModel();
            tableData[i][2] = vehicle.getPlate();
            tableData[i][3] = vehicle.getClient();
        }

        return tableData;
    }

}
