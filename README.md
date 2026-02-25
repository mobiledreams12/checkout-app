# Checkout App

A small Java checkout kata that totals item prices and applies simple offers.

## Features
- Prices in pence (int): Apple = 60, Orange = 25
- Offers:
  - Apples: buy-one-get-one-free
  - Oranges: three-for-two
- Defensive input validation for null items or null item arrays

## Project Layout
- `src/main/java/com/example/Checkout.java`: pricing and offer application
- `src/main/java/com/example/Offer.java`: offer interface
- `src/main/java/com/example/BuyOneGetOneFreeOffer.java`: apple offer
- `src/main/java/com/example/ThreeForTwoOffer.java`: orange offer
- `src/main/java/com/example/App.java`: sample entry point
- `src/test/java/com/example/CheckoutTest.java`: JUnit tests

## Requirements
- Java 21 (set by `maven.compiler.release` in `pom.xml`)
- Maven

## Build
```powershell
mvn -q -DskipTests package
```

## Test
```powershell
mvn test
```

## Run
Runs the sample `App` which totals 2 apples and 1 orange.
```powershell
mvn -q -DskipTests package
java -cp target\checkout-app-1.0-SNAPSHOT.jar com.example.App
```

## Example Usage (Code)
```java
Checkout checkout = new Checkout();
int total = checkout.calculateTotal(Checkout.APPLE, Checkout.ORANGE, Checkout.APPLE);
System.out.println(total); // 145
```

## Notes
- Add new items or offers by extending `Offer` and wiring them in `Checkout`.
- Prices and totals are integer pence; format for display as needed.
