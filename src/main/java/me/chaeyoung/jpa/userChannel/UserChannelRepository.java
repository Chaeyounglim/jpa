package me.chaeyoung.jpa.userChannel;

import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryDefinition(domainClass = UserChannel.class, idClass = Long.class)
public interface UserChannelRepository extends JpaRepository<UserChannel, Long> {


}