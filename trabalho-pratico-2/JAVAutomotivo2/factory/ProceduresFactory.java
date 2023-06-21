package factory;

import model.*;
import view.*;
import controller.*;

public class ProceduresFactory extends EntityFactory {

    public Entity createEntity(int id, Object... args) {
        return new Procedure(id, (String) args[0], (double) args[1]);
    }

    public EntityPanel createPanel() {
        return new ProceduresPanel();
    }

    public EntityController createController() {
        return new ProceduresController();
    }

}
