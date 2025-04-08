package org.nomanspace.pathfinder;

import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.gamefield.Vertex;

import java.util.*;

public class PathFinder {
    private final SimulationMap simulationMap;
    private Graph graph;
    private Queue<PriorityNode> openListFrontier;
    private Set<Vertex> closedList;
    private java.util.Map<Vertex, Integer> costSoFargCostMap;
    private java.util.Map<Vertex, Vertex> cameFromParentMap;

    private Vertex goalVertex;

    public Vertex getGoalVertex() {
        return goalVertex;
    }

    public void setGoalVertex(Vertex goalVertex) {
        this.goalVertex = goalVertex;
    }

    //private Graph graph;
    //List<Vertex> neighboursVertex;
    //PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(a.f, b.f));
    //openList = new PriorityQueue<>((a, b) -> Double.compare(a.f, b.f));
    //new PriorityQueue<>(Comparator.comparingInt(v -> g.getOrDefault(v, Integer.MAX_VALUE)));
    public void searchPath(Vertex start, Vertex end) {
        //openListFrontier.add(start);
        openListFrontier.add(new PriorityNode(start, 0));
        cameFromParentMap.put(start, null);
        costSoFargCostMap.put(start, 0);

        while (!openListFrontier.isEmpty()) {
            PriorityNode priorityNode = openListFrontier.poll();
            Vertex currentVertex = priorityNode.getVertex();
            System.out.println("мы сейчас находимся " + currentVertex);
            if (currentVertex.equals(end)) {
                //cameFromParentMap.put(end, null);
                //setGoalVertex(end);
                //return reconstructPath(end);
                return;
            }
            closedList.add(currentVertex);
            List<Vertex> neighboursGraph;
            //graph.getNeighbours(current)
            neighboursGraph = graph.getNeighbours(currentVertex,simulationMap);
            Iterator<Vertex> iterator = neighboursGraph.iterator();
            for (Vertex neighbor : neighboursGraph) {
                Vertex counter = iterator.next();
                if (closedList.contains(neighbor)) {
                    continue;
                }
                int edgeCost = graph.getCost(currentVertex, neighbor);//g
                System.out.println("edgeCost " + edgeCost);
                int gCurrentCostToNeighbor = costSoFargCostMap.get(currentVertex) + edgeCost;
                System.out.println("gCurrentToNeighbor " + gCurrentCostToNeighbor);

                if (!costSoFargCostMap.containsKey(neighbor) ||
                        gCurrentCostToNeighbor < costSoFargCostMap.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    costSoFargCostMap.put(neighbor, gCurrentCostToNeighbor);
                    int heuristicCost = heuristic(neighbor, end);  // Эвристическая оценка стоимости до цели
                    int totalCost = gCurrentCostToNeighbor + heuristicCost;  // Полная стоимость (f = g + h)
                    System.out.println("для соседа " + neighbor + " Эвристика= " + heuristicCost + " полная стоимость= " + totalCost);
                    //openListFrontier.add(neighbor);  // Добавляем соседа в открытый список
                    openListFrontier.add(new PriorityNode(neighbor, totalCost));
                    if (!iterator.hasNext()) {
                        cameFromParentMap.put(openListFrontier.peek().getVertex(), currentVertex);  // Обновляем предка для соседа
                    }
                }

            }

        }
        //return null;
    }

    public PathFinder(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
        this.graph = new Graph();
        /*
        getOrDefault(v, Integer.MAX_VALUE) — метод, который возвращает значение, ассоциированное с ключом v в Map g.
        Если ключ v не найден в Map, возвращается значение по умолчанию — Integer.MAX_VALUE
        */
        /*this.openListFrontier = new PriorityQueue<>(Comparator.comparingInt(
                vertex -> costSoFargCostMap.getOrDefault(vertex, Integer.MAX_VALUE) + heuristic(vertex, end)));*/
        this.openListFrontier = new PriorityQueue<>();
        this.cameFromParentMap = new LinkedHashMap<>();
        this.closedList = new HashSet<>();
        this.costSoFargCostMap = new HashMap<>();
    }


    /*function A*(start, goal, f)
            % множество уже пройденных вершин
    var closed := the empty set
    java: list closed = new arrlist;
     % множество частных решений
    var open := make_queue(f)
    Java: List open = new arrlist;
    enqueue(open, path(start))
            while open is not empty
    var p := remove_first(open)
    var x := the last node of p
         if x in closed
             continue
                     if x = goal
             return p
    add(closed, x)
         % добавляем смежные вершины
    foreach y in successors(x)
    enqueue(open, add_to_path(p, y))
            return failure*/

    public int heuristic(Vertex a, Vertex b) {
        //h(n) = |x_цель - x_текущее| + |y_цель - y_текущее|
        //int cost = Math.abs(a.getY() - b.getY()) + Math.abs(a.getX() - b.getY());
        System.out.println(a + " " + b);
        System.out.println("Y=" + Math.abs(a.getRow() - b.getRow()) + " X=" + Math.abs(a.getColumn() - b.getRow()));
        return Math.abs(a.getRow() - b.getRow()) + Math.abs(a.getColumn() - b.getColumn());
    }


    /*public List<java.util.Map.Entry<Vertex, Vertex>> reconstructPath() {
        List<java.util.Map.Entry<Vertex, Vertex>> path;
        //Vertex current = getGoalVertex();
        path = cameFromParentMap.entrySet().stream().toList();
        *//*while (current != null) {
            path.add(current);
            current = cameFromParentMap.get(current);
        }*//*
        //Collections.reverse(path); // Инвертируем путь, чтобы получить путь от старта до цели
        return path;
    }*/
    public ArrayList<Vertex> reconstructPath() {
        return new ArrayList<>(cameFromParentMap.keySet());
    }

}
