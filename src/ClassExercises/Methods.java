package ClassExercises;

import java.util.ArrayList;

public class Methods {
    public static void main(String[] args) {
        // Write some tests for the mergeTwo method
        String[] arr1 = {"a", "c", "z"};
        String[] arr2 = {"b", "f", "z"};
        String[] arr3 = {"a", "c", "z"};
        String[] arr4 = {"c", "f", "z"};
        String[] arr5 = {"f", "g", "z"};
        String[] arr6 = {"c", "f", "g"};

        String[] mergedArr1 = mergeTwo(arr1, arr2, 3);
        String[] mergedArr2 = mergeTwo(arr3, arr4, 3);
        String[] mergedArr3 = mergeTwo(arr5, arr6, 3);

        printStringArray(mergedArr1);
        printStringArray(mergedArr2);
        printStringArray(mergedArr3);
    }

    /*
        Start with two arrays of strings, A and B, each with its elements in alphabetical order and without duplicates. 
        Return a new array containing the first N elements from the two arrays. 
        The result array should be in alphabetical order and without duplicates. A and B will both have a length which is N or more. 
        The best "linear" solution makes a single pass over A and B, taking advantage of the fact that they are in alphabetical order, copying elements directly to the new array.

        mergeTwo(["a", "c", "z"], ["b", "f", "z"], 3) → ["a", "b", "c"]
        mergeTwo(["a", "c", "z"], ["c", "f", "z"], 3) → ["a", "c", "f"]
        mergeTwo(["f", "g", "z"], ["c", "f", "g"], 3) → ["c", "f", "g"]
     */
    public static String[] mergeTwo(String[] arr1, String[] arr2, int n) {
        String[] newArr = new String[n];
        int arr1Index = 0;
        int arr2Index = 0;
        int newArrIndex = 0;

        while (newArrIndex < n) {
            if (arr1[arr1Index].compareTo(arr2[arr2Index]) < 0) {
                newArr[newArrIndex] = arr1[arr1Index];
                arr1Index++;
            } else if (arr1[arr1Index].compareTo(arr2[arr2Index]) > 0) {
                newArr[newArrIndex] = arr2[arr2Index];
                arr2Index++;
            } else {
                newArr[newArrIndex] = arr1[arr1Index];
                arr1Index++;
            }

            newArrIndex++;
        }

        return newArr;
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

    public static void printIntArray(int[] arr) {
        System.out.print("[");
        for (int num : arr) {
            System.out.print(num + ", ");
        }
        System.out.println("]");
    }

    public static void printStringArray(String[] arr) {
        System.out.print("[");
        for (String str : arr) {
            System.out.print(str + ", ");
        }
        System.out.println("]");
    }
}
