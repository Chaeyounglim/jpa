package me.chaeyoung.jpa.thread;


import me.chaeyoung.jpa.channel.Channel;
import me.chaeyoung.jpa.channel.Channel.Type;
import me.chaeyoung.jpa.channel.ChannelRepository;
import me.chaeyoung.jpa.comment.Comment;
import me.chaeyoung.jpa.comment.CommentRepository;
import me.chaeyoung.jpa.common.PageDTO;
import me.chaeyoung.jpa.user.User;
import me.chaeyoung.jpa.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ThreadServiceImplTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ThreadService threadService;

  @Autowired
  private ChannelRepository channelRepository;

  @Autowired
  private CommentRepository commentRepository;

  /*@Test
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
    var mentionedThreads = savedUser.getThreadMentions().stream().map(ThreadMention::getThread)
        .toList();

    // then
    assert mentionedThreads.containsAll(List.of(newThread1, newThread2));
  }

  @Test
  void getNotEmptyThreadList() {
    // given
    var channel = getTestChannel();
    getTestThread("message1", channel);

    Thread newThread2 = getTestThread("", channel);

    // when
    // user 가 맨션된 모든 스레드를 조회함.
    //var mentionedThreads = savedUser.getMentions().stream().map(Mention::getThread).toList();
    var notEmptyThreads = threadService.selectNotEmptyThreadList(channel);

    // then
    assert !notEmptyThreads.contains(newThread2);
  }*/

  @Test
  @Transactional(propagation = Propagation.NEVER)
  @DisplayName("전체 채널에서 내가 멘션된 스레드 상세정보 목록 테스트")
  void selectMentionedThreadListTest() {

    // given

    // 유저
    var user = getTestUser("new user", "new pass");
    var emotionUser = getTestUser("emotion user", "emotion pass");
    var commentUser = getTestUser("comment user", "comment pass");
    var commentEmotionUser = getTestUser("commentEmotionUser user", "commentEmotionUser pass");

    // 채널
    var channel = getTestChannel();

    // 스레드
    var thread1 = getTestThread("message", channel, user, commentEmotionUser, "comment emotion1",
        emotionUser, "emotion1", commentUser, "comment1");
    var thread2 = getTestThread("", channel, user, commentEmotionUser, "comment emotion2",
        emotionUser, "emotion2", commentUser, "comment2");

    // when
    var pageDTO = PageDTO.builder().currentPage(1).size(10).build();
    var mentionedThreads = threadService.selectMentionedThreadList(user.getId(), pageDTO);

    // then
    assert mentionedThreads.getTotalElements() == 2;
  }

  private Channel getTestChannel() {
    var newChannel = Channel.builder().name("c1").type(Type.PUBLIC).build();
    return channelRepository.save(newChannel);
  }

  private User getTestUser(String username, String password) {
    var newUser = User.builder().username(username).password(password).build();
    return userRepository.save(newUser);
  }

  private Comment getTestComment(User user, String message) {
    var newComment = Comment.builder().message(message).build();
    newComment.setUser(user);
    return commentRepository.save(newComment);
  }

  // 스레드에 메시지 값 넣고, 채널 연관관계 설정
  private Thread getTestThread(String message, Channel savedChannel) {
    var newThread = Thread.builder().message(message).build();
    newThread.setChannel(savedChannel); // 양방향이므로 해당 메서드 내에서 채널에도 연관 관계를 설정함
    return threadService.insert(newThread);
  }

  // 스레드에 멘션 연관관계 설정
  private Thread getTestThread(String message, Channel channel, User mentionedUser) {
    var newThread = getTestThread(message, channel);
    newThread.addMention(mentionedUser); // 해당 메서드 내에서 유저에 스레드 멘션 목록에 추가
    return threadService.insert(newThread);
  }

  // 스레드에 이모션 연관관계 설정
  private Thread getTestThread(String message, Channel channel, User mentionedUser,
      User emotionUser, String emotionValue) {
    var newThread = getTestThread(message, channel, mentionedUser);
    newThread.addEmotion(emotionUser, emotionValue); // 스레드에 따른 이모션 정보 추가
    return threadService.insert(newThread);
  }

  private Thread getTestThread(String message, Channel channel, User mentionedUser,
      User emotionUser, String emotionValue, User commentUser, String commentMessage) {
    var newThread = getTestThread(message, channel, mentionedUser, emotionUser, emotionValue);
    newThread.addComment(
        getTestComment(commentUser, commentMessage)); // 스레드에 따른 커멘트 정보 추가, 양방향으로 커멘트에도 추가함
    return threadService.insert(newThread);
  }

  private Thread getTestThread(String message, Channel channel, User mentionedUser,
      User emotionUser, String emotionValue, User commentUser, String commentMessage,
      User commentEmotionUser, String commentEmotionValue) {

    var newThread = getTestThread(message, channel, mentionedUser, emotionUser, emotionValue,
        commentUser, commentMessage);
    newThread.getComments()
        .forEach(comment -> comment.addEmotion(commentEmotionUser, commentEmotionValue));

    return threadService.insert(newThread);
  }

}
