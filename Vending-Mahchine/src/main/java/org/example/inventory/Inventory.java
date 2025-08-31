package org.example.inventory;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    Map<Integer, Product> aisleToProductMap;
    Map<Integer, Integer> productIdToCountMap;
    Queue<Integer> availableAisles;

    public Inventory(int aisleCount) {
        availableAisles = new LinkedList<>();

        for(int aisleno = 0; aisleno< aisleCount; aisleno++) {
            availableAisles.add(i);
        }
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void updateProduct(Product product, int quantity) {
        products.get(product) + quantity;
    }
}
