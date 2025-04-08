package org.nomanspace.state.states;

import org.nomanspace.WinCondition;
import org.nomanspace.Entity.Herbivore;
import org.nomanspace.entitybehaviors.Target;
import org.nomanspace.state.Context;
import org.nomanspace.state.State;

import org.nomanspace.observer.Event;
import org.nomanspace.gamefield.SimulationMap;

public class EatState implements State {

    SimulationMap map;

    public EatState(SimulationMap map) {
        this.map = map;
    }

    @Override
    public void execute(Context context) {
        Target target = context.getCurrentTarget();
        context.getMap().removeEntity(target.getPosition());
        Herbivore herbivore = (Herbivore) context.getCreature();
        //herbivore.restoreEnergy();
        // После поедания возвращаемся к поиску цели
        Event event = new Event("GRASS_EATEN", herbivore);
        map.notifyObservers(event);
        context.setState(new SearchTargetState(map));
        context.executeState();
    }
}
