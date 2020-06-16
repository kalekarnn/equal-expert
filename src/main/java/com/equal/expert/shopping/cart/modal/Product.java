package com.equal.expert.shopping.cart.modal;

import java.util.Objects;

public class Product {

    final private String name;
    final private double price;
    final private Offer offer;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Offer getOffer() {
        return offer;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.offer = new Offer(0, 0);
    }

    public Product(String name, double price, Offer offer) {
        this.name = name;
        this.price = price;
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
