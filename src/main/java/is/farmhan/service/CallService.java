package is.farmhan.service;

import is.farmhan.domain.Call;
import is.farmhan.domain.CallHistory;
import is.farmhan.domain.User;
import is.farmhan.dto.request.CallRequestDto;
import is.farmhan.dto.response.CallResponseDto;
import is.farmhan.dto.response.CallStartResponseDto;
import is.farmhan.exeption.ApiException;
import is.farmhan.exeption.ErrorDefine;
import is.farmhan.repository.CallHistoryRepository;
import is.farmhan.repository.CallRepository;
import is.farmhan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class CallService {

    private final UserRepository userRepository;
    private final CallRepository callRepository;
    private final CallHistoryRepository callHistoryRepository;
    private final WebClient webClient;

    public CallStartResponseDto startCall(Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        Call call = Call.builder()
                .createAt(LocalDateTime.now())
                .user(user)
                .build();

        callRepository.save(call);

        return CallStartResponseDto.of(call);
    }

    public CallResponseDto call(CallRequestDto callRequestDto) {

        User user = userRepository.findById(callRequestDto.getUserId())
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        Call call = callRepository.findById(callRequestDto.getCallId())
                .orElseThrow(()-> new ApiException(ErrorDefine.CALL_NOT_FOUND));

        Mono<Map> responseMono = webClient.post()
                .uri("/api/question")
                .bodyValue(buildRequestBody(user, callRequestDto))
                .retrieve()
                .bodyToMono(Map.class)
                .onErrorResume(WebClientResponseException.class, ex -> {

                    throw new ApiException(ErrorDefine.AI_SERVER_ERROR);
                });

        Map<String, Object> responseBody = responseMono.block();

        if (responseBody != null && (Boolean) responseBody.get("success")) {
            Map<String, Object> responseDto = (Map<String, Object>) responseBody.get("responseDto");
            System.err.println(responseDto);
            if (responseDto != null) {
                String messageAnswer = (String) responseDto.get("messageAnswer");

                CallHistory callHistory = CallHistory.builder()
                                            .call(call)
                                            .messageAnswer(messageAnswer)
                                            .messageQuestion(callRequestDto.getMessageQuestion())
                                            .createAt(LocalDateTime.now())
                                            .build();

                callHistoryRepository.save(callHistory);
                return CallResponseDto.of(callHistory);

            } else {
                throw new ApiException(ErrorDefine.AI_SERVER_ERROR);
            }
        }else {
            throw new ApiException(ErrorDefine.AI_SERVER_ERROR);
        }
    }

    private Map<String, String> buildRequestBody(User user, CallRequestDto callRequestDto) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userLoginId", user.getUserLoginId());
        requestBody.put("apiToken", user.getApiToken());
        requestBody.put("secretKey", user.getSecretKey());
        requestBody.put("messageQuestion", callRequestDto.getMessageQuestion());
        return requestBody;
    }


}
