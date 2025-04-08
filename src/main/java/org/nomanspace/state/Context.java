package org.nomanspace.state;

import org.nomanspace.Entity.Creature;
import org.nomanspace.entitybehaviors.Target;
import org.nomanspace.entitybehaviors.TargetFinder;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.pathfinder.PathFinder;
import org.nomanspace.state.states.SearchTargetState;

public class Context {
    private State state;
    private final SimulationMap map;
    private final PathFinder pathFinder;
    private final TargetFinder targetFinder;
    private Target currentTarget;
    private final Creature creature;

    public Context(Creature creature, SimulationMap map) {
        this.creature = creature;
        this.map = map;
        this.pathFinder = new PathFinder(map);
        this.targetFinder = new TargetFinder(map);
        this.state = new SearchTargetState(map);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void executeState() {
        state.execute(this);
    }

    public SimulationMap getMap() { 
        return map; 
    }
    public PathFinder getPathFinder() { 
        return pathFinder; 
    }
    public TargetFinder getTargetFinder() { 
        return targetFinder; 
    }
    public Target getCurrentTarget() { 
        return currentTarget; 
    }
    public void setCurrentTarget(Target target) { 
        this.currentTarget = target; 
    }
    public Creature getCreature() { 
        return creature; 
    }

}
