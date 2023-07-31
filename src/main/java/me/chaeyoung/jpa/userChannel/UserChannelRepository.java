package me.chaeyoung.jpa.userChannel;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = UserChannel.class, idClass = Long.class)
public interface UserChannelRepository {


}