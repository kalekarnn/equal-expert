package com.equal.expert.shopping.cart.modal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class ShoppingCartTest {


    @Test
    public void testIsEmpty() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Assert.assertTrue(shoppingCart.isEmpty());
    }

    @Test
    public void testGetTotalPrice_with_5_products() {

        Product product = new Product("dove", 39.99);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(product, 5);

        BigDecimal result = shoppingCart.getTotalPrice();

        Assert.assertEquals(valueOf(199.95), result);
    }

    @Test
    public void testGetTotalPrice_with_8_products() {

        Product product = new Product("dove", 39.99);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(product, 5);
        shoppingCart.addProduct(product, 3);

        BigDecimal result = shoppingCart.getTotalPrice();

        Assert.assertEquals(valueOf(319.92), result);
    }

    @Test
    public void testGetTotalPrice_with_2_Dove_2_Axe_products() {

        Product product1 = new Product("dove", 39.99);
        Product product2 = new Product("axe", 99.99);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTax(12.5);

        shoppingCart.addProduct(product1, 2);
        shoppingCart.addProduct(product2, 2);

        BigDecimal result = shoppingCart.getTotalPrice();
        BigDecimal tax = shoppingCart.calculateTax();

        Assert.assertEquals(valueOf(314.96), result);
        Assert.assertEquals(new BigDecimal("35.00"), tax);
    }

    @Test
    public void testGetTotalPrice_with_Buy_2_Dove_Get_1_dove_products() {

        Product product1 = new Product("dove", 39.99);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTax(12.5);

        shoppingCart.addProduct(product1, 3);

        BigDecimal result = shoppingCart.getTotalPrice();
        BigDecimal tax = shoppingCart.calculateTax();

        Assert.assertEquals(valueOf(89.98), result);
        Assert.assertEquals(new BigDecimal("10.00"), tax);
    }
}