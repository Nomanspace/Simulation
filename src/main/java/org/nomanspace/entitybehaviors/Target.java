package org.nomanspace.entitybehaviors;

import org.nomanspace.Entity.Entity;
import org.nomanspace.gamefield.Vertex;

public class Target {
    private final Entity entity;
    private final Vertex position;

    public Target(Entity entity, Vertex position) {
        this.entity = entity;
        this.position = position;
    }

    public Entity getEntity() {
        return entity;
    }

    public Vertex getPosition() {
        return position;
    }
} 