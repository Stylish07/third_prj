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
	
	public void insertProfile(ProfileVO profileVO) {
		String query = "insert into profile(idx, gender, phone, description, url, input_date, tech_idx, id) values(profile_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?)";
		
		jt.update(query, profileVO.getGender(), profileVO.getPhone(), profileVO.getDescription(), profileVO.getUrl(), profileVO.getTech_idx(), profileVO.getId());
	}
	
	public void updateProfile(ProfileVO profileVO) {
		String query = "update profile set gender = ?, phone = ?, description = ?, url = ?, tech_idx = ? where id = ?";
		
		jt.update(query, profileVO.getGender(), profileVO.getPhone(), profileVO.getDescription(), profileVO.getUrl(), profileVO.getTech_idx(), profileVO.getId());
	}
	
	public void insertImg(ProfileVO profileVO) {
		String query = "insert into profile(idx, img, id) values(profile_seq.nextval, ?, ?)";
		
		jt.update(query, profileVO.getImg(), profileVO.getId());
	}
	
	public void updateImg(ProfileVO profileVO) {
		String query = "update profile set img = ? where id = ?";
		
		jt.update(query, profileVO.getImg(), profileVO.getId());
	}

}
