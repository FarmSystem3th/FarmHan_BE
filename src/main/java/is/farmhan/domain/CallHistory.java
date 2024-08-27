package is.farmhan.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.bind.annotation.BindParam;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@RequiredArgsConstructor
@Getter
@DynamicUpdate
@Table(name = "CALL_HISTORY_TB")
public class CallHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime createAt;

    @Column(columnDefinition = "TEXT")
    private String messageQuestion;

    @Column(columnDefinition = "TEXT")
    private String messageAnswer;

    //=========================================================================//


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "call_id", nullable = false)
    private Call call;

    @Builder
    public CallHistory(Long id, LocalDateTime createAt, String messageQuestion, String messageAnswer, Call call) {
        this.id = id;
        this.createAt = createAt;
        this.messageQuestion = messageQuestion;
        this.messageAnswer = messageAnswer;
        this.call = call;
    }
}
