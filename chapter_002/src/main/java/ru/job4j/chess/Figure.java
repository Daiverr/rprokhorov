package ru.job4j.chess;

/**
 * Figure.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public abstract class Figure {

    final Cell position;

    public Figure(Cell position){
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract Figure copy(Cell dest);
}
