package view;

import model.*;
import controller.*;
import factory.EntityFactory;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.ArrayList;

public class MaintenancesPanel extends EntityPanel {

    private JTextField idTF = new JTextField();
    private JComboBox<Object> vehiclesComboBox = new JComboBox<Object>();
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
        return EntityFactory.getFactory(Maintenance.class).createController();
    }

    protected JPanel createForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Create id input
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idTF.setPreferredSize(new Dimension(200, 20));
        idPanel.add(new JLabel(String.format("%s: ", getInputs()[0])));
        idPanel.add(idTF);
        formPanel.add(idPanel);

        formPanel.add(Box.createVerticalStrut(5));

        // Create selectors panel to vehicle and services
        JPanel selectorsPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        selectorsPanel.setPreferredSize(new Dimension(600, 25));
        formPanel.add(selectorsPanel);

        // Create vehicle input
        final Object optionVehicle = "Selecione um veículo";
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
        selectorsPanel.add(vehiclesComboBox);

        // Create services input
        JButton servicesButton = new JButton("Editar serviços");
        servicesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog servicesMenu = new JDialog(SwingUtilities.getWindowAncestor(formPanel), "Edição de Serviços");
                servicesMenu.setSize(500, 300);
                servicesMenu.setModal(true);
                servicesMenu.setLocationRelativeTo(SwingUtilities.getWindowAncestor(formPanel));
                servicesMenu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                DefaultTableModel servicesModel = new DefaultTableModel();
                JTable servicesTable = new JTable(servicesModel);

                Procedure[] proceduresArray = ((MaintenancesController) getEntityController()).getProceduresArray();
                Integer[] quantityArray = new Integer[proceduresArray.length];
                for (int i = 0; i < quantityArray.length; i++) {
                    quantityArray[i] = 0;
                }
                servicesModel.addColumn("Procedimento", proceduresArray);
                servicesModel.addColumn("Quantidade", quantityArray);

                JScrollPane servicesTablePanel = new JScrollPane();
                servicesTablePanel.setViewportView(servicesTable);
                servicesMenu.add(servicesTablePanel);
                servicesMenu.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        for (int i = 0; i < proceduresArray.length; i++) {
                            Service service;
                            service = new Service(proceduresArray[i],
                                    Integer.parseInt(servicesTable.getValueAt(i, 1).toString()));
                            servicesArrayList.add(service);
                        }
                    }
                });

                servicesMenu.setVisible(true);
            }
        });
        selectorsPanel.add(servicesButton);

        return formPanel;
    }

    protected void checkForm() throws InputException {
        if (idTF.getText().isBlank() || vehiclesComboBox.getSelectedIndex() == 0) {
            throw new InputException("Some inputs are blank");
        }
    }

    protected Entity createEntity() throws Exception {
        int id = Integer.parseInt(idTF.getText());
        Vehicle vehicle = (Vehicle) vehiclesComboBox.getSelectedItem();

        return EntityFactory.getFactory(Maintenance.class).createEntity(id, vehicle, servicesArrayList.clone());
    }

    protected void clearForm() {
        idTF.setText("");
        vehiclesComboBox.setSelectedIndex(0);
        servicesArrayList.clear();
    }

    protected void fillForm() {
        Maintenance maintenance = (Maintenance) getEntityController()
                .getPersistent()
                .getEntities()
                .get(table.getSelectedRow());

        idTF.setText(String.valueOf(maintenance.getId()));
    }

}
