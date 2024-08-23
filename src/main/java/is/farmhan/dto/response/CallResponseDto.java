package is.farmhan.dto.response;

import is.farmhan.domain.CallHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CallResponseDto {

    private final String messageAnswer;
    @Builder
    public CallResponseDto(String messageAnswer) {
        this.messageAnswer = messageAnswer;
    }

    public static CallResponseDto of(CallHistory callHistory){
        return CallResponseDto.builder()
                .messageAnswer(callHistory.getMessageAnswer())
                .build();
    }

}
