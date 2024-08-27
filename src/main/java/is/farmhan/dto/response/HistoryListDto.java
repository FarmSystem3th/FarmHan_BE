package is.farmhan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Builder
@Getter
public class HistoryListDto {

    private Long callHistoryId;
    private LocalDateTime createAt;
    private String message_answer;
    private String message_question;


}
