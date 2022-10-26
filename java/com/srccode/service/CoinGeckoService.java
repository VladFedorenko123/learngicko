package com.srccode.service;

public interface CoinGeckoService {
    void initializeCryptoCurrency();

    void convertCryptoCurrency(String cryptoCurrency, Double quantityCryptoCurrency);
}
