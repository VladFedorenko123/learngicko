package src.srccode.integration.uri;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import src.srccode.integration.properties.UriProperties;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class ApplicationUriBuilder {
    private final UriProperties uriProperties;

    public URI getSaveOrUpdateUri() {
        return UriComponentsBuilder.fromUriString(uriProperties.getUri())
                .path(uriProperties.getPath())
                .build()
                .encode()
                .toUri();
    }

    public URI convertCryptoCurrency() {
        return UriComponentsBuilder.fromUriString(uriProperties.getUri())
                .path(uriProperties.getConvert().getConvertCurrency())
                .build()
                .encode()
                .toUri();
    }

}
