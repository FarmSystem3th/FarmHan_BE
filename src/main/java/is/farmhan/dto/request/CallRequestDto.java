package is.farmhan.dto.request;

import lombok.Getter;

@Getter
public class CallRequestDto {

    private Long userId;
    private Long callId;
    private String messageQuestion;

}
