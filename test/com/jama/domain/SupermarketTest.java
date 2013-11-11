package com.jama.domain;

import com.jama.exception.ProductNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;

/**
 * The SupermarketTest class represents Junit test for the SupermarketClass
 * and test the calculate method across many scenarios.
 * @author  Thomas Quaile
 * @version 1.0, November 2013
 */
public class SupermarketTest {
    /**
     * Unit test to test the ABBACBBAB items from the Product list
     * and also includes a 5 for 3 special on Product B
     */
    @Test
    public void TestABBACBBAB() {
        HashMap<Character, Product> productList = new HashMap<Character, Product>();
        Product product = new Product('A', 20);
        productList.put(product.getName(), product);

        product = new Product('B', 50, 5, 3);
        productList.put(product.getName(), product);

        product = new Product('C', 30);
        productList.put(product.getName(), product);

        com.jama.domain.Supermarket supermarket = new com.jama.domain.Supermarket(productList);

        try {
            int totalPrice = supermarket.checkout("ABBACBBAB");
            assertEquals("Total prices does not equal.", new Integer(240), new Integer(totalPrice));
        }
        catch (Exception e)
        {
            fail(e.getMessage());
        }
    }

    /**
     * Unit test to test the ABC items from the Product list
     * and also includes a 5 for 3 special on Product B
     */
    @Test
    public void TestABC() {
        HashMap<Character, Product> productList = new HashMap<Character, Product>();
        Product product = new Product('A', 20);
        productList.put(product.getName(), product);

        product = new Product('B', 50, 5, 3);
        productList.put(product.getName(), product);

        product = new Product('C', 30);
        productList.put(product.getName(), product);

        com.jama.domain.Supermarket supermarket = new com.jama.domain.Supermarket(productList);

        try {
            int totalPrice = supermarket.checkout("ABC");
            assertEquals("Total prices are not equal.", new Integer(100), new Integer(totalPrice));
        }
        catch (Exception e)
        {
            fail(e.getMessage());
        }
    }

    /**
     * Unit test to test the ABBACBBABABBACBBAB items from the Product list
     * and also includes a 5 for 3 special on Product B
     */
    @Test
    public void TestABBACBBABABBACBBAB() {
        HashMap<Character, Product> productList = new HashMap<Character, Product>();
        Product product = new Product('A', 20);
        productList.put(product.getName(), product);

        product = new Product('B', 50, 5, 3);
        productList.put(product.getName(), product);

        product = new Product('C', 30);
        productList.put(product.getName(), product);

        com.jama.domain.Supermarket supermarket = new com.jama.domain.Supermarket(productList);

        try {
            int totalPrice = supermarket.checkout("ABBACBBABABBACBBAB");
            assertEquals("Total prices does not equal.", new Integer(480), new Integer(totalPrice));
        }
        catch (Exception e)
        {
            fail(e.getMessage());
        }
    }

    /**
     * Unit test to test the BCABBACBCB items from the Product list
     * and also includes a 2 for 1 special on Product A
     * and also includes a 5 for 3 special on Product B
     * and also includes a 3 for 2 special on Product C
     */
    @Test
    public void TestBCABBACBCB() {
        HashMap<Character, Product> productList = new HashMap<Character, Product>();
        Product product = new Product('A', 20, 2, 1);
        productList.put(product.getName(), product);

        product = new Product('B', 50, 5, 3);
        productList.put(product.getName(), product);

        product = new Product('C', 30, 3, 2);
        productList.put(product.getName(), product);

        com.jama.domain.Supermarket supermarket = new com.jama.domain.Supermarket(productList);

        try {
            int totalPrice = supermarket.checkout("BCABBACBCB");
            assertEquals("Total prices are not equal.", new Integer(230), new Integer(totalPrice));
        }
        catch (Exception e)
        {
            fail(e.getMessage());
        }
    }

    /**
     * Unit test to test the BCABBACBCBX items from the Product list
     * which includes Product X which doesn't not exist in the Product List
     * causing a ProductNotFoundException to be thrown
     */
    @Test(expected = ProductNotFoundException.class)
    public void TestProductNotFoundException() throws ProductNotFoundException {
        HashMap<Character, Product> productList = new HashMap<Character, Product>();
        Product product = new Product('A', 20, 2, 1);
        productList.put(product.getName(), product);

        product = new Product('B', 50, 5, 3);
        productList.put(product.getName(), product);

        product = new Product('C', 30, 3, 2);
        productList.put(product.getName(), product);

        com.jama.domain.Supermarket supermarket = new com.jama.domain.Supermarket(productList);

        int totalPrice = supermarket.checkout("BCABBACBCBX");
        assertEquals("Total prices are not equal.", new Integer(230), new Integer(totalPrice));
    }
}
