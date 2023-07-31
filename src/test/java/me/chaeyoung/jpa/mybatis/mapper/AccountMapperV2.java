package me.chaeyoung.jpa.mybatis.mapper;

import me.chaeyoung.jpa.mybatis.vo.AccountMyBatisVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountMapperV2 {

    @Select("SELECT * FROM account")
    List<AccountMyBatisVO> selectAll();

    @Select("SELECT * FROM account WHERE username = #{username}")
    AccountMyBatisVO selectAccountByUsername(String username);

    @Select("SELECT * FROM account WHERE id = #{id}")
    AccountMyBatisVO selectAccount(Integer id);

    @Insert("INSERT INTO ACCOUNT (username, password) VALUES (#{username}, #{password})")
    void insertAccount(AccountMyBatisVO vo);
}