/*
package me.chaeyoung.jpa.thread;

import me.chaeyoung.jpa.channel.Channel;
import me.chaeyoung.jpa.channel.ChannelRepository;
import me.chaeyoung.jpa.user.User;
import me.chaeyoung.jpa.userChannel.UserChannel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value=false)
class ThreadRepositoryTest {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Test
    void insertSelectThreadTest(){

        // given
        var newChannel = Channel.builder().name("new-group").build();
        var newThread = Thread.builder().message("new message").build();
        var newThread2 = Thread.builder().message("new message2").build();
        newThread.setChannel(newChannel); // 채널과 스레드의 연관 관계 설정.
        newThread2.setChannel(newChannel);
        // setChannel 메서드 내부에는 양방향으로 관계를 맺도록 하였음.

        // when
        var savedChannel = channelRepository.insertChannel(newChannel);
        var savedThread = threadRepository.insertThread(newThread);
        var savedThread2 = threadRepository.insertThread(newThread2);

        // then
        var foundChannel = channelRepository.selectChannel(savedChannel.getId());
        assert foundChannel.getThreads().containsAll(Set.of(savedThread, savedThread2));
    }

    @Test
    void deleteThreadByOrphanRemovalTest() {
        // given
        var newChannel = Channel.builder().name("new-group").build();
        var newThread = Thread.builder().message("new message").build();
        var newThread2 = Thread.builder().message("new message2").build();
        newThread.setChannel(newChannel); // 채널과 스레드의 연관 관계 설정.
        newThread2.setChannel(newChannel);  // 채널과 스레드의 연관 관계 설정.
        var savedChannel = channelRepository.insertChannel(newChannel);
        var savedThread = threadRepository.insertThread(newThread);
        var savedThread2 = threadRepository.insertThread(newThread2);

        // when
        var foundChannel = channelRepository.selectChannel(savedChannel.getId());
        foundChannel.getThreads().remove(savedThread);

        // then
        //    delete
        //    from
        //        thread
        //    where
        //        id=?
    }
}*/
