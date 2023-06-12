package view;

import controller.InputException;
import controller.IdException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EntityPanel extends JPanel {

    private EntityPanelSettings settings;

    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTable table = new JTable(tableModel) {
        public boolean isCellEditable(int row, int column) {
            return false;
        };
    };

    public EntityPanel(EntityPanelSettings settings) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        this.settings = settings;
        JTextField[] textFields = new JTextField[settings.getInputs().length];

        this.add(createTitle(settings.getTitle()));
        this.add(createForm(textFields));
        this.add(createButtons(textFields));
        this.add(createScrollableTable(settings.getInputs()));
    }

    public EntityPanelSettings getSettings() {
        return this.settings;
    }

    private JPanel createTitle(String title) {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setPreferredSize(new Dimension(800, 30));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 17));
        titlePanel.add(titleLabel);

        return titlePanel;
    }

    private JPanel createForm(JTextField[] textFields) {
        JPanel formPanel = new JPanel(new GridLayout(2, (int) Math.ceil(settings.getInputs().length / 2), 10, 0));

        for (int i = 0; i < settings.getInputs().length; i++) {
            JPanel subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JTextField tf = new JTextField();
            tf.setPreferredSize(new Dimension(200, 20));
            textFields[i] = tf;

            subpanel.add(new JLabel(String.format("%s: ", settings.getInputs()[i])));
            subpanel.add(tf);

            formPanel.add(subpanel);
        }

        return formPanel;
    }

    private JPanel createButtons(JTextField[] textFields) {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(800, 35));

        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    settings.checkEmpty(textFields);
                    settings.getEntityController().addEntity(settings.createEntity(textFields));
                    loadTableData(settings.getEntityController().getController().getTableData());
                } catch (IdException errorId) {
                    System.out.printf("Id '%d' não encontrado\n", errorId.getId());
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
                    settings.getEntityController().removeEntity(index);
                    loadTableData(settings.getEntityController().getController().getTableData());
                }
            }
        });
        buttonsPanel.add(removeButton);

        return buttonsPanel;
    }

    private JScrollPane createScrollableTable(String[] inputs) {
        for (String value : inputs) {
            tableModel.addColumn(value.toString());
        }
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollable = new JScrollPane();
        scrollable.setPreferredSize(new Dimension(600, 325));
        scrollable.setViewportView(table);

        return scrollable;
    }

    private void loadTableData(Object[][] tableData) {
        tableModel.setNumRows(0);
        for (int i = 0; i < tableData.length; i++) {
            tableModel.addRow(tableData[i]);
        }
    }

}
