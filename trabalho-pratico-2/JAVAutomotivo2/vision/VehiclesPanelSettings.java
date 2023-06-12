package vision;

import model.Entity;
import model.Vehicle;
import controller.Data;
import controller.Persistent;

import javax.swing.JTextField;

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

    public Entity createEntity(JTextField[] textFields) throws NumberFormatException {
        int id = Integer.parseInt(textFields[0].getText());
        String model = textFields[1].getText();
        String plate = textFields[2].getText();
        String client = textFields[3].getText();

        return new Vehicle(id, model, plate, client);
    }

}
