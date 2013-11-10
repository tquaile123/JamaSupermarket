package com.jama;


import java.util.HashMap;
import com.jama.domain.Product;
import com.jama.domain.Supermarket;

/**
 * The JamaSupermarket class represents the main class of the application.
 * @author  Thomas Quaile
 * @version 1.0, November 2013
 */

public class JamaSupermarket {
    public static void main(String [] args){

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
            System.out.println("The total price is $" + totalPrice);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
