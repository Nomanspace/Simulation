package org.nomanspace.entitybehaviors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nomanspace.Entity.Entity;

import org.nomanspace.Entity.Creature;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.gamefield.Vertex;

public class TargetFinder {
    private final SimulationMap simulationMap;
    private final TargetManager targetManager;

    public TargetFinder(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
        this.targetManager = new TargetManager();
    }

    //собираем все доступные определенные для существа цели
    private Map<Vertex, Entity> collectTargets(Creature creature) {
        List<Class<? extends Entity>> allowedTargets = targetManager.getAllowedTargets(creature.getClass());
        Map<Vertex, Entity> allPossibleTargets = new HashMap<>();

        for (Class<? extends Entity> targetType : allowedTargets) {
            Map<Vertex,? extends Entity> targetsOfType = simulationMap.getEntitiesAndVerexByType(targetType);
            allPossibleTargets.putAll(targetsOfType);
        }
        return allPossibleTargets;

    }

    //находим ближайшую цель
    //на какой стадии собирать таргеты? 
    public Target findNearestTarget(Creature creature) {
        Map<Vertex, Entity> possibleTargets = collectTargets(creature);
        if (possibleTargets.isEmpty()) {
            //throw new TargetNotFoundException("No targets available for " + creature.getClass().getSimpleName());
        }

        Vertex currentPosition = simulationMap.getEntityPosition(creature);
        if (currentPosition == null) {
            throw new IllegalStateException("Creature position not found on map");
        }

        Map.Entry<Vertex, Entity> nearestTarget = null;
        int minDistance = Integer.MAX_VALUE;

        // Перебираем все возможные цели
        for (Map.Entry<Vertex, Entity> entry : possibleTargets.entrySet()) {
            int distance = calculateDistance(currentPosition, entry.getKey());
            
            // Обновляем ближайшую цель, если нашли цель ближе
            if (distance < minDistance) {
                minDistance = distance;
                nearestTarget = entry;
            }
        }

        if (nearestTarget == null) {
            throw new RuntimeException("Failed to find nearest target");
        }

        return new Target(nearestTarget.getValue(), nearestTarget.getKey());
    }

    private int calculateDistance(Vertex v1, Vertex v2) {
        return Math.abs(v1.getRow() - v2.getRow()) +
        Math.abs(v1.getColumn() - v2.getColumn());
    }
    
}
