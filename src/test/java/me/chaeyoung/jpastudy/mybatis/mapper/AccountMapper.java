package me.chaeyoung.jpastudy.mybatis.mapper;

import me.chaeyoung.jpastudy.mybatis.vo.AccountMyBatisVO;
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