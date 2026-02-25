package com.example;

import java.util.List;
import java.util.Map;

public class Checkout {

    public static final String APPLE = "Apple";
    public static final String ORANGE = "Orange";

    private static final Map<String, Integer> PRICES = Map.of(
            APPLE, 60,
            ORANGE, 25
    );

    public int calculateTotal(String... items) {
        if (items == null) {
            throw new IllegalArgumentException("Items cannot be null");
        }

        int total = 0;

        for (String item : items) {
            if (item == null) {
                throw new IllegalArgumentException("Item cannot be null");
            }
            Integer price = PRICES.get(item);

            if (price == null) {
                throw new IllegalArgumentException("Unknown item: " + item);
            }

            total += price;
        }

        return total;
    }
}
