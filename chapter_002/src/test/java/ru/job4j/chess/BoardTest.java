package ru.job4j.chess;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void whenMoveFigure() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        boolean result = false;
        Board board = new Board();
        Figure bishop = new Bishop(new Cell(2, 0));
        Figure bishop2 = new Bishop(new Cell(0, 0));
        board.add(bishop);
        board.add(bishop2);
        result = board.move(new Cell(2,0), new Cell(5, 3));
        assertThat(result, is(true));
    }

    @Test
    public void whenMoveFigure2() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        boolean result = false;
        Board board = new Board();
        Figure bishop = new Bishop(new Cell(2, 0));
        Figure bishop2 = new Bishop(new Cell(0, 0));
        board.add(bishop);
        board.add(bishop2);
        board.move(bishop.position, new Cell(5, 3));
        bishop = bishop.copy(new Cell(5, 3));
        assertThat(bishop.position.x, is(5));
        assertThat(bishop.position.y, is(3));

    }
}
