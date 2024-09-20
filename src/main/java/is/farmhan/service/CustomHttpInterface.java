package is.farmhan.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

import java.util.Map;

public interface CustomHttpInterface {
    @PostExchange("/api/question")
    Map<String, Object> postQuestion(@RequestBody Map<String, Object> requestBody);
}
