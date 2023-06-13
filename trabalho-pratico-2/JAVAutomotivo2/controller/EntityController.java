package controller;

import model.Entity;

import data.*;

public abstract class EntityController {

    public abstract Persistent getPersistent();

    public abstract Object[][] getTableData();

    public void addEntity(Entity entity) {
        try {
            Entity old = getPersistent().searchId(entity.getId());
            getPersistent().modify(old, entity);
        } catch (IdException e) {
            // Creates new Entity if not found id
            getPersistent().insert(entity);
        }
    }

    public void removeEntity(int index) {
        Entity entity = getPersistent().getEntities().get(index);
        getPersistent().remove(entity);
    }

}