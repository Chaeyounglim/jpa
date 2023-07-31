package me.chaeyoung.jpa.channel;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Channel.class, idClass = Long.class)
public interface ChannelRepository {

}