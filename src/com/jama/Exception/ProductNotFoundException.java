package com.jama.Exception;

/**
 * The ProductNotFoundException represents an exception for when an item isn't found in the product list/
 * @author  Thomas Quaile
 * @version 1.0, November 2013
 */
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message)
    {
        super(message);
    }
}
