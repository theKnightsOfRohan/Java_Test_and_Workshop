package ClassExercises;

import java.util.ArrayList;

public class Methods {
    public static void main(String[] args) {
        System.out.println(roll2Dice());
        System.out.println(roll2Dice());
    }
    
    public static int countEven(int[] nums) {
        int evenCount = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        return evenCount;
    }

    public static int roll2Dice() {
        return (int)(Math.random() * 6) + 1 + (int)(Math.random() * 6) + 1;
    }

    public static void flipArr(int[] arr) {
        int placeholder = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = placeholder;
    }

    public static boolean rowContains(String[][] table, int row, String inputStr) {
        for (String str : table[row]) {
            if (str.equals(inputStr)) {
                return true;
            }
        }
        
        return false;
    }

    public static void extendArr(ArrayList<Integer>[] arr) {
        for (ArrayList<Integer> list : arr) {
            int sum = 0;
            for (int num : list) {
                sum += num;
            }

            if (sum < 100) list.add((int)(Math.random() * 46));
        }
    }
}
