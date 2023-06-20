package view;

import model.Entity;
import controller.EntityController;
import controller.InputException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public abstract class EntityPanel extends JPanel {

    protected DefaultTableModel tableModel = new DefaultTableModel();
    protected JTable table = new JTable(tableModel) {
        public boolean isCellEditable(int row, int column) {
            return false;
        };
    };

    protected abstract String getTitle();

    protected abstract String[] getInputs();

    protected abstract EntityController getEntityController();

    protected abstract JPanel createForm();

    protected abstract void checkForm() throws Exception;

    protected abstract Entity createEntity() throws Exception;

    protected abstract void clearForm();

    protected abstract void fillForm();

    protected JPanel createTitle() {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setPreferredSize(new Dimension(800, 30));

        JLabel titleLabel = new JLabel(getTitle());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 17));
        titlePanel.add(titleLabel);

        return titlePanel;
    }

    protected JPanel createButtons() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(800, 35));

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

    protected JScrollPane createScrollableTable(String[] inputs) {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (table.getSelectedRow() >= 0) {
                    fillForm();
                }
            }
        });

        for (String value : inputs) {
            tableModel.addColumn(value.toString());
        }
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollable = new JScrollPane();
        scrollable.setPreferredSize(new Dimension(600, 325));
        scrollable.setViewportView(table);

        return scrollable;
    }

    protected void loadTableData(Object[][] tableData) {
        tableModel.setNumRows(0);
        for (int i = 0; i < tableData.length; i++) {
            tableModel.addRow(tableData[i]);
        }
    }

}
