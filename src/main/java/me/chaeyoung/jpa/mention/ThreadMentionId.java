package me.chaeyoung.jpa.mention;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class ThreadMentionId implements Serializable {

  @Serial
  private static final long serialVersionUID = 7715456209285796293L;

  // Serializable 는 id로 설정하기 위해 반드시 필요함.
  @Column(name = "user_id")
  private Long userId;

  @Column(name = "thread_id")
  private Long threadId;

  @Override
  public boolean equals(Object e) {
    if (this == e) {
      return true;
    }
    if (e == null || getClass() != e.getClass()) {
      return false;
    }
    ThreadMentionId mentionId = (ThreadMentionId) e;
    return Objects.equals(getUserId(), mentionId.getUserId()) && Objects.equals(getThreadId()
        , mentionId.getThreadId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUserId(), getThreadId());
  }


}
