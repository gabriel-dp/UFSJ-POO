package vision;

import model.Entity;
import controller.Data;
import controller.Persistent;

import javax.swing.JTextField;

/*
 * Strategy Design Pattern
 * Multiple panels can be created using EnitityPanel
 */

public interface EntityPanelSettings {

    public String getTitle();

    public String[] getInputs();

    public Data getData();

    public Persistent getPersistent();

    default void checkEmpty(JTextField[] textFields) throws Exception {
        for (JTextField tf : textFields) {
            if (tf.getText().isEmpty()) {
                throw new Exception("Some inputs are empty");
            }
        }
    }

    public void validForm(JTextField[] textFields) throws Exception;

    public Entity createEntity(JTextField[] textFields) throws Exception;

}
