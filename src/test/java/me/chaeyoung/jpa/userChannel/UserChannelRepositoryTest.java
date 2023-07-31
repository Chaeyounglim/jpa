package me.chaeyoung.jpa.userChannel;

import me.chaeyoung.jpa.channel.Channel;
import me.chaeyoung.jpa.channel.ChannelRepository;
import me.chaeyoung.jpa.user.User;
import me.chaeyoung.jpa.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Rollback(value=false)
@Transactional
class UserChannelRepositoryTest {

    @Autowired
    private UserChannelRepository userChannelRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void userJoinChannelTest() {

        // given
        var newChannel = Channel.builder().name("new-group").build();
        var newUser = User.builder().username("new User").password("new pass").build();
        var newUserChannel = newChannel.joinUser(newUser);


        // when
        var savedChannel = channelRepository.insertChannel(newChannel);
        var savedUser = userRepository.insertUser(newUser);
        var savedUserChannel = userChannelRepository.insertUserChannel(newUserChannel);

        // then
        var foundChannel = channelRepository.selectChannel(savedChannel.getId());
        assert foundChannel.getUserChannels().stream()
                .map(UserChannel::getChannel)
                .map(Channel::getName)
                .anyMatch(name -> name.equals(newChannel.getName()));
    }
}