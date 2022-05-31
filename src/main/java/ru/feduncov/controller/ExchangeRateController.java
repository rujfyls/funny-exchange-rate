package ru.feduncov.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.feduncov.service.ExchangeRateService;

import java.net.URI;

@RestController
@RequestMapping("/exchanger")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping
    public ResponseEntity<Object> getUrlOnGif() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(exchangeRateService.getUrlOnGif()))
                .build();
    }
}
