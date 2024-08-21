package is.farmhan.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@DynamicUpdate
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userSex;

    @Column(nullable = false)
    private Long userAge;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private String patientNumber;

    @Column(nullable = false)
    private String disabledGrade;

    @Column
    private String significant;

    @Column
    private String request;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String refreshToken;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String apiToken;

//=========================================================================//

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<DisabledType> disabledTypes;

    @Builder
    public User(Long id, String userName, String loginId, String userPassword, String userSex, Long userAge, String patientName, String patientNumber, String disabledGrade, String significant, String request, String refreshToken, String apiToken, List<DisabledType> disabledTypes) {
        this.id = id;
        this.userName = userName;
        this.loginId = loginId;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userAge = userAge;
        this.patientName = patientName;
        this.patientNumber = patientNumber;
        this.disabledGrade = disabledGrade;
        this.significant = significant;
        this.request = request;
        this.refreshToken = refreshToken;
        this.apiToken = apiToken;
        this.disabledTypes = disabledTypes;
    }
}
