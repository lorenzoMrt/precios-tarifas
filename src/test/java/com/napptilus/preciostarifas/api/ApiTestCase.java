package com.napptilus.preciostarifas.api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.napptilus.preciostarifas.api.exception.ProductNotFoundException;
import com.napptilus.preciostarifas.api.exception.WrongDateFormatException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class ApiTestCase {

    @Autowired
    private MockMvc mockMvc;
    private ResultActions currentRequest;

    protected void assertJsonResponse(
            String endpoint,
            Integer expectedStatusCode,
            String expectedResponse
    ) throws Exception {
        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("")
                : content().json(expectedResponse);

        mockMvc
                .perform(get(endpoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response)
                .andExpect(header().string("content-type", "application/json"));

    }

    protected void whenGetRequestSentTo(String endpoint) throws Exception {
        currentRequest = mockMvc.perform(get(endpoint));
    }

    protected void assertStatusCodeIs(Integer expectedStatusCode) throws Exception {
        currentRequest.andExpect(status().is(expectedStatusCode));
    }

    protected void assertContentTypeIsA(String expectedContentType) throws Exception {
        currentRequest.andExpect(header().string("content-type", expectedContentType));
    }

    protected void assertResponseIs(String expectedResponse) throws Exception {
        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("")
                : content().json(expectedResponse);

        currentRequest.andExpect(response);
    }

    protected void assertSuccessJsonResponse(JSONObject json) throws Exception {
        assertJsonResponse(200, json);
    }

    protected void assertJsonResponse(int statusCode, JSONObject json) throws Exception {
        assertStatusCodeIs(statusCode);
        assertContentTypeIsA("application/json");
        assertResponseIs(json.toString());
    }

    protected void assertExceptionIsThrown(Object class1, String endpoint) throws Exception {
        if(class1 instanceof ProductNotFoundException) {
            mockMvc.perform(get(endpoint)).andExpect(MockMvcResultMatchers.status().isNotFound());
        }
        if(class1 instanceof WrongDateFormatException) {
            mockMvc.perform(get(endpoint)).andExpect(MockMvcResultMatchers.status().isBadRequest());

        }
    }
}

