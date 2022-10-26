package com.srccode.controller;

import com.srccode.service.CoinGeckoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

@RestController
@RequiredArgsConstructor
public class CoinGeckoController {
    @Autowired
    private final CoinGeckoService coinGeckoService;

    @PostMapping("/cryptoCurrency")
    public void getCoinGock() {
        coinGeckoService.initializeCryptoCurrency();
    }

    @PostMapping("{cryptoCurrency}/{quantityCryptoCurrency}")
    public void convertCryptoCurrency(@PathVariable String cryptoCurrency, @PathVariable Double quantityCryptoCurrency) {
        coinGeckoService.convertCryptoCurrency(cryptoCurrency, quantityCryptoCurrency);
    }
}
