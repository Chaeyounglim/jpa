package me.chaeyoung.jpa.mybatis.mapper;

import me.chaeyoung.jpa.mybatis.vo.AccountMyBatisVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper {

    List<AccountMyBatisVO> selectAll();

    AccountMyBatisVO selectAccountByUsername(@Param("username") String username);
    AccountMyBatisVO selectAccount(@Param("id") int id);

    void insertAccount(AccountMyBatisVO vo);
}