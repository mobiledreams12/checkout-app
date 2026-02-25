package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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

        Map<String, Integer> itemCounts = getItemCounts(items);

        int total = 0;

        for (Entry<String, Integer> entry : itemCounts.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            int price = PRICES.get(item);

            if (item.equals(APPLE)) {
                // Buy one get one free
                total += applyBuyOneGetOneFreeOffer(price, count);
            } else if (item.equals(ORANGE)) {
                // Three for the price of two
                total += applyThreeForTwoOffer(price, count);
            } else {
                // No offer
                total += price * count;
            }
        }

        return total;
    }

    private static Map<String, Integer> getItemCounts(String[] items) {
        Map<String, Integer> itemCounts = new HashMap<>();
        for (String item : items) {
            if (item == null) {
                throw new IllegalArgumentException("Item cannot be null");
            }
            if (!PRICES.containsKey(item)) {
                throw new IllegalArgumentException("Unknown item: " + item);
            }
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }
        return itemCounts;
    }

    private static int applyBuyOneGetOneFreeOffer(int price, int count) {
        return ((count / 2) + (count % 2)) * price;
    }

    private static int applyThreeForTwoOffer(int price, int count) {
        return ((count / 3) * 2 + (count % 3)) * price;
    }
}
