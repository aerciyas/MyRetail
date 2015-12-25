package com.my.retail.product

public class ProductTest {

    static Product createTestProduct()
    {
        def calendar = GregorianCalendar.getInstance()
        calendar.set(1999, 12, 31, 0, 0, 0)
        def lastUpdated = calendar.getTime()
        new Product(id: 123, sku: "testSKU", name: "Target Dog", category: "testCategory", lastUpdated: lastUpdated)
    }

}