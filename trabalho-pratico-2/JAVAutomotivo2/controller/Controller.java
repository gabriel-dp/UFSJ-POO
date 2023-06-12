package controller;

import data.Persistent;

public interface Controller {

    public Persistent getPersistent();

    public Object[][] getTableData();

}
