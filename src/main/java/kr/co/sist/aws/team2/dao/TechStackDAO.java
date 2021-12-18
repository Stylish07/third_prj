package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.TechStackVO;

@Component
public class TechStackDAO {
	
	@Autowired(required = false)
	private JdbcTemplate jt;
	
	public List<TechStackVO> selectAllTech() throws SQLException {
		List<TechStackVO> list = null;
		String query = "select * from tech_stack";
		
		list = jt.query(query, new RowMapper<TechStackVO>() {

			@Override
			public TechStackVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				TechStackVO techStackVO = new TechStackVO();
				
				techStackVO.setIdx(rs.getInt("idx"));
				techStackVO.setSubject(rs.getString("subject"));
				
				return techStackVO;
			}
			
		});
		
		return list;
	}
	
}
