package com.myapp;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random(); //initializes the random number generator

        System.out.println("Welcome to the Virtual Cafe Simulator!");
        System.out.print("Enter your cafe name: ");
        String cafeName = input.nextLine();
        //the cafe starts off with a balance of $50.0
        Cafe myCafe = new Cafe(cafeName, 50.0);

        // What the cafe menu has
        MenuItem[] menu = new MenuItem[3];
        menu[0] = new Drink("Coffee", 3.0, 1, "Hot");
        menu[1] = new Drink("Iced Tea", 2.5, 1, "Cold");
        menu[2] = new Food("Sandwich", 5.0, 2, 350);
        Drink coffee = new Drink("Coffee", 3.0, 1, "Hot");
        Food sandwich = new Food("Sandwich", 5.0, 2, 350);
        Drink icedTea = new Drink("Iced Tea", 2.5, 1, "Cold");

        System.out.println("\nYour cafe, " + myCafe.getName() + ", is now open!\n");
        //prints out the menu for the day
        System.out.println("Here is your menu for the day:");
        coffee.displayInfo();
        icedTea.displayInfo();
        sandwich.displayInfo();
        System.out.println("\n\n");

        // simulate 3 days of the cafe being open
        for (int day = 1; day <= 3; day++) {
            System.out.println("Day " + day + " begins:");
            myCafe.simulateDay(rand, input, menu); //gets a random number of customers between 2 and 4 and processes their orders from the  Cafe.java class
            System.out.println("\nEnd of Day " + day + ". Balance: $" + myCafe.getBalance()); //shows the balance after the day ends
            System.out.print("Would you like to restock inventory? (yes/no): "); 
            String restock = input.nextLine();

            if (restock.equalsIgnoreCase("yes")) { //makes sure that even if you say Yes, YES, or yes its still the same
                //gets the amount that the user wants to restock for each ingredient that the cafe has
                System.out.print("Enter amount of beans to restock: ");
                int beans = input.nextInt();
                System.out.print("Enter amount of bread to restock: ");
                int bread = input.nextInt();
                System.out.print("Enter amount of tea leaves to restock: ");
                int tea = input.nextInt();
                input.nextLine();

                myCafe.restock(beans, bread, tea); //calls the restock method from the cafe.java class so that the inventory gets however more bread that the user requests
            }

            System.out.println("\n\n\n");
        }

        System.out.println("Simulation complete!");
        //prints teh final balance of the cafe after the three days of operation
        System.out.println("Final balance: $" + myCafe.getBalance());
        input.close();
    }
}
