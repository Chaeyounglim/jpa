package me.chaeyoung.jpa.channel;

import com.querydsl.core.types.Predicate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ChannelRepositoryTest {

  @Autowired
  private ChannelRepository channelRepository;


  @Test
  void insertSelectGroupTest() {

    // given
    var newChannel = Channel.builder().name("new-group").build();
    // type 은 null 로 들어갈 것임.

    // when
    var savedChannel = channelRepository.save(newChannel);

    // then
    var foundChannel = channelRepository.findById(savedChannel.getId());
    // DB 에 select 쿼리문을 날리지 않고 영속성 컨텍스트 내에서 가져옴.
    assert foundChannel.get().getId().equals(savedChannel.getId());
  }

  @Test
  void queryDslTest() {
    // given
    var newChannel = Channel.builder().name("chaeyoung").build();
    channelRepository.save(newChannel);

    Predicate predicate = QChannel.channel
        .name.equalsIgnoreCase("CHAEYOUNG");

    // when
    Optional<Channel> optional = channelRepository.findOne(predicate);

    // then
    assert optional.get().getName().equals(newChannel.getName());
  }

}