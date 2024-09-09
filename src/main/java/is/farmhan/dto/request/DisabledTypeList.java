package is.farmhan.dto.request;

import is.farmhan.domain.DisabledType;
import is.farmhan.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Block;

@Getter
@AllArgsConstructor
public class DisabledTypeList {

    private String disabledType;

    public DisabledType toEntity(User user) {
        return DisabledType.builder()
                .user(user)
                .disabledType(this.disabledType)
                .build();
    }

}
