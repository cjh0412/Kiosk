package com.example.level4;

public class MenuItem {
    private final String name, price, text;

    public MenuItem(String name, String price, String text){
        this.name = name;
        this.price = price;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getText() {
        return text;
    }

}
