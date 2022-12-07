package src.srccode.integration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "crypto")
public class UriProperties {
    private String uri;
    private String path;
    private Path save;

    @Getter
    @Setter
    public static class Path {
        private String price;
    }
}
