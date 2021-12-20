package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.PortfolioVO;

@Component
public class PortfolioDAO {

	@Autowired(required = false)
	private JdbcTemplate jt;
	
	public List<PortfolioVO> selectAllPofol(String id) {
		List<PortfolioVO> list = null;
		String query = "select * from portfolio where id = ? order by idx";
		
		list = jt.query(query, new Object[] {id}, new RowMapper<PortfolioVO>() {

			@Override
			public PortfolioVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PortfolioVO portfolioVO = new PortfolioVO();
				
				portfolioVO.setIdx(rs.getInt("idx"));
				portfolioVO.setYear(rs.getInt("date_year"));
				portfolioVO.setProj_title(rs.getString("proj_title"));
				portfolioVO.setTeam(rs.getString("team"));
				portfolioVO.setUrl_link(rs.getString("url_link"));
				portfolioVO.setDescription(rs.getString("description"));
				portfolioVO.setId(rs.getString("id"));
				
				return portfolioVO;
			}
			
		});
		
		return list;
	}
	
}
