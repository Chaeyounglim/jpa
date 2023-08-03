package me.chaeyoung.jpastudy.emotion;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.chaeyoung.jpastudy.comment.Comment;
import me.chaeyoung.jpastudy.user.User;

// lombok
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

// jpa
@Entity
public class CommentEmotion extends Emotion {

  @Builder
  public CommentEmotion(User user, Comment comment, String body) {
    this.user = user;
    this.body = body;
    this.comment = comment;
  }

  @ManyToOne
  @JoinColumn(name = "comment_id")
  Comment comment;


}
