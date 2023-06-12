package view;

import model.Entity;
import controller.*;

import javax.swing.JTextField;

/*
 * Strategy Design Pattern
 * Multiple panels can be created using EnitityPanel
 */

public interface EntityPanelSettings {

    public String getTitle();

    public String[] getInputs();

    public EntityController getEntityController();

    default void checkEmpty(JTextField[] textFields) throws Exception {
        for (JTextField tf : textFields) {
            if (tf.getText().isEmpty()) {
                throw new InputException("Some inputs are empty");
            }
        }
    }

    public Entity createEntity(JTextField[] textFields) throws NumberFormatException, IdException, InputException;

}
