package view;

import model.Entity;
import controller.EntityController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public abstract class EntityPanel<T extends Entity> extends JPanel {

    protected DefaultTableModel tableModel = new DefaultTableModel();
    protected JTable table = new JTable(tableModel) {
        // Disable table edition by user
        public boolean isCellEditable(int row, int column) {
            return false;
        };
    };

    protected abstract String getTitle();

    protected abstract String[] getInputs();

    protected abstract EntityController<T> getEntityController();

    protected abstract JPanel createForm();

    protected abstract void checkForm() throws Exception;

    protected abstract T createEntity() throws Exception;

    protected abstract void clearForm();

    protected abstract void fillForm();

    protected JPanel createTitle() {
        // Creates titlePanel
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setPreferredSize(new Dimension(800, 30));

        // Creates titleLabel
        JLabel titleLabel = new JLabel(getTitle());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 17));
        titlePanel.add(titleLabel);

        return titlePanel;
    }

    protected JPanel createButtons() {
        // Creates buttonsPanel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(800, 35));

        // Creates addButton and event
        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    checkForm();
                    getEntityController().addEntity(createEntity());
                    loadTableData(getEntityController().getTableData());

                    clearForm();
                } catch (InputException errorInput) {
                    System.out.println("Entrada(s) inválida(s)");
                } catch (NumberFormatException _e) {
                    System.out.println("Número(s) inválido(s)");
                } catch (Exception errorGeneric) {
                    System.out.println(errorGeneric.getMessage());
                }
            }
        });
        buttonsPanel.add(addButton);

        // Creates removeButton and event
        JButton removeButton = new JButton("Remover");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = table.getSelectedRow();
                if (index >= 0) {
                    getEntityController().removeEntity(index);
                    loadTableData(getEntityController().getTableData());
                }
            }
        });
        buttonsPanel.add(removeButton);

        return buttonsPanel;
    }

    protected JScrollPane createScrollableTable() {
        // Event to fillForm() every time user clicks on a table element
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (table.getSelectedRow() >= 0) {
                    fillForm();
                }
            }
        });

        // Creates table header
        for (String value : getInputs()) {
            tableModel.addColumn(value.toString());
        }
        table.getTableHeader().setReorderingAllowed(false);

        // Creates scrollable panel to contain table
        JScrollPane scrollable = new JScrollPane();
        scrollable.setPreferredSize(new Dimension(600, 325));
        scrollable.setViewportView(table);

        return scrollable;
    }

    protected void loadTableData(Object[][] tableData) {
        // Resets table data
        tableModel.setNumRows(0);

        // Adds each row data from given Object[][]
        for (int i = 0; i < tableData.length; i++) {
            tableModel.addRow(tableData[i]);
        }
    }

}
