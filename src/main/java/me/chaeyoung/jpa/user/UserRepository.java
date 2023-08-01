package me.chaeyoung.jpa.user;


import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query("SELECT u, u.password AS customPassword FROM User u WHERE u.username=?1")
  List<User> findByUsernameWithCustomField(String username, Sort sort);

  @Query("SELECT u  FROM User u WHERE u.username=?1")
  List<User> findByUsername(String username, Sort sort);
}