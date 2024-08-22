package is.farmhan.dto.response;

import is.farmhan.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class LoginResponseDto {
    private final Long userId;


    @Builder
    public LoginResponseDto(Long userId) {
        this.userId = userId;
    }

    public static LoginResponseDto of(User user){
        return LoginResponseDto.builder()
                .userId(user.getId())
                .build();
    }
}
