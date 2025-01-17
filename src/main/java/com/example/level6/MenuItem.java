package com.example.level6;

public class MenuItem {
    private String name, price, text;

    public MenuItem(String name, String price, String text) {
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
        // 고정 폭 설정
        int width = 15;

        return String.format("%-" + width + "s| %-" + width + "s| %-" + width + "s'",
                name, price, text);
    }
}
