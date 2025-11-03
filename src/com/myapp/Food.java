package com.myapp;
public class Food extends MenuItem {
    private int calories;

    public Food(String name, double price, int ingredientsNeeded, int calories) {
        super(name, price, ingredientsNeeded); //gets teh same ingredients from the MenuItem class
        this.calories = calories;
    }

    public void displayInfo() {
        System.out.println(getName() + " - $" + getPrice() + " (" + calories + " cal)"); //displays the name, price, and calories of the food
    }
}
