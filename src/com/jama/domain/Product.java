package com.jama.domain;

/**
 * The Product class represents a product sold in the Supermarket
 * @author  Thomas Quaile
 * @version 1.0, November 2013
 */
public class Product extends BaseProduct {
    /** Default constructor used to create the Product object */
    public Product() {
        super();
    }

    /** Constructor used to create the Product object
     * @param name The name of the Product
     * @param price The price of the Product
     */
    public Product(Character name, Integer price) {
        super(name, price);
    }

    /** Constructor used to create the Product object.
     * @param name The name of the Product.
     * @param price The price of the Product.
     * @param numberForSpecial The number of items need for the special.
     * @param specialMultiplier The multiplier use to calculate the special (e.g  special 5 for the price of 3 would have multiplier of 3).
     */
    public Product(Character name, Integer price, Integer numberForSpecial, Integer specialMultiplier) {
        super(name, price, numberForSpecial, specialMultiplier);
    }
}
