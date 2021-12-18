package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.ProfileVO;

@Component
public class ProfileDAO {

	@Autowired(required = false)
	private JdbcTemplate jt;

	public ProfileVO loadProfile(String id) throws SQLException, EmptyResultDataAccessException {
		ProfileVO profileVO = new ProfileVO();
		String query = "select * from profile where id = ?";

		profileVO = jt.queryForObject(query, new Object[] { id }, new RowMapper<ProfileVO>() {

			@Override
			public ProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProfileVO profileVO = new ProfileVO();

				profileVO.setIdx(rs.getInt("idx"));
				profileVO.setTech_idx(rs.getInt("tech_idx"));
				profileVO.setGender(rs.getString("gender"));
				profileVO.setPhone(rs.getString("phone"));
				profileVO.setDescription(rs.getString("description"));
				profileVO.setUrl(rs.getString("url"));
				profileVO.setImg(rs.getString("img"));
				profileVO.setInput_date(rs.getString("input_date"));
				profileVO.setId(rs.getString("id"));

				return profileVO;
			}

		});

		return profileVO;
	}

}
