package org.nomanspace.state.states;

import org.nomanspace.entitybehaviors.Target;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.state.Context;
import org.nomanspace.state.State;

public class SearchTargetState implements State {
    SimulationMap map;

    public SearchTargetState(SimulationMap map) {
        this.map = map;
    }

    @Override
    public void execute(Context context) {
        Target target = context.getTargetFinder().findNearestTarget(context.getCreature());
        if (target == null) {
            return; // Цель не найдена, остаемся в текущем состоянии
        }
        
        context.setCurrentTarget(target);
        // Переход к оценке расстояния
        context.setState(new EvaluateDistanceState(map));
        context.executeState();
    }
}