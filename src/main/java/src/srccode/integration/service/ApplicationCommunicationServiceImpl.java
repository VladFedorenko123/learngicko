package src.srccode.integration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import src.srccode.integration.uri.ApplicationUriBuilder;
import src.srccode.model.CryptoCurrencyDto;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
public class ApplicationCommunicationServiceImpl implements ApplicationCommunicationService {
    private final ApplicationUriBuilder applicationUriBuilder;
    private final RestTemplate restTemplate;

    @Override
    public void sendInfoOfCryptoCurrency(List<CryptoCurrencyDto> cryptoCurrencyDtoList) {
        URI uri = applicationUriBuilder.getSaveOrUpdateUri();
        HttpEntity<List<CryptoCurrencyDto>> entity = new HttpEntity<>(cryptoCurrencyDtoList);
        System.out.println(entity);
        try {
            restTemplate.exchange(uri, POST, entity, String.class);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void convertCryptoCurrency(CryptoCurrencyDto cryptoCurrencyDto) {
        URI uri = applicationUriBuilder.convertCryptoCurrency();
        HttpEntity<CryptoCurrencyDto> entity = new HttpEntity<>(cryptoCurrencyDto);
        System.out.println(entity);
        try {
            restTemplate.exchange(uri, POST, entity, String.class);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
