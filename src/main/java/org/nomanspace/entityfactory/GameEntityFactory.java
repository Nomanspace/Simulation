package org.nomanspace.entityfactory;

import org.nomanspace.Entity.Entity;
import org.nomanspace.Entity.Grass;
import org.nomanspace.Entity.Herbivore;
import org.nomanspace.Entity.Predator;
import org.nomanspace.Entity.Rock;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.gamefield.Vertex;

public class GameEntityFactory implements EntityFactory {
    SimulationMap simulationMap;

    public GameEntityFactory (SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    @Override
    public Entity createEntity(EntityType type) {
        return switch (type) {
            case HERBIVORE -> new Herbivore(simulationMap);
            case PREDATOR -> new Predator(simulationMap);
            case GRASS -> new Grass();
            case ROCK -> new Rock();
            default -> throw new IllegalArgumentException("Unknown entity type: " + type);
        };
    }

}