package com.udacity.pricing.web;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PricingControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PriceService priceService;

    @Test
    public void getAllDogs() throws Exception {
        mockMvc.perform(get("/services/prices"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));

        verify(priceService, times(1)).getPrices();
    }

    @Test
    public void getPriceById() throws Exception {
        mockMvc.perform(get("/services/prices/1/"))
                .andExpect(status().isOk());

        verify(priceService, times(1)).getPriceById(1);

    }
}
