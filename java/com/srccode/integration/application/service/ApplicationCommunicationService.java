package com.srccode.integration.application.service;


import com.srccode.model.CoinGeckoDto;

import java.util.List;

public interface ApplicationCommunicationService {
    void saveOrUpdateInformationAboutCryptoCurrency(List<CoinGeckoDto> coinGeckoDto);

    void convertCryptoCurrency(CoinGeckoDto coinGeckoDto);
}