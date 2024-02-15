package com.example.librarymanagementsystem;

public class ProductDetails {
    private String category;
    private String details;


    public ProductDetails(String category, String details) {
        this.category = category;
        this.details = details;
    }




    public String getCategory() {
        return category;
    }

    public String getDetails() {
        return details;
    }
}

