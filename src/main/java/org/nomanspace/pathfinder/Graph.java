package org.nomanspace.pathfinder;

import org.nomanspace.Entity.Blockable;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.navigation.Direction;
import org.nomanspace.Entity.Entity;
import org.nomanspace.gamefield.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    //private final Map gameField;
    //List<Vertex> neighboursVertex;

    /*public Graph( Map map) {
        this.gameField = map;
    }*/


    public int getCost(Vertex from, Vertex to) {
        return 1;
    }

    public List<Vertex> getNeighbours(Vertex sourceVertex, SimulationMap simulationMap) {
        List<Vertex> neighboursVertex = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            Vertex neighbourVertex = new Vertex(sourceVertex.getColumn() + direction.getColumn(),
                    sourceVertex.getRow() + direction.getRow());
                   // .setRow(sourceVertex.getRow() + direction.getY())
                    //.setColumn(sourceVertex.getColumn() + direction.getX());

            System.out.println("возможный сосед " + neighbourVertex.getRow() + " " + neighbourVertex.getColumn());

            //проверка на то что объект находится в пределах поля (выделить проверку в метод?)
            if (!((neighbourVertex.getRow() < 8 && neighbourVertex.getRow() >= 0)
                    && (neighbourVertex.getColumn() < 12 && neighbourVertex.getColumn() >= 0))) {
                continue;
            }

            //проверка является ли поле проходимым (выделить проверку в метод?)
            //Entity entity;
            if(simulationMap.ifVertexExist(neighbourVertex)) {
                Entity entity = simulationMap.getGameEntity(neighbourVertex);
                if (isImplementBlock(entity, Blockable.class)) {
                    System.out.println("сосед не подходит " + neighbourVertex.toString());
                    System.out.print("сосед является непроходимым? ");
                    System.out.println(entity instanceof Blockable);
                    continue;
                }
            }

            neighboursVertex.add(neighbourVertex);
        }
        return neighboursVertex;
    }

    private boolean isImplementBlock(Object object, Class<Blockable> interfaceClass) {
        return interfaceClass.isAssignableFrom(object.getClass());
    }
}
