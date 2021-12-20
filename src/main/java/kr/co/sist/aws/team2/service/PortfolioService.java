package kr.co.sist.aws.team2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.dao.PortfolioDAO;
import kr.co.sist.aws.team2.vo.PortfolioVO;

@Component
public class PortfolioService {

	@Autowired
	private PortfolioDAO portfolioDAO;
	
	public List<PortfolioVO> loadAllPofol(String id) {
		List<PortfolioVO> list = null;
		
		list = portfolioDAO.selectAllPofol(id);
		
		return list;
	}
	
}
