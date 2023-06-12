package vision;

import model.Entity;
import model.Procedure;
import controller.Data;
import controller.Persistent;

import javax.swing.JTextField;

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

    public Entity createEntity(JTextField[] textFields) throws NumberFormatException {
        int id = Integer.parseInt(textFields[0].getText());
        String name = textFields[1].getText();
        double value = Double.parseDouble(textFields[2].getText());

        return new Procedure(id, name, value);
    }

}
