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
    public void shouldThrowExceptionWithNullStringItem() {
        Checkout checkout = new Checkout();
        assertThrows(IllegalArgumentException.class,
                () -> checkout.calculateTotal((String) null));
    }

    @Test
    public void shouldThrowExceptionWithNullStringArrayItem() {
        Checkout checkout = new Checkout();
        assertThrows(IllegalArgumentException.class,
                () -> checkout.calculateTotal((String[]) null));
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
        int total = checkout.calculateTotal(APPLE, ORANGE);
        assertEquals(85, total);
    }

    @Test
    public void shouldCheckoutCorrectlyWithBOGOFOfferOnTwoApples() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(APPLE, APPLE);
        assertEquals(60, total);
    }

    @Test
    public void shouldCheckoutCorrectlyWithBOGOFOfferOnThreeApples() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(APPLE, APPLE, APPLE);
        assertEquals(120, total);
    }

    @Test
    public void shouldCheckoutCorrectlyWithBOGOFOfferOnFourApples() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(APPLE, APPLE, APPLE, APPLE);
        assertEquals(120, total);
    }

    @Test
    public void shouldCheckoutCorrectlyWithBOGOFOfferOnTwoApplesAndOrange() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(APPLE, APPLE, ORANGE);
        assertEquals(85, total);
    }

    @Test
    public void shouldCheckoutCorrectlyWithNo3For2OfferOnTwoOranges() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(ORANGE, ORANGE);
        assertEquals(50, total);
    }

    @Test
    public void shouldCheckoutCorrectlyWith3For2OfferOnThreeOranges() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(ORANGE, ORANGE, ORANGE);
        assertEquals(50, total);
    }

    @Test
    public void shouldCheckoutCorrectlyWith3For2OfferOnFourOranges() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(ORANGE, ORANGE, ORANGE, ORANGE);
        assertEquals(75, total);
    }

    @Test
    public void shouldCheckoutCorrectlyWith3For2OfferOnFiveOranges() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(ORANGE, ORANGE, ORANGE, ORANGE, ORANGE);
        assertEquals(100, total);
    }

    @Test
    public void shouldCheckoutCorrectlyWith3For2OfferOnSixOranges() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(ORANGE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE);
        assertEquals(100, total);
    }

    @Test
    public void shouldCheckoutCorrectlyWithBothOffersOnApplesAndOranges() {
        Checkout checkout = new Checkout();
        int total = checkout.calculateTotal(APPLE, APPLE, ORANGE, APPLE, ORANGE, ORANGE, ORANGE);
        assertEquals(195, total);
    }

}

