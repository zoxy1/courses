package ru.job4j.chess;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Zoxy1 on 31.10.17.
 */
public class BoardTest {
    @Test(expected = FigureNotFoundException.class)
    public void figureNotFoundExceptionWhenNotFigureOnBoard() {
        Figure[] figures = new Figure[]{new Elephant(new Cell(1, 1)), new Elephant(new Cell(8, 8))};
        Board board = new Board(figures);
        board.move(new Cell(2, 2), new Cell(3, 3));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void figureImpossibleMoveExceptionWhenNotWayAvailable() {
        Figure[] figures = new Figure[]{new Elephant(new Cell(1, 1)), new Elephant(new Cell(8, 8))};
        Board board = new Board(figures);
        board.move(new Cell(1, 1), new Cell(2, 1));
    }

    @Test(expected = OccupiedWayException.class)
    public void figureOccupiedWayExceptionWhenPositionBusy() {
        Figure[] figures = new Figure[]{new Elephant(new Cell(1, 1)), new Elephant(new Cell(8, 8))};
        Board board = new Board(figures);
        board.move(new Cell(1, 1), new Cell(8, 8));
    }

    @Test
    public void figureMoveToNePositionWhenMoveToNewPosition() {
        Figure[] figures = new Figure[]{new Elephant(new Cell(1, 1)), new Elephant(new Cell(8, 8))};
        Board board = new Board(figures);
        Cell positionDist = new Cell(7, 7);
        assertTrue(board.move(new Cell(1, 1), positionDist));
        Cell positionActual = board.getFigures()[0].position;
        assertTrue(positionDist.equals(positionActual));
    }
}
