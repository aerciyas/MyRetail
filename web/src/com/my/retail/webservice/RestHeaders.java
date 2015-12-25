package com.my.retail.webservice;
import org.springframework.http.HttpHeaders;

/**
 * Created by ahmet on 12/16/15.
 */

final class RestHeaders
{
    static HttpHeaders getHeadersNoCacheNoStoreMustRevalidateResponse()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache");
        headers.add("Cache-Control", "no-store");
        headers.add("Cache-Control", "must-revalidate");
        return headers;
    }

    static HttpHeaders getHeadersPublicMaxAgeOneDayResponse()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "public");
        headers.add("Cache-Control", "max-age=86400");
        return headers;
    }

}
