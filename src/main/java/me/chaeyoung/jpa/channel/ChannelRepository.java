package me.chaeyoung.jpa.channel;

import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryDefinition(domainClass = Channel.class, idClass = Long.class)
public interface ChannelRepository extends JpaRepository<Channel, Long> {

}