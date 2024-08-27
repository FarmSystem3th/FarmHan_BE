package is.farmhan.dto.response;

import is.farmhan.domain.DisabledType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class DisabledTypeDto {
    private final String disabledType;

    public static DisabledTypeDto fromEntity(DisabledType disabledType) {
        return new DisabledTypeDto(disabledType.getDisabledType());
    }
}
