package ru.job4j.chess;

/**
 * Board.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Board {
    int numb = 0;

    public void add(Figure figure) {
        figures[numb++] = figure;
    }

    Figure[] figures = new Figure[2];

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        boolean move = false;
        Figure figureFound = null;
        int number = 0;
        for (Figure figure: figures) {
            if (figure.position.x == (source.x) & figure.position.y == (source.y)) {
                figureFound = figure;
                move = true;
                figure = figure.copy(dest);
            } else if (move == false) {
                number++;
                if (number == numb) {
                    throw new FigureNotFoundException();
                }
            }
            for (Cell cell: figureFound.way(source, dest)) {
                if (figure.position.x == (cell.x) & figure.position.y == (cell.y)) {
                    throw new OccupiedWayException();
                }
            }
        }
        return move;
    }
}
/*
Cell cell = bishop.way( sourse, dest);
   if(cell
 */