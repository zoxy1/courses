package ru.job4j.chess;

public class Elephant extends Figure {
    public Elephant(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        Cell[] cells = new Cell[7];
        int indexCell = 0;
        if (Math.abs(this.getPosition().getX() - dist.getX()) == Math.abs(this.getPosition().getY() - dist.getY())) {
            int xDist = dist.getX();
            int yDist = dist.getY();
            int x = this.getPosition().getX();
            int y = this.getPosition().getY();
            int signX;
            int signY;
            if (x < xDist) {
                signX = 1;
            } else {
                signX = -1;
            }
            if (y < yDist) {
                signY = 1;
            } else {
                signY = -1;
            }
            do {
                x = x + signX;
                y = y + signY;
                cells[indexCell] = new Cell(x, y);
                indexCell++;
            }
            while (!(x == xDist || y == yDist));
        } else {
            throw new ImpossibleMoveException("Impossible move figure");
        }
        Cell[] cellsAvailableWithoutNull = new Cell[indexCell];
        System.arraycopy(cells, 0, cellsAvailableWithoutNull, 0, indexCell);
        return cellsAvailableWithoutNull;
    }

    @Override
    public Figure clone(Cell cell) {
        return new Elephant(cell);
    }
}
