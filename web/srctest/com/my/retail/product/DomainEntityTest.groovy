package com.my.retail.product

import org.json.JSONArray
import org.junit.Before
import org.junit.Test

public class DomainEntityTest {

    DomainEntity price

    @Before
    public void setUp() throws Exception {

        price = PriceTest.createTestPrice()
    }

    @Test
    public void testConvertToJson() throws Exception {

        def expected = "{\"id\":123,\"price\":\"15\"}"
        def actual = price.convertToJson()

        assert actual == expected
    }

}