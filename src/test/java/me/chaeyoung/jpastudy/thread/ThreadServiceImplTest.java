package me.chaeyoung.jpastudy.thread;


import me.chaeyoung.jpastudy.Application;
import me.chaeyoung.jpastudy.channel.Channel;
import me.chaeyoung.jpastudy.channel.ChannelRepository;
import me.chaeyoung.jpastudy.comment.Comment;
import me.chaeyoung.jpastudy.comment.CommentRepository;
import me.chaeyoung.jpastudy.common.PageDTO;
import me.chaeyoung.jpastudy.user.User;
import me.chaeyoung.jpastudy.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = Application.class)
class ThreadServiceImplTest {

  @Autowired
  UserRepository userRepository;

  @Autowired
  ThreadService threadService;

  @Autowired
  ChannelRepository channelRepository;

  @Autowired
  CommentRepository commentRepository;

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  void testBeans() {
    String[] beanNames = applicationContext.getBeanDefinitionNames();
    for (String beanName : beanNames) {
      Object bean = applicationContext.getBean(beanName);
      System.out.println(beanName + ": " + bean.getClass().getName());
    }
  }

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

// 아래 세 개의 테스트의 차이점은 ThreadRepositoryQueryImpl 파일에 fetchJoin()을 확인하면 됨 (하나씩 늘어남) *//
/*
    @Test
    @DisplayName("전체 채널에서 내가 멘션된 쓰레드 상세정보 목록 테스트")
    void selectMentionedThreadListTest() {
        // given
        var user = getTestUser("Test1 user", "Test1 pass");

        var newChannel = Channel.builder().name("Test1 channel").type(Channel.Type.PUBLIC).build();
        var savedChannel = channelRepository.save(newChannel);
        var thread1 = getTestThread("message", savedChannel, user);
        var thread2 = getTestThread("", savedChannel, user);

        // when
        var pageDto = PageDTO.builder().currentPage(1).size(100).build();
        var mentionedTheadList = threadService.selectMentionedTheadList(user.getId(), pageDto);

        // then
        System.out.println("T1 : " + mentionedTheadList.getContent());
        assert mentionedTheadList.getTotalElements() == 2; // 사이즈가 두 개가 나와야 함
    }

    @Test
    @DisplayName("전체 채널에서 내가 멘션된 쓰레드 및 이모티콘 상세정보 목록 테스트")
    void selectMentionedThreadEmotionListTest() {

        // given
        var user = getTestUser("111", "1111");
        var user2 = getTestUser("2222", "222");
        var newChannel = Channel.builder().name("c111").type(Channel.Type.PUBLIC).build();
        var savedChannel = channelRepository.save(newChannel);
        var thread1 = getTestThread("messaeege", savedChannel, user, user2, "e1111");
        var thread2 = getTestThread("", savedChannel, user, user2, "e2222");

        // when
        var pageDto = PageDTO.builder().currentPage(1).size(100).build();
        var mentionedTheadList = threadService.selectMentionedTheadList(user.getId(), pageDto);

        // then
        System.out.println("T2 : " + mentionedTheadList.stream().toList().toString());
        assert mentionedTheadList.getTotalElements() == 2; // 사이즈가 두 개가 나와야 함
    }

    @Test
    @DisplayName("전체 채널에서 내가 멘션된 쓰레드 및 이모티콘 및 댓글(with 이모지) 상세정보 목록 테스트")
    void selectMentionedThreadEmotionCommentListTest() {
        // given
        var user = getTestUser("1", "1");
        var user2 = getTestUser("2", "2");
        var user3 = getTestUser("3", "3");
        var newChannel = Channel.builder().name("c1").type(Channel.Type.PUBLIC).build();
        var savedChannel = channelRepository.save(newChannel);
        var thread1 = getTestThread("message", savedChannel, user, user2, "e1");
        var thread2 = getTestThread("", savedChannel, user, user2, "e2");

        // when
        var pageDto = PageDTO.builder().currentPage(1).size(100).build();
        var mentionedTheadList = threadService.selectMentionedTheadList(user.getId(), pageDto);

        // then
        System.out.println("T3 : " + mentionedTheadList.stream().toList().toString());
        assert mentionedTheadList.getTotalElements() == 2; // 사이즈가 두 개가 나와야 함
    }*/

  @Test
  @DisplayName("전체 채널에서 내가 멘션된 쓰레드 및 이모티콘 및 댓글(with 이모지) 상세정보 목록 테스트")
  void selectMentionedThreadEmotionCommentEmotionListTest() {

    // given
    var threadWriter = getTestUser("threadWriter", "1");
    var threadMentionedUser = getTestUser("threadMentionedUser", "2");
    var threadEmotionUser = getTestUser("threadEmotionUser", "3");
    var commentUser = getTestUser("commentUser", "4");
    var commentEmotionUser = getTestUser("commentEmotionUser", "5");
    var newChannel = Channel.builder().name("channel").type(Channel.Type.PUBLIC).build();
    var savedChannel = channelRepository.save(newChannel);
    // 완료

    var thread1 = getTestThread("thread1", savedChannel, threadWriter, threadMentionedUser,
        threadEmotionUser, "threadEmotion1", commentUser, "comment1",
        commentEmotionUser, "commentEmotion1");
    var thread2 = getTestThread("thread2", savedChannel, threadWriter, threadMentionedUser,
        threadEmotionUser, "threadEmotion2", commentUser, "comment2",
        commentEmotionUser, "commentEmotion2");
    // DB에 저장까지 모두 completed!

    // DB 에서 조회해오는 부분이 XX
    // when
    var pageDto = PageDTO.builder().currentPage(1).size(100).build();
    var mentionedTheadList = threadService.selectMentionedTheadList(Long.getLong("2"), pageDto);
    System.out.println(mentionedTheadList.toString()); // -> 0으로 나옴. why?

    // then
    assert mentionedTheadList.getTotalElements() == 2; // 사이즈가 두 개가 나와야 함
  }


  // User 정보 저장 메서드
  private User getTestUser(String username, String password) {
    var newUser = User.builder().username(username).password(password).build();
    return userRepository.save(newUser);
  }

  // Comment 엔티티 객체 생성 메서드 (user 연관 관계 설정)
  private Comment getTestComment(User user, String message) {
    var newComment = Comment.builder().message(message).build();
    newComment.setUser(user);
    return newComment;
  }

  // Thread 정보 저장 메서드 (유저랑 채널 연관관계 설정)
  private Thread getTestThread(String message, Channel savedChannel, User threadUser) {
    var newThread = Thread.builder().message(message).build();
    newThread.setUser(threadUser);
    newThread.setChannel(savedChannel);
    return threadService.insert(newThread);
  }

  // Thread 정보 저장 메서드 (ThreadMention 이랑 연관관계 설정) -> Cascade 속성을 통해 DB에 저장
  private Thread getTestThread(String message, Channel channel, User threadUser,
      User mentionedUser) {
    var newThead = getTestThread(message, channel, threadUser);
    newThead.addMention(mentionedUser);
    return threadService.insert(newThead);
  }

  // Thread 정보 저장 메서드 (ThreadEmotion 이랑 연관관계 설정) -> cascade 속성을 통해 DB에 저장
  private Thread getTestThread(String message, Channel channel, User threadUser, User mentionedUser,
      User emotionUser, String emotionValue) {
    var newThead = getTestThread(message, channel, threadUser, mentionedUser);
    newThead.addEmotion(emotionUser, emotionValue);
    return threadService.insert(newThead);
  }

  // Thread 정보 저장 및 댓글에 영속성 전이를 통해 DB에 저장 메서드
  // (Comment 객체 생성한 후 이를 Thread 랑 연관관계 설정) -> cascade 속성을 통해 DB에 저장
  private Thread getTestThread(String message, Channel channel, User threadUser, User mentionedUser,
      User emotionUser, String emotionValue, User commentUser, String commentMessage) {
    var newThead = getTestThread(message, channel, threadUser, mentionedUser, emotionUser,
        emotionValue);
    newThead.setComment(getTestComment(commentUser, commentMessage));
    return threadService.insert(newThead);
  }

  // Thread 정보 저장 및
  private Thread getTestThread(String message, Channel channel, User threadUser, User mentionedUser,
      User emotionUser, String emotionValue, User commentUser, String commentMessage,
      User commentEmotionuser, String commentEmotionValue) {
    var newThead = getTestThread(message, channel, threadUser, mentionedUser, emotionUser,
        emotionValue, commentUser, commentMessage);

    newThead.getComments()
        .forEach(comment -> comment.addEmotion(commentEmotionuser, commentEmotionValue));

    return threadService.insert(newThead);
  }
}