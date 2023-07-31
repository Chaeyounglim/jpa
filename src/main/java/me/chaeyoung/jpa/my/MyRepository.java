package me.chaeyoung.jpa.my;

import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface MyRepository<User, ID extends Serializable> extends Repository<User, ID> {

  Optional<User> findByUsername(String username);

}