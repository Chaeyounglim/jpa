package me.chaeyoung.jpa.thread;

import com.mysema.commons.lang.IteratorAdapter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import me.chaeyoung.jpa.channel.Channel;
import me.chaeyoung.jpa.common.PageDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ThreadServiceImpl implements ThreadService {


  private final ThreadRepository threadRepository;

  @Override
  public List<Thread> selectNotEmptyThreadList(Channel channel) {
    var thread = QThread.thread;

    // 메세지가 비어있지 않은 해당 채널의 스레드 목록
    var predicate = thread.channel.eq(channel).and(thread.message.isNotEmpty());
    var threads = threadRepository.findAll(predicate);
    // predicate 조건에 따른 스레드를 findall() 해와라. 그리고 반환하라

    return IteratorAdapter.asList(threads.iterator());
  }

  @Transactional(readOnly = true)
  @Override
  public Page<Thread> selectMentionedThreadList(Long userId, PageDTO pageDTO) {
    var cond = ThreadSearchCond.builder().mentionedUserId(userId).build();
    // 페이징을 할 때, PageRequest 로 요청 받아서 응답은 Pageable 타입으로 반환해야 하므로 -> pageDTO.toPageable()
    return threadRepository.search(cond, pageDTO.toPageable());
  }


  @Override
  public Thread insert(Thread thread) {
    return threadRepository.save(thread);
  }
}
