package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.LanguageVO;

@Component
public class LanguageDAO {
	
	@Autowired(required = false)
	private JdbcTemplate jt;
	
	public LanguageVO selectLanguage(String id) throws SQLException, EmptyResultDataAccessException {
		LanguageVO languageVO = new LanguageVO();
		String query = "select * from language where id = ?";

		languageVO = jt.queryForObject(query, new Object[] { id }, new RowMapper<LanguageVO>() {

			@Override
			public LanguageVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				LanguageVO languageVO = new LanguageVO();

				languageVO.setIdx(rs.getInt("idx"));
				languageVO.setLang(rs.getString("lang"));
				languageVO.setExam_title(rs.getString("exam_title"));
				languageVO.setScore(rs.getString("score"));
				
				return languageVO;
			}

		});

		return languageVO;
	}
	
	public void insertLanguage(LanguageVO languageVO) {
		String query = "insert into language(idx, lang, exam_title, score, id) values(lang_seq.nextval, ?, ?, ?, ?)";
		
		jt.update(query, languageVO.getLang(), languageVO.getExam_title(), languageVO.getScore(), languageVO.getId());
	}
	
	public void updateLanguage(LanguageVO languageVO) {
		String query = "update language set lang = ?, exam_title = ?, score =? where id = ?";
		
		jt.update(query, languageVO.getLang(), languageVO.getExam_title(), languageVO.getScore(), languageVO.getId());
	}
	
	public void deleteLanguage(String id) {
		String query = "delete language where id =?";
		
		jt.update(query, id);
	}
	
}
