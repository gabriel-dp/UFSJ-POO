package view;

import model.Entity;
import model.Procedure;
import controller.EntityController;
import controller.ProceduresController;

import javax.swing.JTextField;

public class ProceduresPanelSettings implements EntityPanelSettings {

    public String getTitle() {
        return "Procedimentos";
    }

    public String[] getInputs() {
        return new String[] { "Id", "Nome", "Valor" };
    }

    public EntityController getEntityController() {
        return new EntityController(new ProceduresController());
    }

    public Entity createEntity(JTextField[] textFields) throws NumberFormatException {
        int id = Integer.parseInt(textFields[0].getText());
        String name = textFields[1].getText();
        double value = Double.parseDouble(textFields[2].getText());

        return new Procedure(id, name, value);
    }

}
