package com.srccode.integration.application.uri;

import com.srccode.integration.application.properties.UriProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class ApplicationUriBuilder {
    private final UriProperties uriProperties;

    public URI getSaveOrUpdateUserUri() {
        return UriComponentsBuilder.fromUriString(uriProperties.getUri())
                .path(uriProperties.getPath().getSaveCurrency())
                .build()
                .encode()
                .toUri();
    }
    public URI convertCryptoCurrencyUri(){
        return UriComponentsBuilder.fromUriString(uriProperties.getUri())
                .path(uriProperties.getPath().getConvertCurrency())
                .build()
                .encode()
                .toUri();
    }
}
