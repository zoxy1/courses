package ru.job4j.chess;

public class Elephant extends Figure {
    public Elephant(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        Cell[] cells = new Cell[7];
        int indexCell = 0;
        if (Math.abs(this.position.getX() - dist.getX()) == Math.abs(this.position.getY() - dist.getY())) {
            int xDist = dist.getX();
            int yDist = dist.getY();
            int x = this.position.getX();
            int y = this.position.getY();
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
            while (true) {
                x = x + signX;
                y = y + signY;
                cells[indexCell] = new Cell(x, y);
                indexCell++;
                if (x == xDist || y == yDist) {
                    break;
                }
            }
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
