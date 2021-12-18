package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.UserVO;

@Component
public class SignInDAO {

	@Autowired(required = false)
	private JdbcTemplate jt;

	public UserVO signIn(String id, String password) throws SQLException, EmptyResultDataAccessException {
		UserVO userVO = new UserVO();
		String query = "select id, name, email, input_date from users where id = ? and password = ?";
		
		userVO = jt.queryForObject(query, new Object[] {id, password}, new RowMapper<UserVO>() {

			@Override
			public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserVO userVO = new UserVO();
				
				userVO.setId(rs.getString("id"));
				userVO.setName(rs.getString("name"));
				userVO.setEmail(rs.getString("email"));
				userVO.setInput_date(rs.getString("input_date"));
				
				return userVO;
			}
			
		});
		
		return userVO;
	}

}
