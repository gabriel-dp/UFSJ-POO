package factory;

import view.*;
import controller.*;
import model.Procedure;

public class ProceduresFactory extends EntityFactory<Procedure> {

    public Procedure createEntity(int id, Object... args) {
        return new Procedure(id, (String) args[0], (double) args[1]);
    }

    public EntityPanel<Procedure> createPanel() {
        return new ProceduresPanel();
    }

    public EntityController<Procedure> createController() {
        return new ProceduresController();
    }

}
