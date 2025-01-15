package com.example.level6;

public class MenuItem {
    private String name, price, text;

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

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", text='" + text + '\''
                ;
    }
}
