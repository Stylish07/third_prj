package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.UserVO;

@Component
public class AccountsDAO {

	@Autowired(required = false)
	private JdbcTemplate jt;

	public List<UserVO> selectAllUser() throws SQLException {
		List<UserVO> list = null;
		String query = "select * from users order by id";

		list = jt.query(query, new RowMapper<UserVO>() {

			@Override
			public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserVO uservO = new UserVO();

				uservO.setId(rs.getString("id"));
				uservO.setName(rs.getString("name"));
				uservO.setEmail(rs.getString("email"));
				uservO.setInput_date(rs.getString("input_date"));

				return uservO;
			}

		});

		return list;
	}

}
