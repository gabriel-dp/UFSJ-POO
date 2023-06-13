package view;

import model.*;
import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.ArrayList;

public class MaintenancesPanel extends EntityPanel {

    private JTextField idTF = new JTextField();
    private JComboBox<Vehicle> vehiclesComboBox = new JComboBox<Vehicle>();
    private ArrayList<Service> servicesArrayList = new ArrayList<>();

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
        return new MaintenancesController();
    }

    protected JPanel createForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Create id input
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idTF.setPreferredSize(new Dimension(150, 20));
        idPanel.add(new JLabel(String.format("%s: ", getInputs()[0])));
        idPanel.add(idTF);
        formPanel.add(idPanel);

        // Create vehicle input
        JPanel vehiclesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        final Vehicle optionVehicle = new Vehicle(0, "Modelo", "Placa", "Cliente");
        vehiclesComboBox.insertItemAt(optionVehicle, 0);
        vehiclesComboBox.setSelectedIndex(0);
        vehiclesComboBox.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                vehiclesComboBox.setModel(new DefaultComboBoxModel<>(
                        ((MaintenancesController) getEntityController()).getVehiclesArray()));
                vehiclesComboBox.insertItemAt(optionVehicle, 0);
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

        // Create servicess input
        JButton servicesButton = new JButton("Editar serviços");
        servicesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog lockingDialog = new JDialog(SwingUtilities.getWindowAncestor(formPanel));
                lockingDialog.setSize(600, 300);
                lockingDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                DefaultTableModel servicesModel = new DefaultTableModel();
                JTable servicesTable = new JTable(servicesModel);

                servicesModel.addColumn("Procedimento");
                Procedure[] proceduresArray = ((MaintenancesController) getEntityController()).getProceduresArray();
                for (Procedure procedimento : proceduresArray) {
                    servicesModel.addRow(new Object[] { procedimento, 0 });
                }

                servicesModel.addColumn("Quantidade");

                JScrollPane servicesPanel = new JScrollPane();
                servicesPanel.setPreferredSize(new Dimension(600, 50));
                servicesPanel.setViewportView(servicesTable);

                lockingDialog.add(servicesPanel);
                lockingDialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        servicesArrayList.clear();
                        for (int i = 0; i < proceduresArray.length; i++) {
                            Service service;
                            service = new Service(proceduresArray[i],
                                    Integer.parseInt(servicesTable.getValueAt(i, 1).toString()));
                            servicesArrayList.add(service);
                        }
                    }
                });

                lockingDialog.setVisible(true);
            }
        });
        formPanel.add(servicesButton);

        return formPanel;
    }

    protected void checkForm() throws InputException {
        if (idTF.getText().isBlank() || vehiclesComboBox.getSelectedIndex() == 0) {
            throw new InputException("Some inputs are blank");
        }
    }

    protected Entity createEntity() throws Exception {
        int maintenanceId = Integer.parseInt(idTF.getText());
        Vehicle vehicle = (Vehicle) vehiclesComboBox.getSelectedItem();
        ArrayList<Service> services = new ArrayList<>();

        return new Maintenance(maintenanceId, vehicle, services);
    }

    protected void clearForm() {
        idTF.setText("");
        vehiclesComboBox.setSelectedIndex(0);
    }

    protected void fillForm() {
        Maintenance maintenance = (Maintenance) getEntityController()
                .getPersistent()
                .getEntities()
                .get(table.getSelectedRow());

        idTF.setText(String.valueOf(maintenance.getId()));
    }

}
