package ru.job4j.chess;

public class FigureNotFoundException extends Exception {
    FigureNotFoundException() {
        super("FigureNotFoundException");
        System.out.print("FigureNotFoundException");
    }
}
