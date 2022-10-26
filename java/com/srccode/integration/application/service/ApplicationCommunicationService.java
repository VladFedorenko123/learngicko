package com.srccode.integration.application.service;


import com.srccode.model.CoinGeckoDto;

public interface ApplicationCommunicationService {
    void saveOrUpdateInformationAboutCryptoCurrency(CoinGeckoDto coinGeckoDto);

    void convertCryptoCurrency(CoinGeckoDto coinGeckoDto);
}