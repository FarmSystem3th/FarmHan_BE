package is.farmhan.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class CallHistoryResponseDto {

    private Long callId;
    private LocalDateTime createAt;
    private List<HistoryListDto> callHistoryList;

    public CallHistoryResponseDto(Long callId, LocalDateTime createAt, List<HistoryListDto> callHistoryList) {
        this.callId = callId;
        this.createAt = createAt;
        this.callHistoryList = callHistoryList;
    }
}
