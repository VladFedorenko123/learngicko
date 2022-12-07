package src.srccode.service;

import com.litesoftwares.coingecko.CoinGeckoApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import src.srccode.integration.service.CryptoCurrencyCommunicationService;
import src.srccode.model.CryptoCurrencyDto;
import src.srccode.util.CoinGeckoUtil;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CoinGeckoServiceImpl implements CoinGeckoService {
    private final CoinGeckoApiClient coinGeckoApiClient;
    private final CryptoCurrencyCommunicationService cryptoCurrencyCommunicationService;

    @Override
    public void sendCryptoCurrencyWithPrice(CryptoCurrencyDto cryptoCurrencyDto) {
        String cryptoCurrency = CoinGeckoUtil.convertListToString(cryptoCurrencyDto.getCryptoCurrencyList());
        List<CryptoCurrencyDto> cryptoCurrencyDtoList = coinGeckoApiClient.getPrice(cryptoCurrency, cryptoCurrencyDto.getCurrency())
                .entrySet()
                .stream()
                .map(stringMapEntry -> buildCryptoCurrencyWithPrice(stringMapEntry, cryptoCurrencyDto.getCurrency()))
                .toList();

        cryptoCurrencyCommunicationService.sendCryptoCurrencyWithPrice(cryptoCurrencyDtoList);
    }

    private CryptoCurrencyDto buildCryptoCurrencyWithPrice(Map.Entry<String, Map<String, Double>> stringMapEntry, String currency) {
        String cryptoCurrency = stringMapEntry.getKey();
        Double price = getPriceCryptoCurrency(stringMapEntry);

        return CryptoCurrencyDto.builder()
                .cryptoCurrency(cryptoCurrency)
                .price(price)
                .currency(currency)
                .build();
    }

    private Double getPriceCryptoCurrency(Map.Entry<String, Map<String, Double>> stringMapEntry) {
        return stringMapEntry.getValue()
                .values()
                .stream()
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
