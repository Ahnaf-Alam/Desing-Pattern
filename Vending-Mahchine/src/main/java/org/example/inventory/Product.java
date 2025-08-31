package org.example.inventory;

import lombok.Data;

@Data
public class Product {
    private int productId;
    private int productName;
    private double price;
}
