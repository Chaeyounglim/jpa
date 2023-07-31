package me.chaeyoung.jpa.test;

// TestApplication.java

import me.chaeyoung.jpa.my.MyRepository;
import me.chaeyoung.jpa.my.MyRepositoryRegistrar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(MyRepositoryRegistrar.class) // 빈 주입!
@SpringBootTest
public class MyRepositoryRegistrarTest {

    @Autowired
    MyRepository myRepository;

    @Test
    void myRepositoryTest() {
        // given
        var newData = "NEW DATA";
        var savedId = myRepository.save(newData);

        // when
        var savedData = myRepository.find(savedId);

        // then
        System.out.println(savedData);
    }
}