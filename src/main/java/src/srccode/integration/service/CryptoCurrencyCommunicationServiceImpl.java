package src.srccode.integration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import src.srccode.integration.uri.CryptoCurrencyUriBuilder;
import src.srccode.model.CryptoCurrencyDto;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
public class CryptoCurrencyCommunicationServiceImpl implements CryptoCurrencyCommunicationService {
    private final CryptoCurrencyUriBuilder cryptoCurrencyUriBuilder;
    private final RestTemplate restTemplate;

    @Override
    public void sendCryptoCurrencyWithPrice(List<CryptoCurrencyDto> cryptoCurrencyDtoList) {
        URI uri = cryptoCurrencyUriBuilder.getSaveOrUpdateCryptoCurrency();
        HttpEntity<List<CryptoCurrencyDto>> httpEntity = new HttpEntity<>(cryptoCurrencyDtoList);
        try {
            restTemplate.exchange(uri, POST, httpEntity, String.class);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
