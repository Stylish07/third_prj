package kr.co.sist.aws.team2.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sist.aws.team2.service.AccountsService;
import kr.co.sist.aws.team2.vo.UserVO;

@Controller
public class AccountsController {

	@Autowired
	private AccountsService as;

	@RequestMapping(value = "accounts/sign_in.do", method = RequestMethod.GET)
	public String signInPage() {
		return "accounts/sign_in";
	}

	@RequestMapping(value = "accounts/user_sign_in.do", method = RequestMethod.POST)
	public String userSignIn(String id, String password, HttpServletRequest request, RedirectAttributes ra) {
		UserVO userVO = new UserVO();

		try {
			userVO = as.signIn(id, password);

			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);

			return "redirect:/index.do";
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (EmptyResultDataAccessException e) {
			ra.addFlashAttribute("login", false);
		}

		return "redirect:sign_in.do";
	}

	@RequestMapping(value = "accounts/sign_out.do", method = RequestMethod.GET)
	public String signOut(HttpSession session) {
		session.invalidate();

		return "redirect:/index.do";
	}

}
