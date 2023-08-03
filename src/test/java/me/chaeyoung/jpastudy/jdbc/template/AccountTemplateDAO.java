package me.chaeyoung.jpastudy.jdbc.template;

import me.chaeyoung.jpastudy.jdbc.vo.AccountVO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class AccountTemplateDAO {

    private final JdbcTemplate jdbcTemplate;

    public AccountTemplateDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String ACCOUNT_INSERT = "INSERT INTO account(ID, USERNAME, PASSWORD) "
            + "VALUES((SELECT coalesce(MAX(ID), 0) + 1 FROM ACCOUNT A), ?, ?)";
    private final String ACCOUNT_SELECT = "SELECT * FROM account WHERE ID = ?";

    public Integer insertAccount(AccountVO accountVO) {
        // JdbcTemplate 을 사용할 때 생성된 키 (일반적으로 데이터베이스의 자동 생성된 ID)를 보관하는데 사용됩니다.
        // GeneratedKeyHolder 는 KeyHolder 인터페이스를 구현한 구체적인 클래스 중 하나로, 자동 생성된 키 값을 받아서 보관하는 기능
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // update 메서드를 사용하여 DB 에 insert 쿼리를 실행
        // 첫번째 매개변수로 람다식을 사용함. Connection 객체(con)을 입력받아 PreparedStatement 를 생성하고 반환.
        // 두번째 매개변수로 KeyHolder를 전달하고 있습니다. 이렇게 하면 DB가 자동으로 생성한 키를 KeyHolder에 저장.
        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(ACCOUNT_INSERT, new String[]{"id"});
            ps.setString(1, accountVO.getUsername());
            ps.setString(2, accountVO.getPassword());
            return ps;
        }, keyHolder);

        // DB에 새 계정 정보를 삽입한 후 해당 꼐정의 ID 값이 자동 생성됨.
        // KeyHolder 를 통해 자동 생성된 ID 값을 Integer 타입으로 반환.
        return (Integer) keyHolder.getKey();
    }

    public AccountVO selectAccount(Integer id) {
        return jdbcTemplate.queryForObject(ACCOUNT_SELECT, new AccountRowMapper(), id);
    }
}
