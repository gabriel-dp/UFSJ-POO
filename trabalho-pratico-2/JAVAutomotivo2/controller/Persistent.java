package controller;

import java.util.ArrayList;

import model.*;

import java.lang.StringBuilder;

public class Persistent {

    private ArrayList<Entity> entities;

    public Persistent() {
        this.entities = new ArrayList<Entity>();
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Total = %d\n", this.entities.size()));
        for (Entity entity : this.entities) {
            sb.append(String.format("%d { %s }\n", entity.getId(), entity.toString()));
        }
        return sb.toString();
    }

}
