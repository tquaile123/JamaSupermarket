package com.jama.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Product Test class represents Junit tests for the Product Class and
 * test the calculateTotalPrice method across many different scenarios.
 * @author  Thomas Quaile
 * @version 1.0, November 2013
 */
public class ProductTest {

    /**
     * Unit test to test 1 Product and 1 total of that product
     * and no special pricing.
     */
    @Test
    public void TestNoSpecialPricing1TotalProducts() {
        Product product = new Product('A', 20);
        product.setTotalNumberOfProducts(1);
        int totalPrice = product.calculateTotalPrice();

        assertEquals("Total prices does not equal.", new Integer(20), new Integer(totalPrice));
    }

    /**
     * Unit test to test 1 Product and 0 total of that product
     * and no special pricing.
     */
    @Test
    public void TestNoSpecialPricing0TotalProducts() {
        Product product = new Product('A', 20);
        int totalPrice = product.calculateTotalPrice();

        assertEquals("Total prices does not equal.", new Integer(0), new Integer(totalPrice));
    }

    /**
     * Unit test to test 1 Product and 5 total of that product
     * and no special pricing.
     */
    @Test
    public void TestNoSpecialPricing5TotalProducts() {
        Product product = new Product('A', 15);
        product.setTotalNumberOfProducts(5);
        int totalPrice = product.calculateTotalPrice();

        assertEquals("Total prices does not equal.", new Integer(75), new Integer(totalPrice));
    }

    /**
     * Unit test to test 1 Product and 2 total of that product
     * with a 2 for 1 special pricing.
     */
    @Test
    public void Test2For1SpecialPricing2TotalProducts() {
        Product product = new Product('A', 20);
        product.setNumberForSpecial(2);
        product.setSpecialMultiplier(1);
        product.setTotalNumberOfProducts(2);
        int totalPrice = product.calculateTotalPrice();

        assertEquals("Total prices does not equal.", new Integer(20), new Integer(totalPrice));
    }

    /**
     * Unit test to test 1 Product and 3 total of that product
     * with a 2 for 1 special pricing.
     */
    @Test
    public void Test2For1SpecialPricing3TotalProducts() {
        Product product = new Product('A', 20);
        product.setNumberForSpecial(2);
        product.setSpecialMultiplier(1);
        product.setTotalNumberOfProducts(3);
        int totalPrice = product.calculateTotalPrice();

        assertEquals("Total prices does not equal.", new Integer(40), new Integer(totalPrice));
    }

    /**
     * Unit test to test 1 Product and 5 total of that product
     * with a 5 for 3 special pricing.
     */
    @Test
    public void Test5For3SpecialPricing5TotalProducts() {
        Product product = new Product('A', 20);
        product.setNumberForSpecial(5);
        product.setSpecialMultiplier(3);
        product.setTotalNumberOfProducts(5);
        int totalPrice = product.calculateTotalPrice();

        assertEquals("Total prices does not equal.", new Integer(60), new Integer(totalPrice));
    }

    /**
     * Unit test to test 1 Product and 10 total of that product
     * with a 5 for 3 special pricing.
     */
    @Test
    public void Test5For3SpecialPricing10TotalProducts() {
        Product product = new Product('A', 20);
        product.setNumberForSpecial(5);
        product.setSpecialMultiplier(3);
        product.setTotalNumberOfProducts(10);
        int totalPrice = product.calculateTotalPrice();

        assertEquals("Total prices does not equal.", new Integer(120), new Integer(totalPrice));
    }

    /**
     * Unit test to test 1 Product and 14 total of that product
     * with a 5 for 3 special pricing.
     */
    @Test
    public void Test5For3SpecialPricing14TotalProducts() {
        Product product = new Product('A', 20);
        product.setNumberForSpecial(5);
        product.setSpecialMultiplier(3);
        product.setTotalNumberOfProducts(14);
        int totalPrice = product.calculateTotalPrice();

        assertEquals("Total prices does not equal.", new Integer(200), new Integer(totalPrice));
    }
}
