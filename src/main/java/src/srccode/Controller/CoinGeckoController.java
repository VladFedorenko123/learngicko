package src.srccode.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import src.srccode.model.CryptoCurrencyDto;
import src.srccode.service.CoinGeckoService;

@RestController
@RequestMapping("/coin")
@RequiredArgsConstructor
public class CoinGeckoController {
    private final CoinGeckoService coinGeckoService;

    @PostMapping
    public void d(@RequestBody CryptoCurrencyDto cryptoCurrencyDto) {
        System.out.println(cryptoCurrencyDto.getCryptoCurrencyList());
        System.out.println(cryptoCurrencyDto.getCurrency());
        coinGeckoService.sendCryptoCurrencyWithPrice(cryptoCurrencyDto);
    }
}
