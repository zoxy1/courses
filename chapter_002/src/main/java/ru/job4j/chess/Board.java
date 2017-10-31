package ru.job4j.chess;

public class Board {
    private Figure[] figures;

    public Board(Figure[] figures) {
        this.figures = figures;
    }

    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Integer indexFigureFound = null;
        Boolean isMoved = false;
        for (int i = 0; i < this.figures.length; i++) {
            if (source.equals(this.figures[i].position)) {
                indexFigureFound = i;
                break;
            }
        }
        if (indexFigureFound == null) {
            throw new FigureNotFoundException("The figure was not found");
        }
        Cell[] cells = this.figures[indexFigureFound].way(dist);
        for (Figure figure : figures) {
            for (Cell cell : cells) {
                if (figure.position.getX() == cell.getX() && figure.position.getY() == cell.getY()) {
                    throw new OccupiedWayException("Way is occupied.");
                }
            }
        }
        this.figures[indexFigureFound] = this.figures[indexFigureFound].clone(dist);
        isMoved = true;
        return isMoved;
    }

    public Figure[] getFigures() {
        return figures;
    }
}
