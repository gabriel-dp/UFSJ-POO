package controller;

import model.*;
import java.util.ArrayList;

public class Persistent {

    private ArrayList<Entity> entities;

    public Persistent() {
        this.entities = new ArrayList<Entity>();
    }

    public ArrayList<Entity> getEntities() {
        return this.entities;
    }

    public void insert(Entity entity) {
        this.entities.add(entity);
    }

    public void modify(Entity oldEntity, Entity newEntity) {
        int index = this.entities.indexOf(oldEntity);
        this.entities.set(index, newEntity);
    }

    public void remove(Entity entity) {
        this.entities.remove(entity);
    }

    public Entity searchId(int id) throws IdException {
        for (Entity entity : this.entities) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        throw new IdException(id);
    }

}
