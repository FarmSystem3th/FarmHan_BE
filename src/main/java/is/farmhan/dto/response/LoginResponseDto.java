package is.farmhan.dto.response;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class LoginResponseDto {
    private String userName;
    private Long userAge;
    private String userSex;
    private String patientName;
    private String patientNumber;
    private List<String> disabledType;
    private String disabledGrade;
    private String significant;
    private String request;
    private Boolean infoCheck;
}
