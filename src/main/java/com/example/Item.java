package com.example;

public record Item(String name, int price) {
    public Item {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
    }
}
