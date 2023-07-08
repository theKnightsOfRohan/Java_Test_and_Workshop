package SummerHWAPCS;

public class PS3 {
    public static void main(String[] args) {
        System.out.println(findPrimeLargerThan(90));
    }
    
    public static int max(int a, int b, int c) {
        int initialMax = Math.max(a, b);
        return Math.max(initialMax, c);
    }

    public static double average(int a, int b, int c, int d) {
        return (a + b + c + d) / 4.0;
    }

    public static void displayNTimes(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(str);
        }
    }

    public static String getRepeatedMessage(String str, int n) {
        String output = "";
        for (int i = 0; i < n; i++) {
            output += str;
        }

        return output;
    }

    public static void weaveStrings(String a, String b) {
        System.out.println(b + a + b + a);
    }

    public static boolean sameLastLetter(String a, String b) {
        if (a.length() == 0 || b.length() == 0) return false;
        else return a.charAt(a.length() - 1) == b.charAt(b.length() - 1);
    }

    public static void doubleDisplay(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            System.out.print(str.charAt(i));
        }
    }

    public static void insert(String a, String b) {
        for (int i = 0; i < a.length() - 1; i++) {
            System.out.print(a.charAt(i));
            System.out.print(b);
        }
        System.out.print(a.charAt(a.length() - 1));
    }

    public static int countLetter(char a, String b) {
        int count = 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == a) count++;
        }

        return count;
    }

    public static void weaveTwo(String a, String b) {
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                System.out.print(a.charAt(i));
                System.out.print(b.charAt(i));
            }
        }
    }

    public static int countFactors(int n) {
        int count = 2; // 1 and n are always factors
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (n < 0) {
            n *= -1;
            count++;
        }


        for (int i = 2; i < n/2; i++) {
            if (n % i == 0) count++;
        }

        return count;
    }

    public static int findPrimeLargerThan(int n) {
        int i = n + 1;
        while (true) {
            if (countFactors(i) == 2) return i;
            i++;
        }
    }
}
