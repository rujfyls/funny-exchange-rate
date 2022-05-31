package ru.feduncov.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.feduncov.client.ExchangeRateClient;
import ru.feduncov.client.GiphyClient;
import ru.feduncov.model.ExchangeRateResponse;
import ru.feduncov.model.GifResponse;
import ru.feduncov.model.Rate;
import ru.feduncov.properties.ExchangeRateProperties;
import ru.feduncov.properties.GiphyProperties;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest(ExchangeRateService.class)
class ExchangeRateServiceTest {

    @MockBean
    private ExchangeRateClient exchangeRateClient;
    @MockBean
    private GiphyClient giphyClient;
    @MockBean
    private ExchangeRateProperties exchangeRateProperties;
    @MockBean
    private GiphyProperties giphyProperties;
    @Autowired
    private ExchangeRateService exchangeRateService;

    @Test
    void getUrlOnGif() {
        ExchangeRateResponse rateResponse = new ExchangeRateResponse();
        Rate rate = new Rate();
        rate.setCurrency(50.0);
        rateResponse.setRates(rate);
        when(exchangeRateService.getRateResponse("latest")).thenReturn(rateResponse);

        rate.setCurrency(60.0);
        rateResponse.setRates(rate);
        when(exchangeRateService.getRateResponse("yesterday")).thenReturn(rateResponse);
        when(exchangeRateClient.getLatestRate(anyString(), anyString(), anyString())).thenReturn(rateResponse);

        GifResponse gifResponse = new GifResponse();
        List<GifResponse.Data> dataList = new ArrayList<>();
        GifResponse.Data data = new GifResponse.Data(new GifResponse.Data.Images(new GifResponse.Data.Images.Original("url")));
        dataList.add(data);
        gifResponse.setData(dataList);

        when(exchangeRateService.findGif("broke")).thenReturn(gifResponse);
        when(exchangeRateService.findGif("rich")).thenThrow(NullPointerException.class);

        Assertions.assertEquals("url", exchangeRateService.getUrlOnGif());
    }
}