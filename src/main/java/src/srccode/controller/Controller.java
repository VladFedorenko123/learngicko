package src.srccode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import src.srccode.service.CoinGeckoService;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final CoinGeckoService coinGeckoService;

    @PostMapping("/getCryptoCurrencyPrice")
    public void getCryptoCurrencyPrice() {
        coinGeckoService.getCryptoCurrencyPrice();
    }

    @GetMapping("/{cryptoCurrency}/{quantityCryptoCurrency}")
    public void convertCryptoCurrency(@PathVariable String cryptoCurrency,
                                      @PathVariable Double quantityCryptoCurrency) {
        coinGeckoService.convertCryptoCurrency(cryptoCurrency, quantityCryptoCurrency
        );
    }

}