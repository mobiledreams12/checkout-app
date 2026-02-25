package com.example;

public class BuyOneGetOneFreeOffer implements Offer {
    @Override
    public int apply(int price, int count) {
        return ((count / 2) + (count % 2)) * price;
    }
}
