package com.jama.domain;

/**
 * The Product class represents a product sold in the Supermarket
 * @author  Thomas Quaile
 * @version 1.0, November 2013
 */
public class Product {
    /** Represents the name of a product sold in the Supermarket */
    private Character name;
    /** Represents the price of a product sold in the Supermarket */
    private Integer price;
    /** Represents the number of items necessary to apply for special */
    private Integer numberForSpecial = 0;
    /** Represents the multiplier used for special pricing */
    private Integer specialMultiplier = 0;
    /** Represents the total number of products for calculating total price by product */
    private Integer totalNumberOfProducts = 0;

    /** Default constructor used to create the Product object */
    public Product() {
    }

    /** Constructor used to create the Product object
     * @param name The name of the Product
     * @param price The price of the Product
     */
    public Product(Character name, Integer price) {
        this.setName(name);
        this.setPrice(price);
    }

    /** Constructor used to create the Product object.
     * @param name The name of the Product.
     * @param price The price of the Product.
     * @param numberForSpecial The number of items need for the special.
     * @param specialMultiplier The multiplier use to calculate the special (e.g  special 5 for the price of 3 would have multiplier of 3).
     */
    public Product(Character name, Integer price, Integer numberForSpecial, Integer specialMultiplier) {
        this.setName(name);
        this.setPrice(price);
        this.setNumberForSpecial(numberForSpecial);
        this.setSpecialMultiplier(specialMultiplier);
    }

    /**
     * @return name The name of the Product.
     */
    public Character getName() {
        return this.name;
    }

    /**
     *
     * @param name The name of Product.
     */
    public void setName(Character name) {
        this.name = name;
    }

    /**
     * @return price The price of the Product.
     */
    public Integer getPrice() {
        return this.price;
    }

    /**
     *
     * @param price The price of the Product.
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return numberForSpecial The number of items need for the special for this Product.
     */
    public Integer getNumberForSpecial() {
        return this.numberForSpecial;
    }

    /**
     *
     * @param numberForSpecial The number of items need for the special for this Product.
     */
    public void setNumberForSpecial(Integer numberForSpecial) {
        this.numberForSpecial = numberForSpecial;
    }

    /**
     * @return specialMultiplier The multiplier used to calculate the special.
     */
    public Integer getSpecialMultiplier() {
        return this.specialMultiplier;
    }

    /**
     *
     * @param specialMultiplier The multiplier used to calculate the special.
     */
    public void setSpecialMultiplier(Integer specialMultiplier) {
        this.specialMultiplier = specialMultiplier;
    }

    /**
     * @return totalNumberOfProducts The total number of products for calculating total price for Product
     */
    public Integer getTotalNumberOfProducts() {
        return this.totalNumberOfProducts;
    }

    /**
     *
     * @param totalNumberOfProducts The total number of products for calculating total price for Product
     */
    public void setTotalNumberOfProducts(Integer totalNumberOfProducts) {
        this.totalNumberOfProducts = totalNumberOfProducts;
    }

    /**
     * Calculates the total price of all of this product taking into account any special pricing that might apply.
     * If first checks to see if there is any special,  if there is it then checks to see if we have enough
     * of this Product to receive special, if there is it calculates the total price based on the special using
     * the special multiplier and also adding in any remainder outside of special (e.g. 5 for 3 and 14 items
     * would have 10 items on special and 4 items not.
     * Otherwise it just calculates the total price.
     * @return the calculated total price of all product.
     */
    public int calculateTotalPrice()
    {
        int totalPrice = this.getTotalNumberOfProducts() * this.getPrice();

        if (this.getNumberForSpecial() > 0) {
            if (this.getTotalNumberOfProducts() >= this.getNumberForSpecial()) {
                int totalSpecialProducts = this.getTotalNumberOfProducts() / this.getNumberForSpecial();
                totalPrice = (totalSpecialProducts * this.getSpecialMultiplier()) * this.getPrice();
                int totalNonSpecialProducts = this.getTotalNumberOfProducts() % this.getNumberForSpecial();
                if (totalNonSpecialProducts > 0)
                    totalPrice += (totalNonSpecialProducts * this.getPrice());
            }
        }

        return totalPrice;
    }
}
