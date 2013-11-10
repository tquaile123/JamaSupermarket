package com.jama.domain;

import java.util.HashMap;
import java.util.Map;
import com.jama.Exception.ProductNotFoundException;

/**
 * The Supermarket class represents the product list and checkout method of a Supermarket
 * @author  Thomas Quaile
 * @version 1.0, November 2013
 */
public class Supermarket {

    /** Represents all the products available in the Supermarket */
    private HashMap productList;

    /** Default constructor used to create the Supermarket object */
    public Supermarket()
    {
    }

    /** Constructor used to create the Supermarket object
     * @param productList List of products available in Supermarket
     */
    public Supermarket(HashMap productList)
    {
        this.productList = productList;
    }

    /**
     * @return productList List of products available in Supermarket
     */
    public HashMap getProductList() {
        return this.productList;
    }

    /**
     *
     * @param productList List of products available in Supermarket
     */
    public void setProductList(HashMap productList) {
        this.productList = productList;
    }

    /**
     * Calculates the total price of all Products
     * by first creating a HashMap of each unique Product in the product list
     * with the total number of that Product in the checkout items.
     * It then aggregates the totalPrice for all the unique Products in the new
     * HashMap taking into account any Product specials.
     * If an item is in the checkout items that isn't in the ProductList
     * a ProductNotFoundException is thrown.
     *
     * @param items All items that will be calculated at checkout in the form of a String of Product names (e.g. 'AABBCC')
     * @return The calculated total price of all items taking into account any Product specials.
     * @exception  ProductNotFoundException Product not found exception when item isn't in ProductList
     */
    public int checkout(String items) throws ProductNotFoundException {
        Integer totalPrice = 0;



        HashMap<Character, Product> productTotalList = new HashMap<Character, Product>();
        for (Character c : items.toCharArray()) {
            if (productList.containsKey(c)) {
                Product product = (Product)productList.get(c);
                if (productTotalList.containsKey(c)) {
                    Product totalProduct = productTotalList.get(c);
                    totalProduct.setTotalNumberOfProducts(product.getTotalNumberOfProducts() + 1);
                }
                else {
                    product.setTotalNumberOfProducts(product.getTotalNumberOfProducts() + 1);
                    productTotalList.put(c, product);
                }
            }
            else {
                throw new ProductNotFoundException("Product '" + c + "' not found.");
            }
        }

        for (Map.Entry<Character,Product> entry : productTotalList.entrySet()) {
            Product product = (Product)entry.getValue();
            totalPrice += product.calculateTotalPrice();
        }

        return totalPrice;
    }
}
