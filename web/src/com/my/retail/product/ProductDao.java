package com.my.retail.product;


import java.util.List;

public interface ProductDao {

    public Product getProduct(Integer id);
    public Price getPrice(Integer id);
    public List<Product> getProducts(String category);

}
