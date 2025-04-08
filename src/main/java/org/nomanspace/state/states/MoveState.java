package org.nomanspace.state.states;
import java.util.List;

import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.gamefield.Vertex;
import org.nomanspace.pathfinder.PathFinder;
import org.nomanspace.state.Context;
import org.nomanspace.state.State;

public class MoveState implements State {

    SimulationMap map;

    public MoveState(SimulationMap map) {
        this.map = map;
    }


    @Override
    public void execute(Context context) {
        Vertex currentPos = context.getMap().getEntityPosition(context.getCreature());
        Vertex targetPos = context.getCurrentTarget().getPosition();
        
        PathFinder pathFinder = context.getPathFinder();
        pathFinder.searchPath(currentPos, targetPos);
        
        List<Vertex> path = pathFinder.reconstructPath();
        //я беру 2 индекс,он же первый, как мне возвращать сразу нужный?
        if ((!path.isEmpty()) && path.size() >= 1 ) {
            context.getMap().replaceEntity(currentPos, path.get(1));
        }
        // После движения возвращаемся к оценке расстояния
        context.setState(new EvaluateDistanceState(map));
        context.executeState();
    }
}