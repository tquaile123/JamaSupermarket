package com.jama.domain;

import com.jama.Exception.ProductNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;

/**
 * The JamaSupermarketTest class represents Junit test for the SupermarketClass
 * @author  Thomas Quaile
 * @version 1.0, November 2013
 */
public class SupermarketTest {
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
