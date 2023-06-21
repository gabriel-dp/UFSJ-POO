package controller;

import java.util.ArrayList;

import data.*;
import model.Procedure;

public class ProceduresController extends EntityController<Procedure> {

    public Persistent<Procedure> getPersistent() {
        return Data.getInstance().getProcedures();
    }

    public Object[][] getTableData() {
        ArrayList<Procedure> list = getPersistent().getEntities();
        Object[][] tableData = new Object[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            Procedure procedure = list.get(i);
            tableData[i][0] = procedure.getId();
            tableData[i][1] = procedure.getProcedureName();
            tableData[i][2] = procedure.getValue();
        }

        return tableData;
    }

}
