package ru.job4j.condition;

/**
 * Point.
 *
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(1, 2);
        Point b = new Point(3, 7);

        System.out.println(a.distanceTo(b));

    }
}
