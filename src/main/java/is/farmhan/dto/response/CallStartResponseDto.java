package is.farmhan.dto.response;

import is.farmhan.domain.Call;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CallStartResponseDto {

    private final Long callId;
    @Builder
    public CallStartResponseDto(Long callId) {
        this.callId = callId;
    }

    public static CallStartResponseDto of(Call call){
        return CallStartResponseDto.builder()
                .callId(call.getId())
                .build();
    }

}
