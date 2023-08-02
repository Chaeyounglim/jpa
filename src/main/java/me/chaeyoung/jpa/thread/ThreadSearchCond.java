package me.chaeyoung.jpa.thread;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThreadSearchCond {
  // 조건에 필요한 필드들을 모아놓음.

  private Long channelId; // 채널 Id
  private Long mentionedUserId; // 멘션된 user_id


}
