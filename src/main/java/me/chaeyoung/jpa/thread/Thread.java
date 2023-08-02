package me.chaeyoung.jpa.thread;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.chaeyoung.jpa.channel.Channel;
import me.chaeyoung.jpa.comment.Comment;
import me.chaeyoung.jpa.common.TimeStamp;
import me.chaeyoung.jpa.emotion.ThreadEmotion;
import me.chaeyoung.jpa.mention.ThreadMention;
import me.chaeyoung.jpa.user.User;

// lombok
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

// jpa
@Entity
public class Thread extends TimeStamp {

  /**
   * 컬럼 - 연관관계 컬럼을 제외한 컬럼을 정의합니다.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(length = 500)
  private String message;


  /**
   * 생성자 - 약속된 형태로만 생성가능하도록 합니다.
   */
  @Builder
  public Thread(String message) {
    this.message = message;
  }


  /**
   * 연관관계 - Foreign Key 값을 따로 컬럼으로 정의하지 않고 연관 관계로 정의합니다.
   */
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "channel_id")
  private Channel channel;

  @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Comment> comments = new LinkedHashSet<>();


  @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ThreadMention> mentions = new LinkedHashSet<>();


  @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ThreadEmotion> emotions = new LinkedHashSet<>();


  /**
   * 연관관계 편의 메소드 - 반대쪽에는 연관관계 편의 메소드가 없도록 주의합니다.
   */
  public void setChannel(Channel channel) {
    this.channel = channel;
    channel.addThread(this);
  } // 채널과 스레드는 양방향이므로 연관관계 편의 메서드 둘다 생성

  public void addMention(User user) {
    var mention = ThreadMention.builder().user(user).thread(this).build();
    this.mentions.add(mention);
    user.getThreadMentions().add(mention);
  } // 유저에도 스레드 멘션 목록에 멘션 추가

  public void addComment(Comment comment) {
    this.comments.add(comment);
    comment.setThread(this);
  } // 커멘트에도 스레드 연관 관계 설정

  public void addEmotion(User user, String body) {
    var emotion = ThreadEmotion.builder().user(user).thread(this).body(body).build();
    this.emotions.add(emotion);
  } // 스레드에 따른 이모션을 추가함

  /**
   * 서비스 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
   */

}
