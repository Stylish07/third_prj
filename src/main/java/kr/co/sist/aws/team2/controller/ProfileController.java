package kr.co.sist.aws.team2.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
	public String loadProfile(@SessionAttribute("userVO") UserVO userVO, Model model) {
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

	@RequestMapping(value = "profile/saveProfile.do", method = RequestMethod.POST)
	public String saveProfile(ProfileVO profileVO, @SessionAttribute("userVO") UserVO userVO) {
		profileVO.setId(userVO.getId());
		
		ps.saveProfile(profileVO);

		return "redirect:profile.do";
	}
	
	@RequestMapping(value = "profile/saveImg.do", method = RequestMethod.POST)
	public String saveImg(HttpServletRequest request, @SessionAttribute("userVO") UserVO userVO) {
		ProfileVO profileVO = new ProfileVO();
		profileVO.setId(userVO.getId());
		
		File saveDir = new File("E:/dev/workspace_spring/third_prj/src/main/webapp/resources/upload");
		int maxSize = 1024 * 1024 * 10;
		
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(request, saveDir.getAbsolutePath(), maxSize, "UTF-8",
					new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String imgName = mr.getFilesystemName("img");
		profileVO.setImg(imgName);
		
		ps.saveImg(profileVO);

		return "redirect:profile.do";
	}
	

}
