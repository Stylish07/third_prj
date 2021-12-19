package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.NoticeVO;

@Component
public class NoticeDAO {

	@Autowired(required = false)
	private JdbcTemplate jt;
	
	public List<NoticeVO> selectAllNotice() throws SQLException {
		List<NoticeVO> list = null;
		String query = "select * from notice order by idx desc";
		
		list = jt.query(query, new RowMapper<NoticeVO>() {

			@Override
			public NoticeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				NoticeVO noticeVO = new NoticeVO();
				
				noticeVO.setIdx(rs.getInt("idx"));
				noticeVO.setCount(rs.getInt("count"));
				noticeVO.setTitle(rs.getString("title"));
				noticeVO.setDescription(rs.getString("description"));
				noticeVO.setInput_date(rs.getString("input_date"));
				noticeVO.setId(rs.getString("id"));
				
				return noticeVO;
			}
			
		});
		
		return list;
	}
	
	public NoticeVO selectNotice(String idx) throws SQLException {
		NoticeVO noticeVO = new NoticeVO();
		String query = "select * from notice where idx = ?";
		
		noticeVO = jt.queryForObject(query, new Object[] {idx}, new RowMapper<NoticeVO>() {

			@Override
			public NoticeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				NoticeVO noticeVO = new NoticeVO();
				
				noticeVO.setIdx(rs.getInt("idx"));
				noticeVO.setCount(rs.getInt("count"));
				noticeVO.setTitle(rs.getString("title"));
				noticeVO.setDescription(rs.getString("description"));
				noticeVO.setInput_date(rs.getString("input_date"));
				noticeVO.setId(rs.getString("id"));
				
				return noticeVO;
			}
			
		});
		
		return noticeVO;
	}
	
}
