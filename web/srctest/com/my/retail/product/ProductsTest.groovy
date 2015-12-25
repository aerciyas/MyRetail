package com.my.retail.product

import org.junit.Before
import org.junit.Test

public class ProductsTest {

    Products products

    @Before
    public void setUp() throws Exception {

        products = createTestProducts()
    }

    @Test
    public void testConvertToJson() throws Exception {

        def expected = "{\"products\":[{\"id\":123,\"category\":\"testCategory\",\"name\":\"Target Dog\",\"lastUpdated\":\"Mon Jan 31 00:00:00 CST 2000\",\"sku\":\"testSKU\"}]}"
        def actual = products.convertToJson()

        assert actual == expected

    }

    static Products createTestProducts()
    {
        List<Product> productsList = [ProductTest.createTestProduct()]
        new Products(productsList)
    }
}