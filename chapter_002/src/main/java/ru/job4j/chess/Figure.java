package ru.job4j.chess;

public abstract class Figure {
    protected final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    abstract Figure clone(Cell cell);
}
