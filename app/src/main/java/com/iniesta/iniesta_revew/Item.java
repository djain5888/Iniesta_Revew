package com.iniesta.iniesta_revew;

public class Item {

    private String imageUrl;
    private String name;
    private String type;
    private String amazonLink;
    private String flipkartLink;
    private int price;

    public Item(String imageUrl, String name, String type, int price, String amazonLink, String flipkartLink) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.type = type;
        this.price = price;
        this.amazonLink = amazonLink;
        this.flipkartLink = flipkartLink;
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

    public String getAmazonLink() {
        return amazonLink;
    }

    public String getFlipkartLink() {
        return flipkartLink;
    }
}
