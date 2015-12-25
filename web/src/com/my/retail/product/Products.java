package com.my.retail.product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by ahmet on 12/16/15.
 */
public class Products {

    List<Product> products;

    public List<Product> getProducts()
    {
        return this.products;
    }

    Products(List<Product> products)
    {
        this.products = products;
    }

    public String convertToJson() throws JSONException
    {
        JSONObject jsonProducts = new JSONObject(this);
        return jsonProducts.toString();
    }
}