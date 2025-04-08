package org.nomanspace.action.initmapaction;

import org.nomanspace.action.Action;
import org.nomanspace.entityfactory.EntityType;
import org.nomanspace.entityfactory.GameEntityFactory;
import org.nomanspace.entityfactory.MapBuilder;
import org.nomanspace.gamefield.SimulationMap;

public class InitMapAction implements Action {
    private final MapBuilder mapBuilder;

    public InitMapAction(SimulationMap map) {
        this.mapBuilder = new MapBuilder(map, new GameEntityFactory(map));
    }

    @Override
    public void handle(SimulationMap map) {
        mapBuilder
            .addRandomEntities(EntityType.GRASS, 10)
            .addRandomEntities(EntityType.HERBIVORE, 5)
            .addRandomEntities(EntityType.PREDATOR, 2)
            .addRandomEntities(EntityType.ROCK, 4);
    }

    
}
