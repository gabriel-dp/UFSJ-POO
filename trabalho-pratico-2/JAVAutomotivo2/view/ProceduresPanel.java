package view;

import model.*;
import controller.*;
import factory.EntityFactory;

import java.awt.*;
import javax.swing.*;

public class ProceduresPanel extends EntityPanel<Procedure> {

    private JTextField[] textFields;

    public ProceduresPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        this.textFields = new JTextField[getInputs().length];

        this.add(createTitle());
        this.add(createForm());
        this.add(createButtons());
        this.add(createScrollableTable());
    }

    protected String getTitle() {
        return "Procedimentos";
    }

    protected String[] getInputs() {
        return new String[] { "Id", "Nome", "Valor" };
    }

    protected EntityController<Procedure> getEntityController() {
        return EntityFactory.getFactory(Procedure.class).createController();
    }

    protected JPanel createForm() {
        // Creates formPanel
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

    protected Procedure createEntity() throws NumberFormatException {
        int id = Integer.parseInt(textFields[0].getText());
        String name = textFields[1].getText();
        double value = Double.parseDouble(textFields[2].getText());

        return EntityFactory.getFactory(Procedure.class).createEntity(id, name, value);
    }

    protected void clearForm() {
        for (JTextField textField : textFields) {
            textField.setText("");
        }
    }

    protected void fillForm() {
        Procedure procedure = getEntityController().getEntity(table.getSelectedRow());

        textFields[0].setText(String.valueOf(procedure.getId()));
        textFields[1].setText(procedure.getProcedureName());
        textFields[2].setText(String.valueOf(procedure.getValue()));
    }

}
