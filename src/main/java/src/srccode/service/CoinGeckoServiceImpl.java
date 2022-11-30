package src.srccode.service;

import com.litesoftwares.coingecko.CoinGeckoApiClient;
import com.litesoftwares.coingecko.constant.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import src.srccode.integration.service.ApplicationCommunicationService;
import src.srccode.model.CryptoCurrencyDto;
import src.srccode.util.CoinGeckoUtil;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoinGeckoServiceImpl implements CoinGeckoService {
    @Value("#{'${list.of.crypto.currency}'.split(',')}")
    private final List<String> listCryptoCurrency;

    private final CoinGeckoApiClient coinGeckoApiClient;
    private final ApplicationCommunicationService applicationCommunicationService;

    @Override
    public void getCryptoCurrencyPrice() {
        String cryptoCurrencyList = CoinGeckoUtil.convertListToString(listCryptoCurrency);

        List<CryptoCurrencyDto> cryptoCurrencyDtoList = coinGeckoApiClient.getPrice(cryptoCurrencyList, Currency.USD)
                .entrySet()
                .stream()
                .map(this::buildCryptoCurrencyWithPrice)
                .toList();

        applicationCommunicationService.sendInfoOfCryptoCurrency(cryptoCurrencyDtoList);
    }

    @Override
    public void convertCryptoCurrency(String cryptoCurrency, Double quantityCryptoCurrency) {
        CryptoCurrencyDto cryptoCurrencyDto = buildCryptoCurrencyWithQuantity(cryptoCurrency, quantityCryptoCurrency);

        applicationCommunicationService.convertCryptoCurrency(cryptoCurrencyDto);
    }

    private CryptoCurrencyDto buildCryptoCurrencyWithQuantity(String cryptoCurrency, Double quantityCryptoCurrency) {
        return CryptoCurrencyDto.builder()
                .cryptoCurrency(cryptoCurrency)
                .quantityCryptoCurrency(quantityCryptoCurrency)
                .build();
    }

    private CryptoCurrencyDto buildCryptoCurrencyWithPrice(Map.Entry<String, Map<String, Double>> stringMapMap) {
        String cryptoCurrency = stringMapMap.getKey();
        Double price = getPriceCryptoCurrency(stringMapMap);

        return CryptoCurrencyDto.builder()
                .uuid(String.valueOf(UUID.randomUUID()))
                .cryptoCurrency(cryptoCurrency)
                .price(price)
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
