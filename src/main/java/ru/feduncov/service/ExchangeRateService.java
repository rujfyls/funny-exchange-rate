package ru.feduncov.service;

import org.springframework.stereotype.Service;
import ru.feduncov.client.ExchangeRateClient;
import ru.feduncov.client.GiphyClient;
import ru.feduncov.model.ExchangeRateResponse;
import ru.feduncov.model.GifResponse;
import ru.feduncov.properties.ExchangeRateProperties;
import ru.feduncov.properties.GiphyProperties;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class ExchangeRateService {

    private final ExchangeRateClient exchangeRateClient;
    private final GiphyClient giphyClient;
    private final ExchangeRateProperties exchangeRateProperties;
    private final GiphyProperties giphyProperties;

    public ExchangeRateService(ExchangeRateClient exchangeRateClient,
                               GiphyClient giphyClient,
                               ExchangeRateProperties exchangeRateProperties,
                               GiphyProperties giphyProperties) {
        this.exchangeRateClient = exchangeRateClient;
        this.giphyClient = giphyClient;
        this.exchangeRateProperties = exchangeRateProperties;
        this.giphyProperties = giphyProperties;
    }

    public String getUrlOnGif() {
        double latestRate = getRateResponse("latest").getRates().getCurrency();
        double yesterdayRate = getRateResponse("yesterday").getRates().getCurrency();

        String search;
        if (latestRate > yesterdayRate) {
            search = "rich";
        } else {
            search = "broke";
        }
        GifResponse gifResponse = findGif(search);
        return gifResponse.getUrl();
    }

    ExchangeRateResponse getRateResponse(String date) {
        String appId = exchangeRateProperties.getAppId();
        String base = exchangeRateProperties.getBase();
        String symbols = exchangeRateProperties.getSymbols();

        if (date.toLowerCase(Locale.ROOT).equals("latest")) {
            return exchangeRateClient.getLatestRate(appId, base, symbols);
        } else {
            String yesterday = LocalDate.now(ZoneId.systemDefault())
                    .minusDays(1)
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            return exchangeRateClient.getYesterdayRate(yesterday, appId, base, symbols);
        }
    }

    GifResponse findGif(String search) {
        String key = giphyProperties.getApiKey();
        return giphyClient.getGif(key, search, 1);
    }

}
