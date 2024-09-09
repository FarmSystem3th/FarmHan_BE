package is.farmhan.dto.response;

import is.farmhan.domain.Call;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@RequiredArgsConstructor
public class CallStartResponseDto {

    private final Long callId;

    public static CallStartResponseDto of(Call call){
        return CallStartResponseDto.builder()
                .callId(call.getId())
                .build();
    }

}
