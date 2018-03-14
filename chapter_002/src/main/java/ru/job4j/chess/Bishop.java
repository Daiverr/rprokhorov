package ru.job4j.chess;

public class Bishop extends Figure{
    public Bishop(Cell position) {
        super(position);
    }

    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] cell = new Cell[dest.x - source.x - 1];
        if(Math.abs(dest.y - source.y) == Math.abs(dest.x - source.x)) {
            for (int i = 0; i < Math.abs(dest.x - source.x) - 1; i++) {
                cell[i] = new Cell(source.x + 1 + i, source.y + 1 + i);
            }
            return cell;
        } else {
            throw new ImpossibleMoveException();
        }

    }

    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
