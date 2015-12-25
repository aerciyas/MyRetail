package com.my.retail.product;

import org.json.JSONObject;

/**
 * Created by ahmet on 12/16/15.
 */
public abstract class DomainEntity {

    public String convertToJson()
    {
        JSONObject jsonProduct = new JSONObject(this);
        return jsonProduct.toString();
    }
}
