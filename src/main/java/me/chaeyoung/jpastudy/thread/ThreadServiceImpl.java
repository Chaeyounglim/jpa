package me.chaeyoung.jpastudy.thread;

import com.mysema.commons.lang.IteratorAdapter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import me.chaeyoung.jpastudy.channel.Channel;
import me.chaeyoung.jpastudy.common.PageDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ThreadServiceImpl implements ThreadService {

  private final ThreadRepository threadRepository;

  @Override
  public List<Thread> selectChannelThreads(Channel channel) {
    // 멘션된 전체를 가져와야 함 (?
    var thread = QThread.thread;
    // 메세지가 비어있지 않은 해당 채널의 쓰레드 목록
    var predicate = thread.channel.eq(channel).and(thread.message.isNotEmpty());
    var threads = threadRepository.findAll(predicate);

    // list로 바꿔줌
    return IteratorAdapter.asList(threads.iterator());
  }

  @Transactional
  @Override
  public Page<Thread> selectMentionedTheadList(Long userId, PageDTO pageDto) {
    System.out.println("ThreadServiceImpl userId : " + userId);
    var cond = ThreadSearchCond.builder().mentionedUserId(userId).build();
    System.out.println(
        "ThreadServiceImpl ThreadSearchCond. getMentionedUserId : " + cond.getMentionedUserId());
    return threadRepository.search(cond, pageDto.toPageable());
  }

  @Override
  public Thread insert(Thread thread) {
    return threadRepository.save(thread);
  }
}
