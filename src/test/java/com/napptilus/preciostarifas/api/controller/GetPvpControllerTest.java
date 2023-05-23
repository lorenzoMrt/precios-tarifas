package com.napptilus.preciostarifas.api.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import com.napptilus.preciostarifas.api.ApiTestCase;

public class GetPvpControllerTest extends ApiTestCase {

    @Test
    public void should_return_pvp_at_1000() throws Exception {
        whenGetRequestSentTo("/product-pvp?date=2020-06-14-10.00.00&productId=35455&brandId=1");

        var jsonResponse = new JSONObject()
            .put("product-id", 35455)
            .put("brand-id", 1)
            .put("price-list", 1)
            .put("start-date", "2020-06-14-00.00.00")
            .put("end-date", "2020-12-31-23.59.59")
            .put("price", 35.50);

        assertSuccessJsonResponse(jsonResponse);
    }
}
