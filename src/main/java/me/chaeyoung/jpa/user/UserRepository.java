package me.chaeyoung.jpa.user;

import java.util.Optional;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserRepository {

  Optional<User> findByUsername(String username);
  // 해당 메서드 외에는 기능할 수 없도록 Repository 기능 제한

}