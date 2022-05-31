package ru.feduncov.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.feduncov.model.GifResponse;

@FeignClient(name = "giphy", url = "${giphy.url}")
public interface GiphyClient {

    @GetMapping
    GifResponse getGif(@RequestParam String api_key,
                       @RequestParam String q,
                       @RequestParam Integer limit);
}

