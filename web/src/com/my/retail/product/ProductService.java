package com.my.retail.product;

import javassist.NotFoundException;

public interface ProductService {

    public Product getProduct(Integer id) throws NotFoundException;
    public Price getPrice(Integer id) throws NotFoundException;
    public Products getProducts(String category) throws NotFoundException;

}