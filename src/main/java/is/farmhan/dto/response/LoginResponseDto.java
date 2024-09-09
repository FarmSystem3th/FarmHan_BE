package is.farmhan.dto.response;

import is.farmhan.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
@Getter
@Builder
@RequiredArgsConstructor
public class LoginResponseDto {
    private final Long userId;

    public static LoginResponseDto of(User user){
        return LoginResponseDto.builder()
                .userId(user.getId())
                .build();
    }
}
