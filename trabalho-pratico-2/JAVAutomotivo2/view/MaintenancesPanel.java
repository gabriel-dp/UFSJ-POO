package view;

import model.*;
import controller.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class MaintenancesPanel extends EntityPanel {

    private JTextField idTF = new JTextField();
    private JComboBox<String> vehiclesComboBox = new JComboBox<String>();

    public MaintenancesPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        this.add(createTitle());
        this.add(createForm());
        this.add(createButtons());
        this.add(createScrollableTable(getInputs()));
    }

    protected String getTitle() {
        return "Manutenções";
    }

    protected String[] getInputs() {
        return new String[] { "Id", "Veículo", "Serviços" };
    }

    protected EntityController getEntityController() {
        return new EntityController(new MaintenancesController());
    }

    protected JPanel createForm() {
        JPanel formPanel = new JPanel(new GridLayout(2, (int) Math.ceil(getInputs().length / 2), 10, 0));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        idTF.setPreferredSize(new Dimension(200, 20));

        idPanel.add(new JLabel(String.format("%s: ", getInputs()[0])));
        idPanel.add(idTF);
        formPanel.add(idPanel);

        JPanel vehiclesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        vehiclesComboBox.insertItemAt("Selecione um veículo", 0);
        vehiclesComboBox.setSelectedIndex(0);
        vehiclesComboBox.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                ArrayList<Entity> vehiclesList = getEntityController()
                        .getController()
                        .getData()
                        .getVehicles()
                        .getEntities();
                String[] vehiclesArray = new String[vehiclesList.size()];
                for (int i = 0; i < vehiclesList.size(); i++) {
                    vehiclesArray[i] = vehiclesList.get(i).toString();
                }
                vehiclesComboBox.setModel(new DefaultComboBoxModel<>(vehiclesArray));
                vehiclesComboBox.insertItemAt("Selecione um veículo", 0);
                vehiclesComboBox.setSelectedIndex(0);
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            }

            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });

        vehiclesPanel.add(new JLabel(String.format("%s: ", getInputs()[1])));
        vehiclesPanel.add(vehiclesComboBox);
        formPanel.add(vehiclesPanel);

        return formPanel;
    }

    protected void checkForm() throws InputException {
        if (idTF.getText().isBlank() || vehiclesComboBox.getSelectedIndex() == 0) {
            throw new InputException("Some inputs are blank");
        }
    }

    protected Entity createEntity() throws Exception {
        // int maintenanceId = Integer.parseInt(textFields[0].getText());
        // int vehicleId = Integer.parseInt(textFields[1].getText());
        // ArrayList<Service> services = new ArrayList<>();

        // VehiclesController vehiclesController = new VehiclesController();
        // ProceduresController proceduresController = new ProceduresController();
        // Vehicle vehicle = (Vehicle)
        // vehiclesController.getPersistent().searchId(vehicleId);

        // String[] servicesSplited = textFields[2].getText().split(" ");
        // for (String s : servicesSplited) {
        // String[] args = s.split(",");
        // if (args.length < 2) {
        // throw new InputException("Invalid services");
        // }

        // int procedureId = Integer.parseInt(args[0]);
        // int procedureQuantity = Integer.parseInt(args[1]);
        // Service service = new Service(
        // (Procedure) proceduresController.getPersistent().searchId(procedureId),
        // procedureQuantity);
        // services.add(service);
        // }

        // return new Maintenance(maintenanceId, vehicle, services);
    }

    protected void clearForm() {
        idTF.setText("");
        vehiclesComboBox.setSelectedIndex(0);
    }

    protected void fillForm() {
        Maintenance maintenance = (Maintenance) getEntityController()
                .getController()
                .getPersistent()
                .getEntities()
                .get(table.getSelectedRow());

        idTF.setText(String.valueOf(maintenance.getId()));
    }

}
