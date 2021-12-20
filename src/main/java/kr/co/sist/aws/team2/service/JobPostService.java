package kr.co.sist.aws.team2.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.dao.JobPostDAO;
import kr.co.sist.aws.team2.vo.JobPostVO;

@Component
public class JobPostService {

	@Autowired
	JobPostDAO jobPostDAO;

	public List<JobPostVO> loadJobList() throws SQLException {
		List<JobPostVO> list = null;

		list = jobPostDAO.selectAllJobPost();

		return list;
	}

	public JobPostVO loadJobPost(String idx) throws SQLException {
		JobPostVO jobPostVO = new JobPostVO();

		jobPostVO = jobPostDAO.selectJobPost(idx);

		return jobPostVO;
	}

	public List<JobPostVO> loadJobTech(String tech_idx) throws DataAccessException, SQLException {
		List<JobPostVO> list = null;

		list = jobPostDAO.selectJobTech(tech_idx);
		
		return list;
	}

}
