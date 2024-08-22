package is.farmhan.dto.response;

import is.farmhan.domain.DisabledType;
import is.farmhan.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class MypageResponseDto {
    private final String userLoginId;
    private final String userPassword;
    private final String userName;
    private final String userNumber;
    private final String patientAge;
    private final String patientSex;
    private final String patientName;
    private final List<DisabledType> disabledType;
    private final String disabledGrade;
    private final String significant;
    private final String requirement;

    @Builder
    public MypageResponseDto(String userLoginId, String userPassword, String userName, String userNumber, String patientAge, String patientSex, String patientName, List<DisabledType> disabledType, String disabledGrade, String significant, String requirement) {
        this.userLoginId = userLoginId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNumber = userNumber;
        this.patientAge = patientAge;
        this.patientSex = patientSex;
        this.patientName = patientName;
        this.disabledType = disabledType;
        this.disabledGrade = disabledGrade;
        this.significant = significant;
        this.requirement = requirement;
    }

    public static MypageResponseDto of(User user) {
        return MypageResponseDto.builder()
                .userLoginId(user.getUserLoginId())
                .userPassword(user.getUserPassword())
                .userName(user.getUserName())
                .userNumber(user.getUserNumber())
                .patientAge(user.getPatientAge())
                .patientSex(user.getPatientSex())
                .patientName(user.getPatientName())
                .disabledType(user.getDisabledTypes())
                .disabledGrade(user.getDisabledGrade())
                .significant(user.getSignificant())
                .requirement(user.getRequirement())
                .build();
    }


}
