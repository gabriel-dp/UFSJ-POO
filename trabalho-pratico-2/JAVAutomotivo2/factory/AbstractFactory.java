package factory;

import model.Entity;
import view.EntityPanel;
import controller.EntityController;

public abstract class AbstractFactory {

    public abstract Entity createEntity(int id, Object... args);

    public abstract EntityPanel createPanel();

    public abstract EntityController createController();

}
