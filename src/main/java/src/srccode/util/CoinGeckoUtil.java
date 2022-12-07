package src.srccode.util;

import java.util.List;
import java.util.stream.Collectors;

public class CoinGeckoUtil {
    public static String convertListToString(List<String> listCryptoCurrency) {
        return listCryptoCurrency.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
