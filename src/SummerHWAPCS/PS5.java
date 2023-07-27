package SummerHWAPCS;

import java.util.ArrayList;
import java.util.Scanner;

public class PS5 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) arr[i] = i + 1;
        shuffle(arr);
        printElems(arr);
    }

    public static void problem1() {
        int[] nums = new int[1000];

        for (int i = 0; i < 100; i++) {
            nums[i] = (int) (Math.random() * 10) + 1;
            System.out.println(nums[i]);
        }
    }

    public static void problem2() {
        String[] arr = new String[100];

        String[] names = {"abadaba", "behemoth", "carlheinz", "doctorow"};
        String[] adjs = {"the fallow", "the somewhat large", "the incredibly hungry", "the bemused"};

        for (int i = 0; i < 100; i++) {
            arr[i] = names[(int) (Math.random() * 4)] + " " + adjs[(int) (Math.random() * 4)];
            System.out.println(arr[i]);
        }
    }

    public static boolean doesntContain2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                return false;
            }
        }

        return true;
    }

    public static boolean doesntContain2or5(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2 || arr[i] == 5) {
                return false;
            }
        }

        return true;
    }

    public static boolean more2than5(int[] arr) {
        int twos = 0;
        int fives = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                twos++;
            } else if (arr[i] == 5) {
                fives++;
            }
        }

        return twos > fives;
    }

    public static boolean contains(int[] arr, int num, int amt) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            }
        }

        return count >= amt;
    }

    public static boolean areEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }

    public static void intervalTest() {
        ArrayList<Interval> intervals = new ArrayList<Interval>();

        for (int i = 0; i < 100; i++) {
            float a = (float)(Math.random() * 500);
            float b = (float)(Math.random() * 500);
            intervals.add(new Interval(Math.min(a, b), Math.max(a, b)));
        }

        System.out.print("Enter a value between 0 and 100: ");
        Scanner scanner = new Scanner(System.in);
        float target = scanner.nextFloat();
        scanner.nextLine();
        scanner.close();

        for (Interval i : intervals) {
            if (i.contains(target)) {
                System.out.println(i);
            }
        }
    }

    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int rand = (int) (Math.random() * i);
            int temp = arr[i];
            arr[i] = arr[rand];
            arr[rand] = temp;
        }
    }

    public static void printElems(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }
}

class Interval {
    float start;
    float end;

    public Interval(float start, float end) {
        this.start = start;
        this.end = end;
    }

    public float getStart() { return start; }

    public float getEnd() { return end; }

    public float setStart(float start) { return this.start = start; }

    public float setEnd(float end) { return this.end = end; }

    public boolean contains(float num) {
        return num >= start && num <= end;
    }

    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}
