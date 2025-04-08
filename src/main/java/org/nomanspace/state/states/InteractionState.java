package org.nomanspace.state.states;

import org.nomanspace.Entity.Creature;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.state.Context;
import org.nomanspace.state.State;



public class InteractionState implements State {

    SimulationMap map;

    public InteractionState(SimulationMap map) {
        this.map = map;
    }

    @Override
    public void execute(Context context) {
        // Получаем состояние взаимодействия от конкретного существа
        Creature creature = context.getCreature();
        context.setState(creature.getInteractionState());
        context.executeState();
    }
}
