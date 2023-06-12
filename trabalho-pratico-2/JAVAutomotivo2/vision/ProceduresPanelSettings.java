package vision;

import model.Entity;
import model.Procedure;

import javax.swing.*;

import controller.Data;
import controller.Persistent;

public class ProceduresPanelSettings implements EntityPanelSettings {

    public Data data;

    public ProceduresPanelSettings(Data data) {
        this.data = data;
    }

    public String getTitle() {
        return "Procedimentos";
    }

    public String[] getInputs() {
        return new String[] { "Id", "Nome", "Valor" };
    }

    public Data getData() {
        return this.data;
    }

    public Persistent getPersistent() {
        return this.data.getProcedures();
    }

    public void validForm(JTextField[] textFields) throws Exception {
        checkEmpty(textFields);
        Integer.parseInt(textFields[0].getText());
        Double.parseDouble(textFields[2].getText());
    }

    public Entity createEntity(JTextField[] textFields) {
        return new Procedure(
                Integer.parseInt(textFields[0].getText()),
                textFields[1].getText(),
                Double.parseDouble(textFields[2].getText()));
    }

}
