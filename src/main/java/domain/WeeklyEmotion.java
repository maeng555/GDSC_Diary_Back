package domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor // 생성자업이가능
@Entity
@Table(name = "weekly_emotion")
public class WeeklyEmotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weekly_emotion_id")
    private Long id;

    @Column(name = "avg_happiness", nullable = false)
    private Double avgHappiness;

    @Column(name = "avg_anger", nullable = false)
    private Double avgAnger;

    @Column(name = "avg_sadness", nullable = false)
    private Double avgSadness;

    @Column(name = "avg_surprise", nullable = false)
    private Double avgSurprise;

    @Column(name = "avg_neutral", nullable = false)
    private Double avgNeutral;

    @Column(name = "weekly_detailed_feedback", nullable = false)
    private String weeklyDetailedFeedback;

    @Column(name = "weekly_start_date", nullable = false)
    private Date weeklyStartDate;

    @Column(name = "weekly_end_date", nullable = false)
    private Date weeklyEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private User account;
}
