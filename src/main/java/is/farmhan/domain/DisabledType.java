package is.farmhan.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@RequiredArgsConstructor
@Getter
@DynamicUpdate
@Table(name = "DISABLEDTYPE_TB")

public class DisabledType {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String disabledType;

//=========================================================================//

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
