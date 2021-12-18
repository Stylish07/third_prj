package kr.co.sist.aws.team2.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.dao.TechStackDAO;
import kr.co.sist.aws.team2.vo.TechStackVO;

@Component
public class TechStackService {

	@Autowired
	private TechStackDAO techStackDAO;
	
	public List<TechStackVO> SearchAllTech() throws SQLException {
		List<TechStackVO> list = null;
		
		list = techStackDAO.selectAllTech();
		
		return list;
	}
	
}
