package controller;

import model.Entity;
import data.Persistent;

public abstract class EntityController<T extends Entity> {

    public abstract Persistent<T> getPersistent();

    public abstract Object[][] getTableData();

    public void addEntity(T entity) {
        try {
            T old = getPersistent().searchId(entity.getId());
            getPersistent().modify(old, entity);
        } catch (IdException e) {
            // Creates new Entity if not found id
            getPersistent().insert(entity);
        }
    }

    public void removeEntity(int index) {
        T entity = getPersistent().getEntities().get(index);
        getPersistent().remove(entity);
    }

    public T getEntity(int index) {
        T entity = getPersistent().getEntities().get(index);
        return entity;
    }
}