package com.example;

import static com.example.Checkout.APPLE;
import static com.example.Checkout.ORANGE;

public class App {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        System.out.println(checkout.calculateTotal(APPLE, ORANGE, APPLE));
    }
}
