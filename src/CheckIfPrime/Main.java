package CheckIfPrime;

public class Main {
    public static void main(String[] args) {
        System.out.println(CheckIfPrime(7));
        System.out.println(CheckIfPrime(8));
        System.out.println(CheckIfPrime(9));
        System.out.println(CheckIfPrime(71));
    }

    public static boolean CheckIfPrime(int num) {
        boolean isPrime = true;

        for (int i = 3; i < (int)(num / 2); i++) {
            if (num % i == 0 && i != num) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
