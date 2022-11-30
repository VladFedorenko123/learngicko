package src.srccode.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CryptoCurrencyDto {
    private String uuid;
    private String cryptoCurrency;
    private Double price;
    private Double quantityCryptoCurrency;
}
