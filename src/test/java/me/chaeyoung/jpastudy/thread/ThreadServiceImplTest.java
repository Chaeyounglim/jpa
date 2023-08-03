package me.chaeyoung.jpastudy.thread;


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

@SpringBootTest
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
        var threadWriter = getTestUser("1", "1");
        var threadMentioneduser = getTestUser("2", "2");
        var threadEmotionUser = getTestUser("3", "3");
        var commentUser = getTestUser("4", "4");
        var commentEmotionedUser = getTestUser("5", "5");
        var newChannel = Channel.builder().name("channel").type(Channel.Type.PUBLIC).build();
        var savedChannel = channelRepository.save(newChannel);
        // 완료

        var thread1 = getTestThread("message", savedChannel, threadWriter, threadMentioneduser,
                threadEmotionUser, "e1", commentUser, "c1", commentEmotionedUser, "ce1");
        var thread2 = getTestThread("", savedChannel, threadWriter, threadMentioneduser,
                threadEmotionUser, "e2", commentUser, "c2", commentEmotionedUser, "ce2");

        // when
        var pageDto = PageDTO.builder().currentPage(1).size(100).build();
        var mentionedTheadList = threadService.selectMentionedTheadList(threadWriter.getId(), pageDto);

        // then
        System.out.println("T4 : " + mentionedTheadList.stream().toList().toString());
        assert mentionedTheadList.getTotalElements() == 2; // 사이즈가 두 개가 나와야 함
    }


    // User 정보 저장 메서드
    private User getTestUser(String username, String password) {
        var newUser = User.builder().username(username).password(password).build();
        return userRepository.save(newUser);
    }

    // Comment 정보 저장 메서드 (user 연관 관계 설정)
    private Comment getTestComment(User user, String message) {
        var newComment = Comment.builder().message(message).build();
        newComment.setUser(user);
        return commentRepository.save(newComment);
    }

    // Thread 정보 저장 메서드
    private Thread getTestThread(String message, Channel savedChannel, User threadUser) {
        var newThread = Thread.builder().message(message).build();
        newThread.setUser(threadUser);
        newThread.setChannel(savedChannel);
        return threadService.insert(newThread);
    }

    private Thread getTestThread(String message, Channel channel, User threadUser, User mentionedUser) {
        var newThead = getTestThread(message, channel, threadUser);
        newThead.addMention(mentionedUser);
        return threadService.insert(newThead);
    }

    private Thread getTestThread(String message, Channel channel, User threadUser, User mentionedUser,
                                 User emotionUser, String emotionValue) {
        var newThead = getTestThread(message, channel, threadUser, mentionedUser);
        newThead.addEmotion(emotionUser, emotionValue);
        return threadService.insert(newThead);
    }

    private Thread getTestThread(String message, Channel channel, User threadUser, User mentionedUser,
                                 User emotionUser, String emotionValue, User commentUser, String commentMessage) {
        var newThead = getTestThread(message, channel, threadUser, mentionedUser, emotionUser, emotionValue);
        newThead.addComment(getTestComment(commentUser, commentMessage));
        return threadService.insert(newThead);
    }

    private Thread getTestThread(String message, Channel channel, User threadUser, User mentionedUser,
                                 User emotionUser, String emotionValue, User commentUser, String commentMessage,
                                 User commentEmotionuser, String commentEmotionValue) {
        var newThead = getTestThread(message, channel, threadUser, mentionedUser, emotionUser, emotionValue, commentUser, commentMessage);
        var newComment = getTestComment(commentUser, commentMessage);

        newThead.getComments()
                .forEach(comment -> comment.addEmotion(commentEmotionuser, commentEmotionValue));

        return threadService.insert(newThead);
    }
}



 /*   @Test
    @Rollback(value = false)
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
        System.out.println("채널명" + channel.getName());

        // 스레드
        var thread1 = getTestThread("message", channel, user, commentEmotionUser, "comment emotion1",
                emotionUser, "emotion1", commentUser, "comment1");
        var thread2 = getTestThread("", channel, user, commentEmotionUser, "comment emotion2",
                emotionUser, "emotion2", commentUser, "comment2");

        // when
        var pageDTO = PageDTO.builder().currentPage(1).size(10).build();
        var mentionedThreads = threadService.selectMentionedTheadList(user.getId(), pageDTO);
        System.out.println("채널명" + channel.getName());


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

}*/
