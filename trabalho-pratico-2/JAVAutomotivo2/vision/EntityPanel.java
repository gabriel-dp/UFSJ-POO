package vision;

import model.Entity;
import controller.Persistent;
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
        super(new FlowLayout(FlowLayout.CENTER, 0, 10));

        this.settings = settings;
        JTextField[] textFields = new JTextField[settings.getInputs().length];

        add(createTitle(settings.getTitle()));
        add(createForm(textFields));
        add(createButtonsPanel(textFields));
        add(createScrollableTable(settings.getInputs()));
    }

    public EntityPanelSettings getEntityInterface() {
        return this.settings;
    }

    private JLabel createTitle(String title) {
        JLabel panelTitle = new JLabel(title);
        panelTitle.setFont(new Font("Arial", Font.BOLD, 17));
        return panelTitle;
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

    private JPanel createButtonsPanel(JTextField[] textFields) {
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    settings.validForm(textFields);
                    addEntity(settings.createEntity(textFields), settings.getPersistent());
                    loadTableData(settings.getPersistent());
                } catch (Exception error) {
                    System.out.println(error.getMessage());
                }

            }
        });
        buttonsPanel.add(addButton);

        JButton removeButton = new JButton("Remover");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeEntity(settings.getPersistent());
                loadTableData(settings.getPersistent());
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
        scrollable.setPreferredSize(new Dimension(600, 350));
        scrollable.setViewportView(table);

        return scrollable;
    }

    private void addEntity(Entity entity, Persistent persistent) {
        try {
            Entity old = persistent.searchId(entity.getId());
            persistent.modify(old, entity);
        } catch (IdException e) {
            persistent.insert(entity);
        }
    }

    private void removeEntity(Persistent persistent) {
        if (table.getSelectedRow() >= 0) {
            Entity entity = persistent.getEntities().get(table.getSelectedRow());
            persistent.remove(entity);
        }
    }

    private void loadTableData(Persistent persistent) {
        tableModel.setNumRows(0);
        for (Entity entity : persistent.getEntities()) {
            tableModel.addRow(entity.getData());
        }
    }

}
