package ru.job4j.chess;

public class Bishop extends Figure{
    public Bishop(Cell position) {
        super(position);
    }

    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] cell = new Cell[Math.abs(dest.x - source.x) - 1];
        int xz = source.x;
        int yz = source.y;
        if(Math.abs(dest.y - source.y) == Math.abs(dest.x - source.x)) {
            for (int i = 0; i < Math.abs(dest.x - source.x) - 1; i++) {
                if (dest.x > source.x) {xz++;}
                else xz--;
                if (dest.y > source.y) {yz++;}
                else yz--;
                cell[i] = new Cell(xz, yz);
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
