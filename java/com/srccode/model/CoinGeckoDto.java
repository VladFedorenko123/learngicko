package com.srccode.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoinGeckoDto {
    public String cryptoCurrency;
    public Double quantityCryptoCurrency;
    public Double price;
}
