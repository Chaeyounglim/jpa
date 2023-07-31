package me.chaeyoung.jpa.user;


import me.chaeyoung.jpa.my.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, MyRepository<User> {


}