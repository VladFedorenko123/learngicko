package src.srccode.service;

public interface CoinGeckoService {
    void getCryptoCurrencyPrice();
    void convertCryptoCurrency(String cryptoCurrency, Double quantityCryptoCurrency);
}
