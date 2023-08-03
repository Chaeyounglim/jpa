/*
package me.chaeyoung.jpastudy.userChannel;

import me.chaeyoung.jpastudy.channel.ChannelRepository;
import me.chaeyoung.jpastudy.common.PageDTO;
import me.chaeyoung.jpastudy.user.User;
import me.chaeyoung.jpastudy.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Rollback(value = false)
@Transactional
class UserChannelRepositoryTest {

    @Autowired
    private UserChannelRepository userChannelRepository;


    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private UserRepository userRepository;

*/
/*  @Test
  void userJoinChannelTest() {
    // given
    var newChannel = Channel.builder().name("new-group").build();
    var newUser = User.builder().username("new User").password("new pass").build();
    var newUserChannel = newChannel.joinUser(newUser);

    // when
    var savedChannel = channelRepository.insertChannel(newChannel);
    var savedUser = userRepository.save(newUser);

    // then
    var foundChannel = channelRepository.selectChannel(savedChannel.getId());
    assert foundChannel.getUserChannels().stream()
        .map(UserChannel::getChannel)
        .map(Channel::getName)
        .anyMatch(name -> name.equals(newChannel.getName()));
  }


  @Test
  void userJoinChannelWithCascadeTest() {
    // given
    var newChannel = Channel.builder().name("new-channel").build();
    var newUser = User.builder().username("new user").password("new pass").build();
    newChannel.joinUser(newUser);
    // Channel 또는 User 클래스 (일 위치의 테이블)에 Cascade 를 All 로 설정함.
    // insertChannel() 혹은 insertUser() 시에 해당 엔티티에 엮여있는
    // 연관되어 있는 userChannels 에도 영속성이 전이되어 user_channel 테이블에 저장됨.

    // when
    var savedChannel = channelRepository.insertChannel(newChannel);
    var savedUser = userRepository.save(newUser);

    // then
    var foundChannel = channelRepository.selectChannel(savedChannel.getId());
    assert foundChannel.getUserChannels().stream()
        .map(UserChannel::getChannel)
        .map(Channel::getName)
        .anyMatch(name -> name.equals(newChannel.getName()));
  }*//*



 */
/*  @Test
  void userCustomFieldSortingTest() {
    // given
    var newUser1 = User.builder().username("new user").password("new pass1").build();
    var newUser2 = User.builder().username("new user").password("new pass2").build();
    userRepository.save(newUser1);
    userRepository.save(newUser2);

    // Sort.by()
    // 오름차순 Test
    // when
    var users = userRepository.findByUsernameWithCustomField("new user", Sort.by("customPassword"));

    // then
    assert users.get(0).getPassword().equals(newUser1.getPassword());

    // 내림차순 Test
    // when
    users = userRepository.findByUsernameWithCustomField("new user",
        Sort.by("customPassword").descending());

    // then
    assert users.get(0).getPassword().equals(newUser2.getPassword());

    // JpaSort
    // given
    var newUser3 = User.builder().username("new user").password("3").build();
    userRepository.save(newUser3);

    // when
    users = userRepository.findByUsername("new user",
        JpaSort.unsafe("LENGTH(password)"));

    // then
    assert users.get(0).getPassword().equals(newUser3.getPassword());
  }*//*



    @Test
    void pageDTOTest() {
        // given
        var newUser1 = User.builder().username("new user").password("new pass1").build();
        var newUser2 = User.builder().username("new user").password("new pass2").build();
        var newUser3 = User.builder().username("new user").password("new pass3").build();
        userRepository.save(newUser1);
        userRepository.save(newUser2);
        userRepository.save(newUser3);
        var pageDTO = new PageDTO(1, 2, "password");

        // when
        var page = userRepository.findAll(pageDTO.toPageable());

        // then
        assert page.getContent().size() == 2;
    }
}
*/
