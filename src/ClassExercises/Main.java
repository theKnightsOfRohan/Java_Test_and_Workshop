package ClassExercises;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }
}

class BankUser {
    String firstName;
    String lastName;
    int[] birthDate = new int[3];
    String[] address = new String[3];
    String phoneNumber;
    String email;

    public BankUser() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Creating a new bank user...");

            System.out.print("Please input your full name: ");
            String fullName = input.nextLine();
            this.firstName = fullName.split(" ")[0];
            this.lastName = fullName.split(" ")[1];
            System.out.println("Name received: " + this.firstName + " " + this.lastName);

            System.out.print("Please input your birth date (MM/DD/YYYY): ");
            String birthDate = input.nextLine();
            this.birthDate[0] = Integer.parseInt(birthDate.split("/")[0]);
            this.birthDate[1] = Integer.parseInt(birthDate.split("/")[1]);
            this.birthDate[2] = Integer.parseInt(birthDate.split("/")[2]);
            System.out.println("Birth date received: " + this.birthDate[0] + "/" + this.birthDate[1] + "/" + this.birthDate[2]);

            System.out.print("Please input your address (street address, city, state): ");
            String address = input.nextLine();
            this.address = address.split(", ");
            System.out.println("Address received: " + this.address[0] + ", " + this.address[1] + ", " + this.address[2]);

            System.out.print("Please input your phone number (XXX-XXX-XXXX): ");
            this.phoneNumber = input.nextLine();
            System.out.println("Phone number received: " + this.phoneNumber);

            System.out.print("Please input your email address: ");
            this.email = input.nextLine();
            System.out.println("Email address received: " + this.email);

            System.out.println("Bank user created successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    // Create a method which prints all of the client's info in a readable format.
    public void printInfo() {
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Birth Date: " + this.birthDate[0] + "/" + this.birthDate[1] + "/" + this.birthDate[2]);
        System.out.println("Address: " + this.address[0] + ", " + this.address[1] + ", " + this.address[2]);
        System.out.println("Phone Number: " + this.phoneNumber);
        System.out.println("Email: " + this.email);
    }
}

class Dog {
    String name;
    String breed;
    int age;
    double friendliness;

    public Dog() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Creating a new pet...");

            System.out.print("Please input your pet's name: ");
            this.name = input.nextLine();
            System.out.println("Name received: " + this.name);

            int randomBreed = (int)(Math.random() * 3);
            String[] possibleBreeds = {"Golden Retriever", "Poodle", "German Shepherd"};
            this.breed = possibleBreeds[randomBreed];
            System.out.println(this.name + " is a " + this.breed + ".");

            this.age = (int)(Math.random() * 10/7);
            System.out.println(this.name + " is " + this.age + " years old.");

            this.friendliness = Math.random() * 10;
            if (this.friendliness > 5) {
                System.out.println(this.name + " is curious about you.");
            } else {
                System.out.println(this.name + " is wary of you.");
            }

            System.out.println("You are now the new owner of " + this.name + "!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }
}

class Card {
    String suit;
    int value;
    String name;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;

        switch (value) {
            case 1:
                this.name = "Ace of " + suit;
                break;
            case 11:
                this.name = "Jack of " + suit;
                break;
            case 12:
                this.name = "Queen of " + suit;
                break;
            case 13:
                this.name = "King of " + suit;
                break;
            default:
                this.name = value + " of " + suit;
                break;
        }

        System.out.println("Created a new card: " + this.name);
    }
}

class Ballot {
    String[] candidates = {"Donald Trump", "Joe Biden", "Kanye West"};
    String vote;

    public Ballot() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Creating a new ballot...");

            System.out.println("Please input your vote for one of these candidates: " + this.candidates[0] + ", " + this.candidates[1] + ", " + this.candidates[2] + ".");
            System.out.print("Input a 1, 2, or 3 to vote for one of the candidates:");
            int voterIndex = input.nextInt() - 1;
            this.vote = this.candidates[voterIndex];
            System.out.println("Vote received: " + this.vote);

            System.out.println("Ballot filled successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }
}