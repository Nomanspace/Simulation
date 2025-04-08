package org.nomanspace.navigation;

import org.nomanspace.gamefield.Vertex;

public enum Direction {
    UPSTEP(-1,0), DOWNSTEP(1,0), LEFTSTEP(0,-1), RIGHTSTEP(0,1);

    private final int column;

    private final int row;

    Direction(int row, int column) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }


}
