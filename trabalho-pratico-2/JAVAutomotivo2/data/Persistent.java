package data;

import model.Entity;
import controller.IdException;

import java.util.ArrayList;

public class Persistent<T extends Entity> {

    private ArrayList<T> entities;

    public Persistent() {
        this.entities = new ArrayList<T>();
    }

    public ArrayList<T> getEntities() {
        return this.entities;
    }

    public void insert(T entity) {
        this.entities.add(entity);
    }

    public void modify(T oldEntity, T newEntity) {
        int index = this.entities.indexOf(oldEntity);
        this.entities.set(index, newEntity);
    }

    public void remove(T entity) {
        this.entities.remove(entity);
    }

    public T searchId(int id) throws IdException {
        for (T entity : this.entities) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        throw new IdException(id);
    }

}
