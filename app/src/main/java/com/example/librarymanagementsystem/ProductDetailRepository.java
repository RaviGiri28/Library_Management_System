package com.example.librarymanagementsystem;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class ProductDetailRepository {
    static final Map<String, ProductDetails> productDetailsMap = new HashMap<>();

    static {
        productDetailsMap.put("SC", new ProductDetails("Science", "Science category details"));
        productDetailsMap.put("EC", new ProductDetails("Economics", "Economics category details"));
        productDetailsMap.put("FC", new ProductDetails("Fiction", "Fiction category details"));
        productDetailsMap.put("CH", new ProductDetails("Children", "Children category details"));
        productDetailsMap.put("PD", new ProductDetails("PD", "Personal Development category details"));
    }

    public static ProductDetails getProductDetailsForUser(String username) {
        String key = username.trim().substring(0, 2).toUpperCase();
        Log.d("ProductDetailRepository", "Searching for key: " + key);

        ProductDetails productDetails = productDetailsMap.get(key);

        if (productDetails == null) {
            Log.d("ProductDetailRepository", "Product details not found for key: " + key);
            productDetails = new ProductDetails("N/A", "Product details not found");
        } else {
            Log.d("ProductDetailRepository", "Product details found: " + productDetails.getCategory());
        }

        return productDetails;
    }
    public static Map<String, ProductDetails> getFilteredProducts(String searchQuery) {
        Map<String, ProductDetails> filteredProducts = new HashMap<>();

        // Implement your logic to filter products based on the search query
        // For simplicity, let's assume that filtering is case-insensitive and matches category names
        for (Map.Entry<String, ProductDetails> entry : productDetailsMap.entrySet()) {
            if (entry.getValue().getCategory().toLowerCase().contains(searchQuery.toLowerCase())) {
                filteredProducts.put(entry.getKey(), entry.getValue());
            }
        }

        return filteredProducts;
    }
}


