/*
package me.chaeyoung.jpa.channel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value=false)
class ChannelRepositoryTest {

    @Autowired
    private ChannelRepository channelRepository;

    @Test
    void insertSelectGroupTest(){

        // given
        var newChannel = Channel.builder().name("new-group").build();
        // type 은 null 로 들어갈 것임.

        // when
        var savedChannel = channelRepository.insertChannel(newChannel);

        // then
        var foundChannel = channelRepository.selectChannel(savedChannel.getId());
        // DB 에 select 쿼리문을 날리지 않고 영속성 컨텍스트 내에서 가져옴.
        assert foundChannel.getId().equals(savedChannel.getId());
    }

}*/
