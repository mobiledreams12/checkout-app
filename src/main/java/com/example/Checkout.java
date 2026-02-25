package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Checkout {

    public static final Item APPLE = new Item("Apple", 60);
    public static final Item ORANGE = new Item("Orange", 25);

    private final Map<Item, Offer> offers = Map.of(
            APPLE, new BuyOneGetOneFreeOffer(),
            ORANGE, new ThreeForTwoOffer()
    );

    public int calculateTotal(Item... items) {
        if (items == null) {
            throw new IllegalArgumentException("Items cannot be null");
        }

        Map<Item, Integer> itemCounts = getItemCounts(items);

        int total = 0;

        for (Entry<Item, Integer> entry : itemCounts.entrySet()) {
            Item item = entry.getKey();
            int count = entry.getValue();
            int price = item.price();

            Offer offer = offers.get(item);
            if (offer != null) {
                total += offer.apply(price, count);
            } else {
                total += price * count;
            }
        }

        return total;
    }

    private static Map<Item, Integer> getItemCounts(Item[] items) {
        Map<Item, Integer> itemCounts = new HashMap<>();
        for (Item item : items) {
            if (item == null) {
                throw new IllegalArgumentException("Item cannot be null");
            }
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }
        return itemCounts;
    }
}
