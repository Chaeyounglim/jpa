package me.chaeyoung.jpastudy.thread;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.chaeyoung.jpastudy.channel.Channel;
import me.chaeyoung.jpastudy.comment.Comment;
import me.chaeyoung.jpastudy.common.Timestamp;
import me.chaeyoung.jpastudy.emotion.ThreadEmotion;
import me.chaeyoung.jpastudy.mention.ThreadMention;
import me.chaeyoung.jpastudy.user.User;

// lombok
@Getter
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)

// jpa
@Entity
public class Thread extends Timestamp {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  /**
   * 컬럼 - 연관관계 컬럼을 제외한 컬럼을 정의합니다.
   */
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
  @ManyToOne // 항상 쓰일 거라 Lazy가 아닌 기본 Eager로 놔둠
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "channel_id")
  private Channel channel;

  @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
  Set<Comment> comments = new LinkedHashSet<>();

  @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
  Set<ThreadMention> mentions = new LinkedHashSet<>();

  @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
  Set<ThreadEmotion> emotions = new LinkedHashSet<>();


  /**
   * 연관관계 편의 메소드 - 반대쪽에는 연관관계 편의 메소드가 없도록 주의합니다.
   */
  public void setUser(User user) {
    this.user = user;
  }

  public void setChannel(Channel channel) {
    this.channel = channel;
    channel.addThread(this);
  }

  public void addMention(User user) {
    // mention을 생성해서
    var mention = ThreadMention.builder().user(user).thread(this).build();
    this.mentions.add(mention);
    user.getThreadMentions().add(mention);
  }

  public void setComment(Comment comment) {
    this.comments.add(comment);
    comment.setThread(this);
  }

  public void addEmotion(User user, String body) {
    var emotion = ThreadEmotion.builder().user(user).thread(this).body(body).build();
    this.emotions.add(emotion);
  }

  @Override
  public String toString() {
    return "[스레드] threadMsg: " + this.getMessage() + ", thread_id: " + this.id + ", user_id: "
        + this.user.getId() + ", channel_id: " + this.channel.getId();
  }
  /**
   *
   * 서비스 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
   */

}
