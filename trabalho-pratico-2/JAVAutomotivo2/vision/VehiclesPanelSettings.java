package vision;

import model.Entity;
import model.Vehicle;

import javax.swing.*;

import controller.Data;
import controller.Persistent;

public class VehiclesPanelSettings implements EntityPanelSettings {

    public Data data;

    public VehiclesPanelSettings(Data data) {
        this.data = data;
    }

    public String getTitle() {
        return "Veículos";
    }

    public String[] getInputs() {
        return new String[] { "Id", "Modelo", "Placa", "Cliente" };
    }

    public Data getData() {
        return this.data;
    }

    public Persistent getPersistent() {
        return this.data.getVehicles();
    }

    public void validForm(JTextField[] textFields) throws Exception {
        checkEmpty(textFields);
        Integer.parseInt(textFields[0].getText());
    }

    public Entity createEntity(JTextField[] textFields) {
        return new Vehicle(
                Integer.parseInt(textFields[0].getText()),
                textFields[1].getText(),
                textFields[2].getText(),
                textFields[3].getText());
    }

}
