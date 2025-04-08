package org.nomanspace.pathfinder;

import org.nomanspace.gamefield.Vertex;

class PriorityNode implements Comparable<PriorityNode> {
    private final Vertex vertex;
    private final int priority; // Значение f(x) = g(x) + h(x)

    PriorityNode(Vertex vertex, int priority) {
        this.vertex = vertex;
        this.priority = priority;
    }

    public Vertex getVertex() {
        return vertex;
    }

    @Override
    public int compareTo(PriorityNode other) {
        return Integer.compare(this.priority, other.priority);
    }
}
