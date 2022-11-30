package src.srccode.integration.service;

import src.srccode.model.CryptoCurrencyDto;

import java.util.List;

public interface ApplicationCommunicationService {
    void sendInfoOfCryptoCurrency(List<CryptoCurrencyDto> cryptoCurrencyDtoList);
    void convertCryptoCurrency(CryptoCurrencyDto cryptoCurrencyDto);
}
