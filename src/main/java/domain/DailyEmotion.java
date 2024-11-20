package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "daily_emotion")
public class DailyEmotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daily_emotion_id")
    private Long id;

    @Column(name = "happiness", nullable = false)
    private Integer happiness;

    @Column(name = "sadness", nullable = false)
    private Integer sadness;

    @Column(name = "anger", nullable = false)
    private Integer anger;

    @Column(name = "surprise", nullable = false)
    private Integer surprise;

    @Column(name = "neutral", nullable = false)
    private Integer neutral;

    @Column(name = "detailed_feedback", nullable = false)
    private String detailedFeedback;

    @Column(name = "short_feedback",  nullable = false)
    private String shortFeedback;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_id", nullable = false)
    private Diary diary;
    //주인임 외래키를 가지고잇ㅇ므
}
