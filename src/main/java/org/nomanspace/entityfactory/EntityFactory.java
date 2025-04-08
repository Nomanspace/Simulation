package org.nomanspace.entityfactory;

import org.nomanspace.Entity.Entity;
//import org.nomanspace.gamefield.Vertex;

public interface EntityFactory {
    Entity createEntity(EntityType type);
}