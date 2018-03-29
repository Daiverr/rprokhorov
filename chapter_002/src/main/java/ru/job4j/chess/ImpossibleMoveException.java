package ru.job4j.chess;

class ImpossibleMoveException extends Exception {
    ImpossibleMoveException() {
        super("ImpossibleMoveException");
        System.out.print("ImpossibleMoveException");
    }
}
