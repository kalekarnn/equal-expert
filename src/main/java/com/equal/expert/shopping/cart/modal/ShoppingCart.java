package com.equal.expert.shopping.cart.modal;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ShoppingCart {

    Map<Product, Integer> products;
    double tax;

    public ShoppingCart() {
        this.products = new HashMap<>();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product, int quantity) {

        if (products.containsKey(product)) {
            int oldQuantity = products.get(product);
            products.put(product, oldQuantity + quantity);
        } else
            products.put(product, quantity);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal cartPriceBeforeTax = getCartBasePrice();
        BigDecimal totalTax = calculateTax();

        return cartPriceBeforeTax.add(totalTax).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal calculateTax() {
        BigDecimal cartPriceBeforeTax = getCartBasePrice();
        return cartPriceBeforeTax.multiply(BigDecimal.valueOf(tax)).divide(BigDecimal.valueOf(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal getCartBasePrice() {
        BigDecimal total = BigDecimal.valueOf(0);

        for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {

            Product product = entry.getKey();
            Integer integer = entry.getValue();
            total = total.add(BigDecimal.valueOf(product.getPrice() * integer));
        }
        return total.setScale(2, BigDecimal.ROUND_HALF_UP);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }
}
