package me.chaeyoung.jpastudy.thread;

import me.chaeyoung.jpastudy.channel.Channel;
import me.chaeyoung.jpastudy.common.PageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ThreadService {

    List<Thread> selectChannelThreads(Channel channel);

    Page<Thread> selectMentionedTheadList(Long userId, PageDTO pageDTO);

    Thread insert(Thread thread);
}
