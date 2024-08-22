package is.farmhan.dto.request;

import is.farmhan.domain.DisabledType;
import is.farmhan.domain.User;
import lombok.Getter;

import java.util.List;
@Getter
public class SignUpRequestDto {

    private String userLoginId;
    private String userPassword;
    private String userName;
    private String userNumber;
    private String patientAge;
    private String patientSex;
    private String patientName;
    private List<DisabledType> disabledType;
    private String disabledGrade;
    private String significant;
    private String requirement;



    public User toEntity(SignUpRequestDto signUpRequestDto) {
        return User.builder()
                .userLoginId(signUpRequestDto.getUserLoginId())
                .userPassword(signUpRequestDto.getUserPassword())
                .userName(signUpRequestDto.getUserName())
                .userNumber(signUpRequestDto.getUserNumber())
                .patientAge(signUpRequestDto.getPatientAge())
                .patientSex(signUpRequestDto.getPatientSex())
                .patientName(signUpRequestDto.getPatientName())
                .disabledTypes(signUpRequestDto.getDisabledType())
                .disabledGrade(signUpRequestDto.getDisabledGrade())
                .significant(signUpRequestDto.getSignificant())
                .requirement(signUpRequestDto.getRequirement())
                .build();
    }

}
