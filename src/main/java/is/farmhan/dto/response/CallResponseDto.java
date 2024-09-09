package is.farmhan.dto.response;

import is.farmhan.domain.CallHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@RequiredArgsConstructor
public class CallResponseDto {

    private final String messageAnswer;

    public static CallResponseDto of(CallHistory callHistory){
        return CallResponseDto.builder()
                .messageAnswer(callHistory.getMessageAnswer())
                .build();
    }

}
