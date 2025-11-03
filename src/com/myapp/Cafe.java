package com.myapp;
import java.util.Random;
import java.util.Scanner;

public class Cafe {
    private String name;
    private double balance;
    private int beans;
    private int bread;
    private int tea;

    public Cafe(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.beans = 5;
        this.bread = 5;
        this.tea = 5;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void restock(int addBeans, int addBread, int addTea) {
        //restocks the inventory of the cafe based on what the user inputted
        beans = beans + addBeans;
        bread = bread + addBread;
        tea = tea + addTea;
        System.out.println("Inventory updated. Beans: " + beans + ", Bread: " + bread + ", Tea: " + tea);
    }

    public void simulateDay(Random rand, Scanner input, MenuItem[] menu) {
        int customers = rand.nextInt(3) + 2; // 2–4 customers
        for (int i = 1; i <= customers; i++) {
            MenuItem order = menu[rand.nextInt(menu.length)]; // random order from menu
            System.out.println("Customer " + i + " wants a " + order.getName() + " for $" + order.getPrice()); //gets the name an the price of the order
            System.out.print("Do you accept the order? (yes/no): "); //gets input whether the user wants to accept the order
            String choice = input.nextLine(); //gets input from the user

            if (choice.equalsIgnoreCase("yes")) { //makes sure that even if you say Yes, YES, or yes its still the same
                if (canMake(order)) {
                    processOrder(order); //checks if there are enough ingredients to make the order and gets rid of the ingredients that it uses up
                    System.out.println("Order completed! +" + order.getPrice()); //shows that the order was completed and how much money was made from it
                } else {
                    System.out.println("Not enough ingredients for that order!");
                }
            } else {
                System.out.println("Customer left disappointed."); //if the user says no to the order this message shows up
            }

            // Random mishap chance that could cause you a loss of money
            if (rand.nextInt(10) < 3) { // 30% chance
                double loss = rand.nextInt(5) + 1; // lose $1 to $5
                balance = balance - loss;
                System.out.println("Oops! A small accident cost you $" + loss);
            }
            //new line
            System.out.println();
        }
    }

    private boolean canMake(MenuItem item) {
        if (item.getName().equalsIgnoreCase("Coffee") && beans >= item.getIngredientsNeeded())
            return true;
        if (item.getName().equalsIgnoreCase("Iced Tea") && tea >= item.getIngredientsNeeded())
            return true;
        if (item.getName().equalsIgnoreCase("Sandwich") && bread >= item.getIngredientsNeeded())
            return true;
        return false;
    }

    private void processOrder(MenuItem item) {
        if (item.getName().equalsIgnoreCase("Coffee")) {
            beans -= item.getIngredientsNeeded();
        } else if (item.getName().equalsIgnoreCase("Iced Tea")) {
            tea -= item.getIngredientsNeeded();
        } else if (item.getName().equalsIgnoreCase("Sandwich")) {
            bread -= item.getIngredientsNeeded();
        }
        balance += item.getPrice();
    }
}
