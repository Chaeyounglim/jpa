package me.chaeyoung.jpa.thread;


import java.util.List;
import me.chaeyoung.jpa.channel.Channel;
import me.chaeyoung.jpa.channel.Channel.Type;
import me.chaeyoung.jpa.channel.ChannelRepository;
import me.chaeyoung.jpa.mention.Mention;
import me.chaeyoung.jpa.user.User;
import me.chaeyoung.jpa.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreadServiceImplTest {

  @Autowired
  UserRepository userRepository;

  @Autowired
  ThreadService threadService;

  @Autowired
  ChannelRepository channelRepository;

  @Test
  void getMentionsThreadList() {
    // given
    var newUser = User.builder().username("new user").password("new pass").build();
    var savedUser = userRepository.save(newUser);
    var newThread1 = Thread.builder().message("message1").build();
    newThread1.addMention(newUser);
    threadService.insert(newThread1);

    var newThread2 = Thread.builder().message("message2").build();
    newThread2.addMention(newUser);
    threadService.insert(newThread2);

    // when
    var mentionedThreads = savedUser.getMentions().stream().map(Mention::getThread).toList();

    // then
    System.out.println(mentionedThreads);
    assert mentionedThreads.containsAll(List.of(newThread1, newThread2));
  }

  @Test
  void getNotEmptyThreadList() {
    // given
    var newChannel = Channel.builder().name("c1").type(Type.PUBLIC).build();
    var savedChannel = channelRepository.save(newChannel);
    var newThread1 = Thread.builder().message("message1").build();
    newThread1.setChannel(savedChannel);
    threadService.insert(newThread1);

    var newThread2 = Thread.builder().message("").build();
    newThread2.setChannel(newChannel);
    threadService.insert(newThread2);

    // when
    // user 가 맨션된 모든 스레드를 조회함.
    //var mentionedThreads = savedUser.getMentions().stream().map(Mention::getThread).toList();
    var notEmptyThreads = threadService.selectNotEmptyThreadList(savedChannel);

    // then
    assert !notEmptyThreads.contains(newThread2);
  }
}