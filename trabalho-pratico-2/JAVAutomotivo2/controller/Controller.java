package controller;

import data.*;

public interface Controller {

    public Persistent getPersistent();

    public Object[][] getTableData();

    default public Data getData() {
        return Data.getInstance();
    }

}
