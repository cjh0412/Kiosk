package com.example.level3;

public class MenuItem {
    private String name, price, text;

    public MenuItem(String name, String price, String text){
        this.name = name;
        this.price = price;
        this.text = text;
    }

    public MenuItem(String name, String text){
        this.name = name;
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
