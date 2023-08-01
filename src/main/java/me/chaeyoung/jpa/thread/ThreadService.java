package me.chaeyoung.jpa.thread;

import java.util.List;
import me.chaeyoung.jpa.channel.Channel;
import me.chaeyoung.jpa.user.User;

public interface ThreadService {

  List<Thread> selectMentionedThreadList(User user);

  List<Thread> selectNotEmptyThreadList(Channel channel);

  Thread insert(Thread thread);
}
