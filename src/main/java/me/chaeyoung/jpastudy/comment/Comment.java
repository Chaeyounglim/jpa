package me.chaeyoung.jpastudy.comment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import me.chaeyoung.jpastudy.emotion.CommentEmotion;
import me.chaeyoung.jpastudy.mention.CommentMention;
import me.chaeyoung.jpastudy.thread.Thread;
import me.chaeyoung.jpastudy.user.User;

// lombok
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

// jpa
@Entity
@Table
public class Comment {

  @Id
  @Getter(AccessLevel.NONE)
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  Long id;

  private String message;

  @Builder
  public Comment(String message) {
    this.message = message;
  }

  @ManyToOne
  @JoinColumn(name = "user_id")
  User user;

  @ManyToOne
  @JoinColumn(name = "thread_id")
  Thread thread;

  @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
  Set<CommentMention> mentions = new LinkedHashSet<>();

  @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
  Set<CommentEmotion> emotions = new LinkedHashSet<>();


  public void setUser(User user) {
    this.user = user;
  }

  public void setThread(Thread thread) {
    this.thread = thread;
  }

  public void addEmotion(User user, String body) {
    var emotion = CommentEmotion.builder().user(user).body(body).comment(this).build();
    this.emotions.add(emotion);
  }

  // 멘션은 아직 XX

  @Override
  public String toString() {
    return "[댓글] commentMsg: " + this.getMessage() + ", user_id: " + this.user.getId()
        + ", thread_id: " + this.thread.getId();
  }
}
