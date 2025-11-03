package com.myapp;
public class Drink extends MenuItem {
    private String temperature;

    public Drink(String name, double price, int ingredientsNeeded, String temperature) {
        super(name, price, ingredientsNeeded); //gets the same ingredients from the MenuItem class
        this.temperature = temperature;
    }

    public void displayInfo() {
        System.out.println(getName() + " (" + temperature + ") - $" + getPrice()); //displays the name, temperature, and price of the drink
    }
}

