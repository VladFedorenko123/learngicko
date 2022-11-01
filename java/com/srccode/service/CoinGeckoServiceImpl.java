package com.srccode.service;

import com.litesoftwares.coingecko.constant.Currency;
import com.litesoftwares.coingecko.CoinGeckoApiClient;
import com.srccode.integration.application.service.ApplicationCommunicationService;
import com.srccode.model.CoinGeckoDto;
import com.srccode.util.CoinGeckoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CoinGeckoServiceImpl implements CoinGeckoService {
    @Value("#{'${list.of.crypto.currency}'.split(',')}")
    private final List<String> listCryptoCurrency;

    private final CoinGeckoUtil coinGeckoUtil;
    private final CoinGeckoApiClient coinGeckoApiClient;
    private final ApplicationCommunicationService applicationCommunicationService;

    @Override
    public void initializeCryptoCurrency() {
        String cryptoCurrencyList = coinGeckoUtil.convertListToString(listCryptoCurrency);

        List<CoinGeckoDto> coinGeckoDtoList = coinGeckoApiClient.getPrice(cryptoCurrencyList, Currency.USD)
                .entrySet()
                .stream()
                .map(this::createCryptoCurrencyWithPrice)
                .collect(Collectors.toList());

        applicationCommunicationService.saveOrUpdateInformationAboutCryptoCurrency(coinGeckoDtoList);
    }

    @Override
    public void convertCryptoCurrency(String cryptoCurrency, Double quantityCryptoCurrency) {
        var cryptoCurrencyWithQuantity = createCryptoCurrencyWithQuantity(cryptoCurrency, quantityCryptoCurrency);

        applicationCommunicationService.convertCryptoCurrency(cryptoCurrencyWithQuantity);
    }

    private CoinGeckoDto createCryptoCurrencyWithQuantity(String cryptoCurrency, Double quantityCryptoCurrency) {
        return CoinGeckoDto.builder()
                .cryptoCurrency(cryptoCurrency)
                .quantityCryptoCurrency(quantityCryptoCurrency)
                .build();
    }

    private CoinGeckoDto createCryptoCurrencyWithPrice(Map.Entry<String, Map<String, Double>> stringMapEntry) {
        String cryptoCurrency = stringMapEntry.getKey();
        Double price = getCryptoCurrencyPrice(stringMapEntry);

        return CoinGeckoDto.builder()
                .uuid(String.valueOf(UUID.randomUUID()))
                .cryptoCurrency(cryptoCurrency)
                .price(price)
                .build();
    }

    private Double getCryptoCurrencyPrice(Map.Entry<String, Map<String, Double>> stringMapEntry) {
        return stringMapEntry.getValue()
                .values()
                .stream()
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }


}