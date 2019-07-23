package com.iniesta.iniesta_revew;

public class Item {

    private String imageUrl;
    private String name;
    private String type;
    private int price;

    public Item(String imageUrl, String name, String type, int price) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
