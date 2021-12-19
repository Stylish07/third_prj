package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.EducationVO;

@Component
public class EducationDAO {

	@Autowired(required = false)
	private JdbcTemplate jt;

	public EducationVO selectEducation(String id) throws SQLException, EmptyResultDataAccessException {
		EducationVO educationVO = new EducationVO();
		String query = "select * from education where id = ?";

		educationVO = jt.queryForObject(query, new Object[] { id }, new RowMapper<EducationVO>() {

			@Override
			public EducationVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EducationVO educationVO = new EducationVO();

				educationVO.setIdx(rs.getInt("idx"));
				educationVO.setUniv(rs.getString("univ"));
				educationVO.setMajor(rs.getString("major"));
				educationVO.setDegree(rs.getString("degree"));
				educationVO.setEnt(rs.getString("ent"));
				educationVO.setGrad(rs.getString("grad"));
				educationVO.setDescription(rs.getString("description"));
				educationVO.setScore(rs.getDouble("score"));
				educationVO.setMax_score(rs.getDouble("max_score"));
				
				return educationVO;
			}

		});

		return educationVO;
	}
	
	public void insertEducation(EducationVO educationVO) {
		String query = "insert into education(idx, univ, major, degree, ent, grad, score, max_score, description, id) values(edu_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		jt.update(query, educationVO.getUniv(), educationVO.getMajor(), educationVO.getDegree(), educationVO.getEnt(), educationVO.getGrad(), educationVO.getScore(), educationVO.getMax_score(), educationVO.getDescription(), educationVO.getId());
	}
	
	public void updateEducation(EducationVO educationVO) {
		String query = "update education set univ = ?, major = ?, degree = ?, ent = ?, grad = ?, score = ?, max_score = ?, description = ? where id = ?";
		
		jt.update(query, educationVO.getUniv(), educationVO.getMajor(), educationVO.getDegree(), educationVO.getEnt(), educationVO.getGrad(), educationVO.getScore(), educationVO.getMax_score(), educationVO.getDescription(), educationVO.getId());
	}
	
	public void deleteEducation(String id) {
		String query = "delete education where id =?";
		
		jt.update(query, id);
	}

}
