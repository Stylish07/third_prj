package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.JobPostVO;

@Component
public class JobPostDAO {

	@Autowired(required = false)
	private JdbcTemplate jt;

	public List<JobPostVO> selectAllJobPost() throws SQLException {
		List<JobPostVO> list = null;
		String query = "select * " + "from job_post jp, post_tech pt, tech_stack ts "
				+ "where jp.idx = pt.post_idx(+) and pt.tech_idx = ts.idx(+) " + "order by jp.idx desc";

		list = jt.query(query, new RowMapper<JobPostVO>() {

			@Override
			public JobPostVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				JobPostVO jobPostVO = new JobPostVO();

				jobPostVO.setCompany(rs.getString("company"));
				jobPostVO.setImg(rs.getString("img"));
				jobPostVO.setAddress(rs.getString("address"));
				jobPostVO.setInput_date(rs.getString("input_date"));
				jobPostVO.setId(rs.getString("id"));
				jobPostVO.setHomepage(rs.getString("homepage"));
				jobPostVO.setDescription(rs.getString("description"));
				jobPostVO.setSubject(rs.getString("subject"));
				jobPostVO.setIdx(rs.getInt("idx"));
				jobPostVO.setCareer(rs.getInt("career"));
				jobPostVO.setTech_idx(rs.getInt("tech_idx"));

				return jobPostVO;
			}

		});

		return list;
	}

	public JobPostVO selectJobPost(String idx) throws SQLException {
		JobPostVO jobPostVO = new JobPostVO();
		String query = "select * " + "from job_post jp, post_tech pt, tech_stack ts "
				+ "where jp.idx = pt.post_idx(+) and pt.tech_idx = ts.idx(+) and jp.idx = ?";

		jobPostVO = jt.queryForObject(query, new Object[] { idx }, new RowMapper<JobPostVO>() {

			@Override
			public JobPostVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				JobPostVO jobPostVO = new JobPostVO();

				jobPostVO.setCompany(rs.getString("company"));
				jobPostVO.setImg(rs.getString("img"));
				jobPostVO.setAddress(rs.getString("address"));
				jobPostVO.setInput_date(rs.getString("input_date"));
				jobPostVO.setId(rs.getString("id"));
				jobPostVO.setHomepage(rs.getString("homepage"));
				jobPostVO.setDescription(rs.getString("description"));
				jobPostVO.setSubject(rs.getString("subject"));
				jobPostVO.setIdx(rs.getInt("idx"));
				jobPostVO.setCareer(rs.getInt("career"));
				jobPostVO.setTech_idx(rs.getInt("tech_idx"));

				return jobPostVO;
			}
		});

		return jobPostVO;
	}

	public List<JobPostVO> selectJobTech(String tech_idx) throws SQLException, DataAccessException {
		List<JobPostVO> list = null;
		String query = "select * " + "from job_post jp, post_tech pt, tech_stack ts "
				+ "where jp.idx = pt.post_idx(+) and pt.tech_idx = ts.idx(+) and pt.tech_idx = ?";

		list = jt.query(query, new Object[] { tech_idx }, new RowMapper<JobPostVO>() {

			@Override
			public JobPostVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				JobPostVO jobPostVO = new JobPostVO();

				jobPostVO.setCompany(rs.getString("company"));
				jobPostVO.setImg(rs.getString("img"));
				jobPostVO.setAddress(rs.getString("address"));
				jobPostVO.setInput_date(rs.getString("input_date"));
				jobPostVO.setId(rs.getString("id"));
				jobPostVO.setHomepage(rs.getString("homepage"));
				jobPostVO.setDescription(rs.getString("description"));
				jobPostVO.setSubject(rs.getString("subject"));
				jobPostVO.setIdx(rs.getInt("idx"));
				jobPostVO.setCareer(rs.getInt("career"));
				jobPostVO.setTech_idx(rs.getInt("tech_idx"));
				
				return jobPostVO;
			}

		});

		return list;
	}

}
