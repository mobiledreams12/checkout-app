package com.example;

public class ThreeForTwoOffer implements Offer {
    @Override
    public int apply(int price, int count) {
        return ((count / 3) * 2 + (count % 3)) * price;
    }
}
