package view;

import model.Entity;
import model.Vehicle;
import controller.EntityController;
import controller.VehiclesController;

import javax.swing.JTextField;

public class VehiclesPanelSettings implements EntityPanelSettings {

    public String getTitle() {
        return "Veículos";
    }

    public String[] getInputs() {
        return new String[] { "Id", "Modelo", "Placa", "Cliente" };
    }

    public EntityController getEntityController() {
        return new EntityController(new VehiclesController());
    }

    public Entity createEntity(JTextField[] textFields) throws NumberFormatException {
        int id = Integer.parseInt(textFields[0].getText());
        String model = textFields[1].getText();
        String plate = textFields[2].getText();
        String client = textFields[3].getText();

        return new Vehicle(id, model, plate, client);
    }

}
