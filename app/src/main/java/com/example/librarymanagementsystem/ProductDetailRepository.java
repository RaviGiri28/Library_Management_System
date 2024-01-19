package com.example.librarymanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class ProductDetailRepository {
    private static final Map<String, ProductDetails> productDetailsMap = new HashMap<>();

    static {
        productDetailsMap.put("SC", new ProductDetails("Science", "Science category details"));
        productDetailsMap.put("EC", new ProductDetails("Economics", "Economics category details"));
        productDetailsMap.put("FC", new ProductDetails("Fiction", "Fiction category details"));
        productDetailsMap.put("CH", new ProductDetails("Children", "Children category details"));
        productDetailsMap.put("PD", new ProductDetails("Personal Development", "Personal Development category details"));
    }

    public static ProductDetails getProductDetailsForUser(String username) {
        return productDetailsMap.get(username.substring(0, 2));
    }
}
