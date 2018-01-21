package ru.job4j.chess;

public abstract class Figure {

    private final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    abstract Figure clone(Cell cell);

    public Cell getPosition() {
        return position;
    }
}
