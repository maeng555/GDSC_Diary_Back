package com.example.gdsc.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Dairy")
public class Diary {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id", nullable = false)
    private Long diaryId;


    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "content", nullable = false, length = 255)
    private String content;

    @Column(name = "diary_at", nullable = false, length = 255)
    private Date diaryAt;


    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Emotion emotionType;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private User account;

    // 일대일 관계를 추가: Diary와 DailyEmotion은 일대일 관계입니다.
    @OneToOne(mappedBy = "diary", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private DailyEmotion dailyEmotion;
    //mappedby 자기가 주인이아니라는것 즉 외래키가 연결된 일일 감정이 가지고잇으므로 주인이다

}



