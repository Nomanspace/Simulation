package org.nomanspace.gamefield;

import java.util.Objects;

public class Vertex {
    private final int column;
    private final int row;

    /*public Vertex(int row, int column) {
        this.row = row;
        this.column = column;
    }*/

    public Vertex(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    /*public Vertex setRow(int row) {
        this.row = row;
        return this;
    }*/

    public int getColumn() {
        return column;
    }

    /*public Vertex setColumn(int column) {
        this.column = column;
        return this;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return row == vertex.row && column == vertex.column;
    }

    @Override
    public String toString() {
        return "y" + row +
                "x" + column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
