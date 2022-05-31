package ru.feduncov.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.feduncov.model.ExchangeRateResponse;

@FeignClient(name = "openExchangeRates", url = "${exchange-rate.url.base}")
public interface ExchangeRateClient {

    @GetMapping("${exchange-rate.url.latest}")
    ExchangeRateResponse getLatestRate(@RequestParam String app_id,
                                       @RequestParam String base,
                                       @RequestParam String symbols);

    @GetMapping("${exchange-rate.url.yesterday}")
    ExchangeRateResponse getYesterdayRate(@PathVariable String date,
                                          @RequestParam String app_id,
                                          @RequestParam String base,
                                          @RequestParam String symbols);
}