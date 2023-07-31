package me.chaeyoung.jpa;


import me.chaeyoung.jpa.user.User;
import me.chaeyoung.jpa.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
//@Transactional
@Rollback(value = false)
public class MyUserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  @Test
  void myUserRepositoryDeleteTest() {
    // given
    var newUser = User.builder().username("new user").password("new pass").build();
    userRepository.save(newUser);

    // when
    userRepository.delete(newUser);
  }


  @Test
  void myUserRepositoryFindNameAllTest() {
    // given
    var newUser1 = User.builder().username("new user1").password("new pass1").build();
    var newUser2 = User.builder().username("new user2").password("new pass2").build();
    var newUser3 = User.builder().username("new user3").password("new pass3").build();

    userRepository.save(newUser1);
    userRepository.save(newUser2);
    userRepository.save(newUser3);
/*
    // when
    var userNameList = userRepository.findNameAll();

    Assertions.assertThat(
        userNameList.containsAll(
            List.of(newUser1.getUsername(), newUser2.getUsername(), newUser3.getUsername())));*/
  }

}
