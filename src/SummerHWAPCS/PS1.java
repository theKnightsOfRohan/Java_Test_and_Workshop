package SummerHWAPCS;

import java.util.Scanner;

public class PS1 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            roll2Dice();
        }
    }

    public static void getCircleArea() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = input.nextDouble();
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("The area of the circle is " + area);
    }

    public static double calculateTriangleAreaHeron(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's formula
    }

    public static double windChill(double temp, double windSpeed) {
        if (Math.abs(temp) > 50 || windSpeed < 3 || windSpeed > 120) {
            return temp;
        } else {
            return 35.74 + 0.6215 * temp - 35.75 * Math.pow(windSpeed, 0.16) + 0.4275 * temp * Math.pow(windSpeed, 0.16);
        }
    }

    public static int roll2Dice() {
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        int sum = die1 + die2;
        System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);
        return sum;
    }
}
