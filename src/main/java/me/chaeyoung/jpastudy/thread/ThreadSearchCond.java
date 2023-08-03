package me.chaeyoung.jpastudy.thread;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThreadSearchCond {

  private Long channelId; // 채널 Id
  private Long mentionedUserId; // 멘션된 유저의 Id;

}
