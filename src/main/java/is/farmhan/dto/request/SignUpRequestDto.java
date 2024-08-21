package is.farmhan.dto.request;

import is.farmhan.domain.DisabledType;
import is.farmhan.domain.User;
import lombok.Getter;

import java.util.List;
@Getter
public class SignUpRequestDto {

    private String loginId;
    private String userPassword;
    private String userName;
    private Long userAge;
    private String userSex;
    private String patientName;
    private String patientNumber;
    private List<DisabledType> disabledType;
    private String disabledGrade;
    private String significant;
    private String request;

    public User toEntity(SignUpRequestDto signUpRequestDto) {
        return User.builder()
                .loginId(signUpRequestDto.getLoginId())
                .userPassword(signUpRequestDto.getUserPassword())
                .userName(signUpRequestDto.getUserName())
                .userAge(signUpRequestDto.getUserAge())
                .userSex(signUpRequestDto.getUserSex())
                .patientName(signUpRequestDto.getPatientName())
                .patientNumber(signUpRequestDto.getPatientNumber())
                .disabledTypes(signUpRequestDto.getDisabledType())
                .disabledGrade(signUpRequestDto.getDisabledGrade())
                .significant(signUpRequestDto.getSignificant())
                .request(signUpRequestDto.getRequest())
                .build();
    }

}
