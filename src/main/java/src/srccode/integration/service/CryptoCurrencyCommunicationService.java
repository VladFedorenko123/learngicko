package src.srccode.integration.service;

import src.srccode.model.CryptoCurrencyDto;

import java.util.List;

public interface CryptoCurrencyCommunicationService {
    void sendCryptoCurrencyWithPrice(List<CryptoCurrencyDto> cryptoCurrencyDtoList);
}
