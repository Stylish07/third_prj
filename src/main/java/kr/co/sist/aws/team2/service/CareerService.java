package kr.co.sist.aws.team2.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.dao.CareerDAO;
import kr.co.sist.aws.team2.vo.CareerVO;

@Component
public class CareerService {
	
	@Autowired
	private CareerDAO cDAO;
	
	public CareerVO selectCareer(String id) throws SQLException {
		CareerVO cVO = null;
		
		cVO = cDAO.selectCareer(id);
		
		return cVO;
	}
	
}
