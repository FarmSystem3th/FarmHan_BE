package is.farmhan.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@DynamicUpdate
@Table(name = "USER_TB")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userLoginId;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userNumber;

    @Column(nullable = false)
    private String patientSex;

    @Column(nullable = false)
    private String patientAge;

    @Column(nullable = false)
    private String patientName;


    @Column(nullable = false)
    private String disabledGrade;

    @Column
    private String significant;

    @Column
    private String requirement;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String secretKey;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String apiToken;

//=========================================================================//

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<DisabledType> disabledTypes;

    @Builder
    public User(Long id, String userLoginId, String userPassword, String userName, String userNumber, String patientSex, String patientAge, String patientName, String disabledGrade, String significant, String requirement, String secretKey, String apiToken, List<DisabledType> disabledTypes) {
        this.id = id;
        this.userLoginId = userLoginId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNumber = userNumber;
        this.patientSex = patientSex;
        this.patientAge = patientAge;
        this.patientName = patientName;
        this.disabledGrade = disabledGrade;
        this.significant = significant;
        this.requirement = requirement;
        this.secretKey = secretKey;
        this.apiToken = apiToken;
        this.disabledTypes = disabledTypes;
    }
}
