package ru.job4j.chess;

public class Board {
    private Figure[] figures;

    public Board(Figure[] figures) {
        this.figures = figures;
    }

    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure figureFound = null;
        for (Figure figure: figures) {
            if(source.equals(figure.position)) {
                figureFound = figure;
                break;
            }
        }
        if (figureFound == null) {
            throw new FigureNotFoundException("The figure was not found");
        }
        try {
            Cell[] cells = figureFound.way(dist);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        }

        return true;
    }
}
