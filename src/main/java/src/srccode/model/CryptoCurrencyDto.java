package src.srccode.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CryptoCurrencyDto {
    private List<String> cryptoCurrencyList;
    private String cryptoCurrency;
    private Double price;
    private String currency;
}
