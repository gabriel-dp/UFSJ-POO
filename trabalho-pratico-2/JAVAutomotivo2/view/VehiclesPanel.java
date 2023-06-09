package view;

import model.*;
import controller.*;
import factory.EntityFactory;

import java.awt.*;
import javax.swing.*;

public class VehiclesPanel extends EntityPanel<Vehicle> {

    private JTextField[] textFields;

    public VehiclesPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        this.textFields = new JTextField[getInputs().length];

        this.add(createTitle());
        this.add(createForm());
        this.add(createButtons());
        this.add(createScrollableTable());
    }

    protected String getTitle() {
        return "Veículos";
    }

    protected String[] getInputs() {
        return new String[] { "Id", "Modelo", "Placa", "Cliente" };
    }

    protected EntityController<Vehicle> getEntityController() {
        return EntityFactory.getFactory(Vehicle.class).createController();
    }

    protected JPanel createForm() {
        JPanel formPanel = new JPanel(new GridLayout(2, (int) Math.ceil(getInputs().length / 2), 10, 0));

        // Creates a subpanel for each input field
        for (int i = 0; i < getInputs().length; i++) {
            JPanel subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JTextField tf = new JTextField();
            tf.setPreferredSize(new Dimension(200, 20));
            textFields[i] = tf;

            subpanel.add(new JLabel(String.format("%s: ", getInputs()[i])));
            subpanel.add(tf);

            formPanel.add(subpanel);
        }

        return formPanel;
    }

    protected void checkForm() throws InputException {
        for (JTextField tf : textFields) {
            if (tf.getText().isBlank()) {
                throw new InputException("Some inputs are blank");
            }
        }
    }

    protected Vehicle createEntity() throws NumberFormatException {
        int id = Integer.parseInt(textFields[0].getText());
        String model = textFields[1].getText();
        String plate = textFields[2].getText();
        String client = textFields[3].getText();

        return EntityFactory.getFactory(Vehicle.class).createEntity(id, model, plate, client);
    }

    protected void clearForm() {
        for (JTextField textField : textFields) {
            textField.setText("");
        }
    }

    protected void fillForm() {
        Vehicle vehicle = getEntityController().getEntity(table.getSelectedRow());

        textFields[0].setText(String.valueOf(vehicle.getId()));
        textFields[1].setText(vehicle.getModel());
        textFields[2].setText(vehicle.getPlate());
        textFields[3].setText(vehicle.getClient());
    }

}
