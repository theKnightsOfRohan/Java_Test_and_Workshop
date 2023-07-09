package SummerHWAPCS;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class PS2 {
    public static void main(String[] args) {
        printX();
    }

    public static void twentyToHundredEvenThrees() {
        for (int i = 20; i <= 100; i++) {
            String output = "" + i;
            if (i % 2 == 0) {
                if (i % 3 == 0) {
                    output = "WONK";
                } else {
                    output = "*" + output;
                }
            } else if (i % 3 == 0) {
                output = output + " hi";
            }
            System.out.println(output);
        }
    }

    public static void randomTwoInput() {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 15; i++) {
            int num1 = (int)(Math.random() * 20) + 1;
            int num2 = (int)(Math.random() * 20) + 1;
            
            int guess;
            System.out.println("Guess a number: ");
            guess = input.nextInt();
            input.nextLine(); //Consumes the enter thingy which remains when you do input.nextInt()

            int[] nums = {num1, num2, guess};
            Arrays.sort(nums);
            for (int num : nums) {
                System.out.print(num + " ");
            }

            System.out.println("");
        }

        input.close();
    }

    public static ArrayList<Integer> createList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 3; i < 15; i++) {
            list.add(i * 10);
        }
        return list;
    }

    public static void tenToFifteenHostage() {
        Scanner input = new Scanner(System.in);
        int num = 0;
        do {
            System.out.println("Enter a number between 10 and 15: ");
            num = input.nextInt();
            input.nextLine();
        } while (num <= 10 || num >= 15);

        input.close();
    }

    public static void roll3DiceUntilAll1s() {
        int die1 = 0;
        int die2 = 0;
        int die3 = 0;
        int count = 0;
        do {
            die1 = (int)(Math.random() * 6) + 1;
            die2 = (int)(Math.random() * 6) + 1;
            die3 = (int)(Math.random() * 6) + 1;
            count++;
            System.out.println(count + ": " + die1 + ", " + die2 + ", " + die3);
        } while (die1 != 1 || die2 != 1 || die3 != 1);

        System.out.println("It took " + count + " rolls to get all 1s.");
    }

    public static void forToWhile() {
        int num = 10;
        while (num > 2) {
            System.out.println("Num is: " + num);
            num--;
        }
    }

    public static void doubleForBlock() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int num = (i - j < 0) ? 0 : i - j;
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }

    public static void printTriangleInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();
        input.nextLine();
        input.close();

        for (int i = num; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public static void printX() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a positive number: ");
        int num = input.nextInt() * 2 + 1;
        input.nextLine();
        input.close();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (j == i || j == num - i - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println("");
        }
    }
}