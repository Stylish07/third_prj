package kr.co.sist.aws.team2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.sist.aws.team2.service.ResumeService;
import kr.co.sist.aws.team2.service.ProfileService;
import kr.co.sist.aws.team2.vo.CareerVO;
import kr.co.sist.aws.team2.vo.CertificateVO;
import kr.co.sist.aws.team2.vo.EducationVO;
import kr.co.sist.aws.team2.vo.LanguageVO;
import kr.co.sist.aws.team2.vo.ProfileVO;
import kr.co.sist.aws.team2.vo.UserVO;

@Controller
public class ResumeController {

	@Autowired
	private ProfileService ps;
	@Autowired
	private ResumeService rs;

	@RequestMapping(value = "resume/resume.do", method = RequestMethod.GET)
	public String resume(Model model, HttpSession session) {
		UserVO userVO = (UserVO) session.getAttribute("userVO");

		if (userVO == null) {
			return "redirect:http://localhost/third_prj/accounts/sign_in.do";
		}
		String id = userVO.getId();

		try {
			// 프로필 불러오기
			ProfileVO profileVO = new ProfileVO();
			profileVO = ps.loadProfile(id);
			model.addAttribute("profileVO", profileVO);
		} catch (Exception e) {
		}

		try {
			// 경력 불러오기
			CareerVO careerVO = new CareerVO();
			careerVO = rs.loadCareer(id);
			model.addAttribute("careerVO", careerVO);
		} catch (Exception e) {
		}

		try {
			// 학력 불러오기
			EducationVO educationVO = new EducationVO();
			educationVO = rs.loadEducation(id);
			model.addAttribute("educationVO", educationVO);
		} catch (Exception e) {
		}

		try {
			// 자격 불러오기
			CertificateVO certificateVO = new CertificateVO();
			certificateVO = rs.loadCertificate(id);
			model.addAttribute("certificateVO", certificateVO);
		} catch (Exception e) {
		}

		try {
			// 외국어 불러오기
			LanguageVO languageVO = new LanguageVO();
			languageVO = rs.loadlanguage(id);
			model.addAttribute("languageVO", languageVO);
		} catch (Exception e) {
		}

		return "resume/resume";
	}

	@RequestMapping(value = "resume/resumeSave.do", method = RequestMethod.POST)
	public String resumeSave(HttpSession session, CareerVO careerVO, EducationVO educationVO,
			CertificateVO certificateVO, LanguageVO languageVO, String category) {
		UserVO userVO = (UserVO) session.getAttribute("userVO");

		if (userVO == null) {
			return "redirect:http://localhost/third_prj/accounts/sign_in.do";
		}
		String id = userVO.getId();

		switch (category) {
		case "career":
			careerVO.setId(id);
			rs.saveCareer(careerVO);

			break;
		case "education":
			educationVO.setId(id);
			rs.saveEducation(educationVO);

			break;
		case "certificate":
			certificateVO.setId(id);
			rs.saveCertificate(certificateVO);

			break;
		case "language":
			languageVO.setId(id);

			rs.saveLanguage(languageVO);

			break;
		}

		return "redirect:resume.do";
	}

	@RequestMapping(value = "resume/resumeReset.do", method = RequestMethod.POST)
	public String resumeReset(HttpSession session, String table) {
		UserVO userVO = (UserVO) session.getAttribute("userVO");

		if (userVO == null) {
			return "redirect:http://localhost/third_prj/accounts/sign_in.do";
		}
		String id = userVO.getId();

		switch (table) {
		case "career":
			rs.resetCareer(id);
			break;
		case "education":
			rs.resetEducatino(id);
			break;
		case "certificate":
			rs.resetCertificate(id);
			break;
		case "language":
			rs.resetLanguage(id);
			break;
		}

		return "redirect:resume.do";
	}

}
