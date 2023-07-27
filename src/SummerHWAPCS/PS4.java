package SummerHWAPCS;

import java.util.ArrayList;

public class PS4 {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < 100; i++) {
            points.add(new Point((Math.random() * 200) - 100, (Math.random() * 200) - 100));
        }

        Point target = points.get(points.size() - 1);

        for (int i = 0; i < 99; i++) {
            if (points.get(i).areClose(target, 50)) {
                System.out.println(points.get(i).getX() + ", " + points.get(i).getY());
            }
        }

        System.out.println("-----");

        Point furthest = target;

        for (int i = 0; i < 99; i++) {
            if (points.get(i).distanceTo(target) > furthest.distanceTo(target)) {
                furthest = points.get(i);
            }
        }

        System.out.println(furthest.getX() + ", " + furthest.getY() + " is the furthest point from " + target.getX() + ", " + target.getY());

        System.out.println("-----");

        Point closest1 = points.get(0);
        Point closest2 = points.get(1);
        double smallestDistance = closest1.distanceTo(closest2);

        for (int i = 0; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                if (points.get(i).distanceTo(points.get(j)) < closest1.distanceTo(closest2)) {
                    closest1 = points.get(i);
                    closest2 = points.get(j);
                    smallestDistance = closest1.distanceTo(closest2);
                }
            }
        }

        System.out.println(closest1.getX() + ", " + closest1.getY() + " and " + closest2.getX() + ", " + closest2.getY() + " are the closest points in the array, with a distance of " + smallestDistance);
    }
}

class Sphere {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double setRadius(double radius) {
        this.radius = radius;
        return radius;
    }

    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public String toString() {
        return "Sphere: radius=" + radius;
    }

    public boolean isLargerThan(Sphere other) {
        return this.radius > other.radius;
    }
}

class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public double setX(double x) {
        this.x = x;
        return x;
    }

    public double setY(double y) {
        this.y = y;
        return y;
    }

    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public boolean isRightOf(Point other) {
        return this.x > other.x;
    }

    public boolean areClose(Point other, double amt) {
        return this.distanceTo(other) < amt;
    }
}
