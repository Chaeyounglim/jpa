/*
package me.chaeyoung.jpa.mybatis;

import me.chaeyoung.jpa.mybatis.configuration.DBConfiguration;
import me.chaeyoung.jpa.mybatis.mapper.AccountMapper;
import me.chaeyoung.jpa.mybatis.mapper.AccountMapperV2;
import me.chaeyoung.jpa.mybatis.vo.AccountMyBatisVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(DBConfiguration.class)
//@Disabled // 제한적인 TEST 환경으로 테스트 미수행
public class MyBatisTest {

    // Mapper 클래스를 받으려면 mapper.xml 빌드 해야하고, 그러려면 main 으로 옮겨서 해야함...
    @Autowired
    AccountMapper accountMapper;

    @Autowired
    AccountMapperV2 accountMapperV2;

    @Test
    @DisplayName("SQL Mapper - MyBatis 실습")
    void sqlMapper_MyBatisTest() {

        // when
        accountMapper.insertAccount(new AccountMyBatisVO("new user3", "new password3"));
        // 1. username 으로 데이터 조회하기
        var account = accountMapper.selectAccountByUsername("new user3");
        // 2. id 값으로 데이터 조회하기
        //var account = accountMapper.selectAccount(1);
        
        // 3. 전체 데이터 조회하기
*/
/*        boolean result = false;
        var accountList = accountMapper.selectAll();
        for(var i : accountList){
            System.out.println(i.getUsername());
            result = !i.getUsername().isEmpty();
        }
        assert result;*//*

        
        // then
        System.out.println(account.getUsername() + ' ' + account.getPassword() + ' ' + account.getId());
        assert !account.getUsername().isEmpty();
    }

    @Test
    @DisplayName("SQL Mapper - MyBatis V2 실습 (Annotation)")
    void sqlMapper_MyBatisV2Test() {
        // given

        // when
        System.out.println(accountMapper.hashCode());
        accountMapperV2.insertAccount(new AccountMyBatisVO("new user4", "new password4"));

        // 1. username 으로 데이터 조회하기
        var account = accountMapperV2.selectAccountByUsername("new user4");
        // 2. id 값으로 데이터 조회하기
        //var account = accountMapperV2.selectAccount(10);

        // 3. 전체 데이터 조회하기
*/
/*        boolean result = false;
        var accountList = accountMapperV2.selectAll();
        for(var i : accountList){
            System.out.println(i.getUsername());
            result = !i.getUsername().isEmpty();
        }
        assert result;*//*


        // then
        assert !account.getUsername().isEmpty();
    }


}*/
