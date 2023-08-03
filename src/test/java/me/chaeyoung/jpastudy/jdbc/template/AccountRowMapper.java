package me.chaeyoung.jpastudy.jdbc.template;

import me.chaeyoung.jpastudy.jdbc.vo.AccountVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<AccountVO> {
    @Override
    public AccountVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        var vo = new AccountVO();
        vo.setId(rs.getInt("id"));
        vo.setUsername(rs.getString("username"));
        vo.setPassword(rs.getString("password"));
        return vo;
    }
}
