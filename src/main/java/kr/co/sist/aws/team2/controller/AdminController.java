package kr.co.sist.aws.team2.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sist.aws.team2.dao.AdminAccountDAO;
import kr.co.sist.aws.team2.service.AccountsService;
import kr.co.sist.aws.team2.service.JobPostService;
import kr.co.sist.aws.team2.vo.AdminVO;
import kr.co.sist.aws.team2.vo.JobPostVO;
import kr.co.sist.aws.team2.vo.UserVO;

@Controller
public class AdminController {

	@Autowired
	private AdminAccountDAO ad;
	@Autowired
	private AccountsService as;
	@Autowired
	private JobPostService js;

	@RequestMapping(value = "admin/admin.do", method = RequestMethod.GET)
	public String admin(HttpSession session, Model model) {
		AdminVO adminVO = (AdminVO) session.getAttribute("adminVO");		
		if (adminVO == null) {
			return "redirect:admin_login.do";
		}
		
		try {
			List<UserVO> userList = as.loadAllUser();
			model.addAttribute("userList", userList);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "admin/admin";
	}

	@RequestMapping(value = "admin/admin_login.do", method = RequestMethod.GET)
	public String adminLogin() {
		return "admin/admin_login";
	}

	@RequestMapping(value = "admin/admin_login_process.do", method = RequestMethod.POST)
	public String adminLoginProcess(String id, String password, Model model, HttpServletRequest request, RedirectAttributes ra) {
		AdminVO adminVO = new AdminVO();

		try {
			adminVO = ad.adminLogin(id, password);
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("adminVO", adminVO);
			
		} catch (EmptyResultDataAccessException e) {
			// 로그인 정보 없음
			ra.addFlashAttribute("login", false);

			return "redirect:admin_login.do";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "redirect:admin.do";
	}
	
	@RequestMapping(value = "admin/admin_job_post.do", method = RequestMethod.GET)
	public String adminJobPost(Model model) {
		try {
			List<JobPostVO> jobList = js.loadJobList();
			model.addAttribute("jobList", jobList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "admin/admin_job_post";
	}

}
