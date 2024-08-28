package is.farmhan.service;

import is.farmhan.domain.Call;
import is.farmhan.domain.CallHistory;
import is.farmhan.domain.User;
import is.farmhan.dto.request.CallHistoryRequestDto;
import is.farmhan.dto.response.CallHistoryResponseDto;
import is.farmhan.dto.response.HistoryListDto;
import is.farmhan.exeption.ApiException;
import is.farmhan.exeption.ErrorDefine;
import is.farmhan.repository.CallHistoryRepository;
import is.farmhan.repository.CallRepository;
import is.farmhan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CallHistoryService {

    private final CallHistoryRepository callHistoryRepository;
    private final UserRepository userRepository;
    private final CallRepository callRepository;

    public Map<String, Object> callHistoryList(Long userId) {

        // User 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        // Call 리스트 조회
        List<Call> calls = callRepository.findByUserId(user.getId());

        // Call 리스트를 CallHistoryResponseDto 리스트로 변환
        List<CallHistoryResponseDto> callHistoryResponseDtos = calls.stream()
                .map(call -> {
                    // 각 Call에 연관된 CallHistory 리스트를 조회
                    List<CallHistory> callHistories = callHistoryRepository.findByCallId(call.getId());

                    // CallHistory 리스트를 HistoryListDto로 변환
                    List<HistoryListDto> historyListDtos = callHistories.stream()
                            .map(callHistory -> new HistoryListDto(
                                    callHistory.getId(),
                                    callHistory.getCreateAt(),
                                    callHistory.getMessageAnswer(),
                                    callHistory.getMessageQuestion()
                            ))
                            .collect(Collectors.toList());

                    return new CallHistoryResponseDto(
                            call.getId(),
                            call.getCreateAt(),
                            historyListDtos
                    );
                })
                .collect(Collectors.toList());

        // 응답용 Map 생성
        Map<String, Object> response = new HashMap<>();
        response.put("callHistory", callHistoryResponseDtos);
        return response;
    }
}
