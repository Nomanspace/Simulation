package org.nomanspace.entityfactory;

import org.nomanspace.Entity.Entity;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.gamefield.Vertex;


public class MapBuilder {
    private final SimulationMap simulationMap;
    private final GameEntityFactory entityFactory;

    public MapBuilder(SimulationMap simulationMap, GameEntityFactory entityFactory) {
            this.simulationMap = simulationMap;
            this.entityFactory = entityFactory;
    }

    public MapBuilder addEntity(EntityType entityType, Vertex position) {
        Entity entity = entityFactory.createEntity(entityType);
        simulationMap.placeGameEntity(position.getColumn(), position.getRow(), entity);
        return this;
    }

    public MapBuilder addRandomEntities(EntityType type, int count) {
        int added = 0;
        try {
            for (int i = 0; i < count; i++) {
                Vertex position = simulationMap.getRandomEmptyPosition();
                addEntity(type, position);
                added++;
            }
        } catch(RuntimeException e) {
            System.out.println("Добавлено " + added + " из " + count + " существ. Ошибка: " + e.getMessage());
        }   
        return this;
    }
}
