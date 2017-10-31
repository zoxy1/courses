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
            while (x < xDist && y < yDist) {
                x++;
                y++;
                cells[indexCell] = new Cell(x, y);
                indexCell++;
            }
            x = this.position.getX();
            y = this.position.getY();
            while (x > xDist && y > yDist) {
                x--;
                y--;
                cells[indexCell] = new Cell(x, y);
                indexCell++;
            }
            x = this.position.getX();
            y = this.position.getY();
            while (x > xDist && y < yDist) {
                x--;
                y++;
                cells[indexCell] = new Cell(x, y);
                indexCell++;
            }
            x = this.position.getX();
            y = this.position.getY();
            while (x < xDist && y > yDist) {
                x++;
                y--;
                cells[indexCell] = new Cell(x, y);
                indexCell++;
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
