package is.farmhan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@RequiredArgsConstructor
@Builder
@Getter
public class HistoryListDto {

    private final Long callHistoryId;
    private final LocalDateTime createAt;
    private final String message_answer;
    private final String message_question;


}
