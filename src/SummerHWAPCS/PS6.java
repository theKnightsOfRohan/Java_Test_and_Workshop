package SummerHWAPCS;

import java.util.ArrayList;
import java.util.Collections;

public class PS6 {
    public static void main(String[] args) {
        SingleOrder order1 = new SingleOrder("Apple", 1.50f, 5);
        SingleOrder order2 = new SingleOrder("Banana", 2.00f, 3);

        System.out.println(order1.getProductName() + " " + order1.getPrice() + " " + order1.getQuantity());
        System.out.println(order2.getProductName() + " " + order2.getPrice() + " " + order2.getQuantity());

        order1.setProductName("Orange");
        order1.setPrice(2.00f);
        order1.setQuantity(10);

        System.out.println(order1.getProductName() + " " + order1.getPrice() + " " + order1.getQuantity());

        ArrayList<SingleOrder> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        System.out.println(computeTotalCost(orders));
    }

    public static void problem1() {
        ArrayList<Integer> deck = new ArrayList<>();
        for (int i = 2; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(i);
            }
        }

        Collections.shuffle(deck);

        System.out.println(deck);
    }

    public static int getLargestVal(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    public static int getSmallestVal(int[] arr) {
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        return smallest;
    }

    public static int getIndexOfLargestVal(int[] arr) {
        int largest = arr[0];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
                index = i;
            }
        }

        return index;
    }

    public static Burrito getMostDeliciousBurrito(ArrayList<Burrito> burritos, int maxPrice) {
        Burrito mostDelicious = new Burrito(0, 0);
        for (Burrito burrito : burritos) {
            if (burrito.getDeliciousnessLevel() > mostDelicious.getDeliciousnessLevel() && burrito.getCost() <= maxPrice) {
                mostDelicious = burrito;
            }
        }

        return mostDelicious;
    }

    public static float computeTotalCost(ArrayList<SingleOrder> orders) {
        float totalCost = 0;
        for (SingleOrder order : orders) {
            totalCost += order.getPrice() * order.getQuantity();
        }

        return totalCost;
    }
}

class Burrito {
    private float cost;
    private int deliciousnessLevel;

    public Burrito (float cost, int deliciousnessLevel) {
        this.cost = cost;
        this.deliciousnessLevel = deliciousnessLevel;
    }

    public float getCost() {
        return cost;
    }

    public int getDeliciousnessLevel() {
        return deliciousnessLevel;
    }
}

class SingleOrder {
    private String productName;
    private float price;
    private int quantity;

    public SingleOrder(String productName, float price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() { return productName; }

    public float getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public String setProductName(String productName) {
        this.productName = productName;
        return productName;
    }

    public float setPrice(float price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        this.price = price;
        return price;
    }

    public int setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        this.quantity = quantity;
        return quantity;
    }
}
