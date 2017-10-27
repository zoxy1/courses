package ru.job4j.chess;

public class Elephant extends Figure {
    public Elephant(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        if (Math.abs(this.position.getX()- dist.getX()) == Math.abs(this.position.getY() - dist.getY())){

        } else {
            throw new ImpossibleMoveException("Impossible move figure");
        }

        return new Cell[0];
    }
}
