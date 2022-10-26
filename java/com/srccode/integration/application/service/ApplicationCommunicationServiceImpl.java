package com.srccode.integration.application.service;

import com.srccode.integration.application.uri.ApplicationUriBuilder;
import com.srccode.model.CoinGeckoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
public class ApplicationCommunicationServiceImpl implements ApplicationCommunicationService {
    private final ApplicationUriBuilder applicationUriBuilder;
    private final RestTemplate restTemplate;

    @Override
    public void saveOrUpdateInformationAboutCryptoCurrency(CoinGeckoDto coinGeckoDto) {
        URI uri = applicationUriBuilder.getSaveOrUpdateUserUri();
        HttpEntity<CoinGeckoDto> entity = new HttpEntity<>(coinGeckoDto);
        try {
            restTemplate.exchange(uri, POST, entity, String.class);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void convertCryptoCurrency(CoinGeckoDto coinGeckoDto) {
        URI uri = applicationUriBuilder.convertCryptoCurrencyUri();
        HttpEntity<CoinGeckoDto> entity = new HttpEntity<>(coinGeckoDto);
        try {
            restTemplate.exchange(uri, POST, entity, String.class);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}