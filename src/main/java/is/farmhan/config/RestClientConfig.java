package is.farmhan.config;

import is.farmhan.service.CustomHttpInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration

public class RestClientConfig {
    private static final String BASE_URL = "https://proma-ai.store"; // base URL 설정

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder.build();
    }


    @Bean
    public CustomHttpInterface customHttpInterface() {
        RestClient client = RestClient.builder()
                .baseUrl(BASE_URL)
                .build();

        // RestClient를 어댑터로 변환
        RestClientAdapter adapter = RestClientAdapter.create(client);

        // HttpServiceProxyFactory를 사용하여 클라이언트 생성
        return HttpServiceProxyFactory.builderFor(adapter)
                .build()
                .createClient(CustomHttpInterface.class);
    }
}
