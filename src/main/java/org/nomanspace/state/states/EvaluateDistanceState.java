package org.nomanspace.state.states;

import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.gamefield.Vertex;
import org.nomanspace.state.Context;
import org.nomanspace.state.State;

public class EvaluateDistanceState implements State {

    SimulationMap map;

    public EvaluateDistanceState(SimulationMap map) {
        this.map = map;
    }

    @Override
    public void execute(Context context) {
        Vertex currentPos = context.getMap().getEntityPosition(context.getCreature());
        Vertex targetPos = context.getCurrentTarget().getPosition();
        
        if (canAttack(currentPos, targetPos)) {
            // Если в зоне атаки - переход к взаимодействию
            context.setState(new InteractionState(map));
        } else {
            // Если далеко - переход к движению
            context.setState(new MoveState(map));
        }
        context.executeState();
    }
    
    private boolean canAttack(Vertex current, Vertex target) {
        return Math.abs(current.getRow() - target.getRow()) <= 1 && 
               Math.abs(current.getColumn() - target.getColumn()) <= 1;
    }
}
