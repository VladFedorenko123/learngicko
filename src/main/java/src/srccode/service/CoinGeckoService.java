package src.srccode.service;

import src.srccode.model.CryptoCurrencyDto;

public interface CoinGeckoService {
    void sendCryptoCurrencyWithPrice(CryptoCurrencyDto cryptoCurrencyList);
}
