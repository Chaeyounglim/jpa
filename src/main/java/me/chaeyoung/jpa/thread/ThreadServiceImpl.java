package me.chaeyoung.jpa.thread;

import com.mysema.commons.lang.IteratorAdapter;
import java.util.List;
import me.chaeyoung.jpa.channel.Channel;
import me.chaeyoung.jpa.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreadServiceImpl implements ThreadService {

  @Autowired
  ThreadRepository threadRepository;

  @Override
  public List<Thread> selectMentionedThreadList(User user) {
    // 내가 멘션된 스레드 리스트를 받아와야 함.
    var thread = QThread.thread;

    var predicate = thread.mentions.any().user.eq(user);
    // BooleanExpression 이여서 조건문으로 바뀜.

    var threads = threadRepository.findAll(predicate);
    // threads 가 List가 아니여서 타입을 바꿔서 반환 필요

    return IteratorAdapter.asList(threads.iterator());
  }

  @Override
  public List<Thread> selectNotEmptyThreadList(Channel channel) {
    // 내가 멘션된 스레드 리스트를 받아와야 함.
    var thread = QThread.thread;

    // 메세지가 비어있지 않은 해당 채널의 스레드 목록
    var predicate = thread.channel
        .eq(channel)
        .and(thread.message.isNotEmpty());
    var threads = threadRepository.findAll(predicate);

    return IteratorAdapter.asList(threads.iterator());
  }

  @Override
  public Thread insert(Thread thread) {
    return threadRepository.save(thread);
  }
}
