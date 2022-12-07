package src.srccode.configuration;

import com.litesoftwares.coingecko.CoinGeckoApiClient;
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoinGeckoApiClientConfiguration {
    @Bean
    public CoinGeckoApiClient coinGeckoApiClient() {
        return new CoinGeckoApiClientImpl();
    }
}
