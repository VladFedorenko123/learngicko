package com.srccode.configuration;

import com.srccode.util.CoinGeckoUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoinGeckoUtilConfiguration {
    @Bean
    public CoinGeckoUtil coinGeckoUtil(){
        return new CoinGeckoUtil();
    }
}
