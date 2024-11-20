package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="account_id",nullable = false)
    private Long accountId;

    @Column(name = "login_id", nullable = false, length = 255)
    private String loginId;

    @Column(name="name",nullable = false,length = 255)
    private String name;

    @Column(name = "provider",nullable = false,length = 255)
    private String provider;

   //일기 일대다 ㅇ외래키는 일기한테  일대다이므로 리스트로 갖고온다
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diary> diaries;
    //일대다 외래키는 주간감정에 cascaed =부모 엔티티에서 수행된 작업(예: 저장, 삭제 등)을 자식 엔티티에 자동으로 전파하는 역할을 합니다.
    // orphanRemoval  true는 부모 엔티티에서 자식 엔티티의 참조가 끊어졌을 때, 자식 엔티티를 자동으로 삭제하는 역할을 합니다.
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeeklyEmotion> weeklyEmotions;
    //token
    @OneToOne(mappedBy = "account")
    private token token;





}



