package kr.co.sist.aws.team2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.sist.aws.team2.service.PortfolioService;
import kr.co.sist.aws.team2.vo.PortfolioVO;
import kr.co.sist.aws.team2.vo.UserVO;

@Controller
public class PortfolioController {

	@Autowired
	private PortfolioService ps;

	@RequestMapping(value = "portfolio/portfolio.do", method = RequestMethod.GET)
	public String portfolio(HttpSession session, Model model) {
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		if (userVO == null) {
			return "redirect:http://localhost/third_prj/accounts/sign_in.do";
		}
		String id = userVO.getId();

		List<PortfolioVO> list = ps.loadAllPofol(id);
		model.addAttribute("portfolioData", list);

		return "portfolio/portfolio";
	}
	
}
