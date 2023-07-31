package me.chaeyoung.jpa.channel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ChannelRepository {

    @PersistenceContext
    EntityManager entityManager;
    // persistenceContext 를 주입받아서 EntityManager 를 사용한다.

    public Channel insertChannel(Channel channel){
        entityManager.persist(channel);
        return channel;
    }

    public Channel selectChannel(Long id) {
        return entityManager.find(Channel.class,id);
    }

}
