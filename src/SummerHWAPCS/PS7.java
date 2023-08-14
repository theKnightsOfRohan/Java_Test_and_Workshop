package SummerHWAPCS;

import java.util.ArrayList;

public class PS7 {
    public static void main(String[] args) {
        Person[] people = new Person[100];
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person((int) (Math.random() * 54 + 12), "Bob", Math.random() < 0.5, Math.random() < 0.5);
        }

        for (int i = 1; i < people.length; i++) {
            if (people[0].isMatch(people[i]))
                System.out.println(people[i].getName() + " is a match for " + people[0].getName());
        }
        for (int i = 1; i < people.length; i++) {
            if (people[0].canDate(people[i]) && !people[0].isMatch(people[i]))
                System.out.println(people[i].getName() + " could date " + people[0].getName() + " but isn't a match");
        }
    }

    public static String getRandomPair(String[] arr) {
        int rand1 = (int) (Math.random() * arr.length);
        int rand2 = (int) (Math.random() * arr.length);
        return arr[rand1] + " " + arr[rand2];
    }

    public static String getRandomFromLastN(String[] arr, int n) {
        if (n > arr.length)
            return "";

        int rand = (int) (Math.random() * n);
        return arr[arr.length - n + rand];
    }

    public int countProducts(ArrayList<Product> productList, double maxPrice, double minRating) {
        int count = 0;
        for (Product p : productList) {
            if (p.getPrice() < maxPrice && p.getAverageRating() > minRating)
                count++;
        }
        return count;
    }
}

class Product {
    private double price;
    private double averageRating;

    public Product(double price, double averageRating) {
        this.price = price;
        this.averageRating = averageRating;
    }

    public double getPrice() {
        return price;
    }

    public double getAverageRating() {
        return averageRating;
    }
}

class Person {
    private int age;
    private String name;
    private boolean isMessy;
    private boolean needsMessyMatch;

    public Person(int age, String name, boolean isMessy, boolean needsMessyMatch) {
        this.age = age;
        this.name = name;
        this.isMessy = isMessy;
        this.needsMessyMatch = needsMessyMatch;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsMessy() {
        return this.isMessy;
    }

    public boolean getNeedsMessyMatch() {
        return this.needsMessyMatch;
    }

    public String toString() {
        return "Name: " + this.name + "\nAge: " + this.age + "\nIs Messy: " + this.isMessy + "\nNeeds Messy Match: "
                + this.needsMessyMatch;
    }

    public boolean canDate(Person other) {
        if (this.age < 14)
            return false;

        int minAge = this.age / 2 + 7;
        int maxAge = (this.age - 7) * 2;

        return other.getAge() >= minAge && other.getAge() <= maxAge;
    }

    public boolean isMatch(Person other) {
        if (!canDate(other))
            return false;

        if (needsMessyMatch && other.getNeedsMessyMatch())
            return this.isMessy == other.getIsMessy();

        if (needsMessyMatch)
            return this.isMessy;

        if (other.getNeedsMessyMatch())
            return other.getIsMessy();

        return true;
    }
}