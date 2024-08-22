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
    private final String userName;
    private final Long userAge;
    private final String userSex;
    private final String patientName;
    private final String patientNumber;
    private final List<DisabledType> disabledType;
    private final String disabledGrade;
    private final String significant;
    private final String request;

    @Builder
    public MypageResponseDto(String userName, Long userAge, String userSex, String patientName, String patientNumber, List<DisabledType> disabledType, String disabledGrade, String significant, String request) {
        this.userName = userName;
        this.userAge = userAge;
        this.userSex = userSex;
        this.patientName = patientName;
        this.patientNumber = patientNumber;
        this.disabledType = disabledType;
        this.disabledGrade = disabledGrade;
        this.significant = significant;
        this.request = request;
    }

    public static MypageResponseDto of(User user) {
        return MypageResponseDto.builder()
                .userName(user.getUserName())
                .userAge(user.getUserAge())
                .userSex(user.getUserSex())
                .patientName(user.getPatientName())
                .patientNumber(user.getPatientNumber())
                .disabledType(user.getDisabledTypes())
                .disabledGrade(user.getDisabledGrade())
                .significant(user.getSignificant())
                .request(user.getRequest())
                .build();
    }


}
