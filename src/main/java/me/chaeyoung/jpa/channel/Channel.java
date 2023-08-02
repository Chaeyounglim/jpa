package me.chaeyoung.jpa.channel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.chaeyoung.jpa.common.TimeStamp;
import me.chaeyoung.jpa.thread.Thread;
import me.chaeyoung.jpa.user.User;
import me.chaeyoung.jpa.userChannel.UserChannel;

// lombok
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

// JPA
@Entity
public class Channel extends TimeStamp {

  /**
   * 컬럼 - 연관관계 컬럼을 제외한 컬럼을 정의합니다.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private Type type;

  public enum Type {
    PUBLIC, PRIVATE
  }

  /**
   * 생성자 - 약속된 형태로만 생성가능하도록 합니다.
   */
  @Builder
  public Channel(String name, Type type) {
    this.name = name;
    this.type = type;
  }

  /**
   * 연관관계 - Foreign Key 값을 따로 컬럼으로 정의하지 않고 연관 관계로 정의합니다.
   */
  // Set 은 List 와는 다르게 저장된 값이 순서가 없어 중복 미허용.
  // LinkedHashSet 은 순서 보장
  @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Thread> threads = new LinkedHashSet<>();
  // 한 채널에 여러개의 스레드 존재

  @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<UserChannel> userChannels = new LinkedHashSet<>();
  // 한 채널에 여러 유저 존재


  /**
   * 연관관계 편의 메소드 - 반대쪽에는 연관관계 편의 메소드가 없도록 주의합니다.
   */
  public void addThread(Thread thread) {
    this.threads.add(thread);
  } // 채널과 스레드는 양방향이므로 연관관계 편의 메서드 둘다 생성

  public UserChannel joinUser(User user) {
    var userChannel = UserChannel.builder().user(user).channel(this).build();
    this.userChannels.add(userChannel);
    user.getUserChannels().add(userChannel);
    return userChannel;
  }

  /**
   * 서비스 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
   */

  /**
   * 라이프 사이클 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
   */
  @PrePersist
  public void prePersist() {
    super.updateCreatedAt();
    super.updateModifiedAt();
  }

  @PreUpdate
  public void preUpdate() {
    super.updateModifiedAt();
  }

}
