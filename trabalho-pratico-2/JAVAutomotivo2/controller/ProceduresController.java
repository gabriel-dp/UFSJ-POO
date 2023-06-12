package controller;

import java.util.ArrayList;

import data.Data;
import data.Persistent;
import model.Entity;
import model.Procedure;

public class ProceduresController implements Controller {

    public Persistent getPersistent() {
        return Data.getInstance().getProcedures();
    }

    public Object[][] getTableData() {
        ArrayList<Entity> list = Data.getInstance().getProcedures().getEntities();
        Object[][] tableData = new Object[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            Procedure procedure = (Procedure) list.get(i);
            tableData[i][0] = procedure.getId();
            tableData[i][1] = procedure.getProcedureName();
            tableData[i][2] = procedure.getValue();
        }

        return tableData;
    }

}
