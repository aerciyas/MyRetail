package com.my.retail.webservice

import org.junit.Before
import org.junit.Test

public class RestHeadersTest {

    RestHeaders restHeaders
    
    @Before
    public void setUp() throws Exception {

        restHeaders = new RestHeaders()
        
    }

    @Test
    public void testGetHeadersNoCacheNoStoreMustRevalidateResponse() throws Exception {

        def expected = ["no-cache", "no-store", "must-revalidate"]

        def actual = restHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse().get("Cache-Control")

        assert actual == expected

    }

    @Test
    public void testGetHeadersPublicMaxAgeOneHourResponse() throws Exception {

        def expected = ["public", "max-age=86400"]

        def actual = restHeaders.getHeadersPublicMaxAgeOneDayResponse().get("Cache-Control")

        assert actual == expected

    }
}