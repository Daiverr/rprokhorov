package ru.job4j.chess;

public class OccupiedWayException extends Exception {
    OccupiedWayException() {
        super("OccupiedWayException");
        System.out.print("OccupiedWayException");
    }
}
