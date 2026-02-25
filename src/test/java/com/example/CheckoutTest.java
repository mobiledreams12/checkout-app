package com.example;

import org.junit.jupiter.api.Test;

import static com.example.Checkout.APPLE;
import static com.example.Checkout.ORANGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckoutTest {

    @Test
    public void shouldCheckoutCorrectlyWithEmptyItems() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal();
        assertEquals(0, total);
    }

    @Test
    public void shouldThrowExceptionWithInvalidItem() {
        Checkout checkout = new Checkout();
        assertThrows(IllegalArgumentException.class,
                () -> checkout.calculateTotal("PEACH"));
    }

    @Test
    public void shouldThrowExceptionWithNullItem() {
        Checkout checkout = new Checkout();
        assertThrows(IllegalArgumentException.class,
                () -> checkout.calculateTotal(null));
    }

    @Test
    public void shouldCheckoutCorrectlyWithSingleApple() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(APPLE);
        assertEquals(60, total);
    }

    @Test
    public void shouldCheckoutCorrectlyWithSingleOrange() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(ORANGE);
        assertEquals(25, total);
    }

    @Test
    public void shouldThrowExceptionWithMultipleValidItemsAndInvalidItem() {
        Checkout checkout = new Checkout();
        assertThrows(IllegalArgumentException.class,
                () -> checkout.calculateTotal(APPLE, "PEACH", ORANGE));
    }

    @Test
    public void shouldThrowExceptionWithMultipleValidItemsAndNullItem() {
        Checkout checkout = new Checkout();
        assertThrows(IllegalArgumentException.class,
                () -> checkout.calculateTotal(APPLE, null, ORANGE));
    }

    @Test
    public void shouldCheckoutCorrectlyWithMultipleValidItems() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(APPLE, ORANGE, APPLE);
        assertEquals(145, total);
    }
}
