package kr.co.sist.aws.team2.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.co.sist.aws.team2.service.ProfileService;
import kr.co.sist.aws.team2.service.TechStackService;
import kr.co.sist.aws.team2.vo.ProfileVO;
import kr.co.sist.aws.team2.vo.TechStackVO;
import kr.co.sist.aws.team2.vo.UserVO;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService ps;
	@Autowired
	private TechStackService ts;

	@RequestMapping(value = "profile/profile.do", method = RequestMethod.GET)
	public String signInPage(@SessionAttribute("userVO") UserVO userVO, Model model) {
		ProfileVO profileVO = new ProfileVO();
		String id = userVO.getId();

		try {
			List<TechStackVO> tList = ts.SearchAllTech();
			model.addAttribute("tList", tList);

			profileVO = ps.loadProfile(id);
			model.addAttribute("profileVO", profileVO);
			
		} catch (SQLException e) {
			System.out.println("프로필 로딩중 sql엑셉션");
		} catch (EmptyResultDataAccessException e) {
			System.out.println("저장된 프로필이 없습니다.");
		}

		return "profile/profile";
	}

}
