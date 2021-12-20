package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.AdminVO;

@Component
public class AdminAccountDAO {

	@Autowired(required = false)
	private JdbcTemplate jt;

	public AdminVO adminLogin(String id, String password) throws EmptyResultDataAccessException, SQLException {
		AdminVO adminVO = new AdminVO();
		String query = "select * from admin where id = ? and password = ?";

		adminVO = jt.queryForObject(query, new Object[] { id, password }, new RowMapper<AdminVO>() {

			@Override
			public AdminVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminVO adminVO = new AdminVO();

				adminVO.setId(rs.getString("id"));
				adminVO.setInput_date(rs.getString("input_date"));

				return adminVO;
			}

		});

		return adminVO;
	}

}
