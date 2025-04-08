package org.nomanspace;

import org.nomanspace.Entity.Rock;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.gamefield.Vertex;
import org.nomanspace.pathfinder.PathFinder;
import org.nomanspace.render.ImageRender;

import java.util.List;

public class Main {
    //по итогу в мейне останется только точка входа

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.startSimulation();
        //PossibleDirection possibleDirection = new PossibleDirection();
        //Map gameField = Map.gameFieldGenerate();
        //SimulationMap gameField = new SimulationMap();
        //ImageRender imageRender = new ImageRender(gameField);
        //imageRender.printField(gameField);
        //Predator predator = new Predator();
        //gameField.placeGameEntity(0, 0, predator);
        //imageRender.printField(gameField);
        //Herbivore herbivore = new Herbivore();
        //gameField.placeGameEntity(5, 0, herbivore);
        //gameField.placeGameEntity(1,5, new Rock());
        //gameField.placeGameEntity(1,6, new Rock());
        //gameField.placeGameEntity(1,4, new Rock());
        //gameField.placeGameEntity(2,4, new Rock());

        //System.out.println("X" + herbivore.getCurrentCoordinateX() + " Y" + herbivore.getCurrentCoordinateY());
        //gameField.removeEntity(0, 0);
        //imageRender.printField(gameField);

        // Set<java.util.Map.Entry<String, Entity>> entryS = gameField.cellMap.entrySet();
        //entryS.forEach(System.out::println);
        //possibleDirection.upStep(herbivore, gameField);
        //possibleDirection.delta(Direction.UPSTEP,herbivore,gameField);
        //imageRender.printField(gameField);
        //System.out.println("X" + herbivore.getCurrentCoordinateX() + " Y" + herbivore.getCurrentCoordinateY());
        //Vertex start = new Vertex(2, 6);
        //Vertex goal = new Vertex(2, 5);
        //Graph graph = new Graph(gameField);
        //PathFinder pathFinder = new PathFinder(gameField);
        //pathFinder.searchPath(start,goal);
        //System.out.println(pathFinder.reconstructPath());
        //List<Vertex> tempList = pathFinder.reconstructPath();
        //System.out.println(tempList.get(1));
    /*
            x0    x1    x2    x3    x4    x5    x6    x7    x8    x9    x10   x11
        y0 [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]
        y1 [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]
        y2 [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]
        y3 [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]
        y4 [ . ] [ R ] [ R ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]
        y5 [ . ] [ R ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]
        y6 [ . ] [ R ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]
        y7 [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]
        мы сейчас находимся y6x2
        5 2
        7 2
        6 1
        6 3
        edgeCost 1
        gCurrentToNeighbor 1
        y5x2 y5x2
        Y=0 X=3
        для соседа y5x2 Эвристика= 0 полная стоимость= 1
        edgeCost 1
        gCurrentToNeighbor 1
        y7x2 y5x2
        Y=2 X=3
        для соседа y7x2 Эвристика= 2 полная стоимость= 3
        edgeCost 1
        gCurrentToNeighbor 1
        y6x1 y5x2
        Y=1 X=4
        для соседа y6x1 Эвристика= 2 полная стоимость= 3
        edgeCost 1
        gCurrentToNeighbor 1
        y6x3 y5x2
        Y=1 X=2
        для соседа y6x3 Эвристика= 2 полная стоимость= 3
        мы сейчас находимся y5x2
        [y6x2, y5x2]
        y5x2
    */

    }
}