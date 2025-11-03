package com.myapp;
public class MenuItem {
    private String name;
    private double price;
    private int ingredientsNeeded;

    public MenuItem(String name, double price, int ingredientsNeeded) {
        this.name = name;
        this.price = price;
        this.ingredientsNeeded = ingredientsNeeded;
    }
    //returns the name of the MenuItem
    public String getName() {
        return name;
    }
    //returns the price of the menu item
    public double getPrice() {
        return price;
    }

    //returns the amount of ingredients needed to make the menu item
    public int getIngredientsNeeded() {
        return ingredientsNeeded;
    }
    //prints out the basic info such as the name and the price of the menu item
    public void displayInfo() {
        System.out.println(name + " - $" + price);
    }
}
