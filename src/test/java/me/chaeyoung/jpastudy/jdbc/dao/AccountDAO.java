package me.chaeyoung.jpastudy.jdbc.dao;

import me.chaeyoung.jpastudy.jdbc.vo.AccountVO;

import java.sql.*;

public class AccountDAO {

    // jdbc 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private static final String url = "jdbc:postgresql://localhost:5432/messenger";
    private static final String username = "chaeyoung";
    private static final String password = "pass";

    // SQL 쿼리
    private final String ACCOUNT_INSERT = "INSERT INTO account(ID, USERNAME, PASSWORD) "
            + "VALUES((SELECT coalesce(MAX(ID), 0) + 1 FROM ACCOUNT A), ?, ?)";
    private final String ACCOUNT_SELECT = "SELECT * FROM account WHERE ID = ?";


    // CRUD 기능 메소드
    public Integer insertAccount(AccountVO vo) {
        var id = -1;
        try {
            String[] returnId = {"id"};
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.prepareStatement(ACCOUNT_INSERT, returnId);
            // 삽입된 행 또는 행에서 반환해야 할 열을 나타내는 열 이름 배열 변수 (returnId)
            stmt.setString(1, vo.getUsername());
            stmt.setString(2, vo.getPassword());
            stmt.executeUpdate(); // 해당 메서드는 update 한 갯수를 반환함.

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public AccountVO selectAccount(Integer id) {
        AccountVO vo = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.prepareStatement(ACCOUNT_SELECT);
            stmt.setInt(1, id);
            var rs = stmt.executeQuery();

            if (rs.next()) {
                vo = new AccountVO();
                vo.setId(rs.getInt("ID"));
                vo.setUsername(rs.getString("USERNAME"));
                vo.setPassword(rs.getString("PASSWORD"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vo;
    }

}
