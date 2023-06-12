package controller;

import model.Entity;

public class EntityController {

    private Controller controller;

    public EntityController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }

    public void addEntity(Entity entity) {
        try {
            Entity old = controller.getPersistent().searchId(entity.getId());
            controller.getPersistent().modify(old, entity);
        } catch (IdException e) {
            // Creates new Entity if not found id
            controller.getPersistent().insert(entity);
        }
    }

    public void removeEntity(int index) {
        Entity entity = controller.getPersistent().getEntities().get(index);
        controller.getPersistent().remove(entity);
    }

}